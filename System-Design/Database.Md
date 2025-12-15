# Summary of the ACID Introduction Lecture

The lecture introduces **ACID**, the four foundational properties of reliable database transactions:

- **Atomicity**
- **Consistency**
- **Isolation**
- **Durability**

These properties are essential not only for relational databases (Postgres, MySQL, SQL Server, Oracle)  
but also relevant to many NoSQL and graph databases.

---

## Before ACID → What Is a Transaction?

The instructor emphasizes that you must first understand what a **database transaction** actually is
at a fundamental level. Only then can you understand why ACID matters.

---

## Atomicity

The first deep dive focuses on **atomicity** — ensuring that a transaction’s operations **all succeed or all fail** as a single unit.  
It is one of the most important guarantees because it directly protects consistency.

---

## Isolation

Next, the lecture covers **transaction isolation** — what happens when multiple transactions run at the same time.

Key questions explored:

- What can these concurrent transactions see?
- What *shouldn’t* they see?

Understanding isolation is key to preventing unexpected or inconsistent behavior.

---

## Consistency

Consistency is discussed **after atomicity and isolation** because consistency is usually the *result*  
of enforcing the first two.

If one transaction reads partial changes from another, or sees data it shouldn’t,  
**consistency is violated**.

---

## Durability

Durability ensures that once a transaction is **committed**, its changes are **saved permanently** —  
even across crashes, power loss, or hardware failure.

Some NoSQL databases intentionally relax durability for speed, but understanding this tradeoff is important.

---

## Extras

The section concludes with a quiz designed to reinforce the ACID concepts.  
Each incorrect answer includes an explanation to guide proper understanding.
# Summary of the Database Transaction Lecture

This lecture explains **what a database transaction is**, why transactions exist, and how databases
manage commits, rollbacks, crashes, and read consistency.

---

## What Is a Transaction?

A **transaction** is a collection of SQL queries treated as **one logical unit of work**.

SQL databases contain structured, relational data spread across many tables, so a single query is often
not enough to perform a complete logical operation. For that reason, applications commonly execute
multiple queries inside a single transaction.

**Example:** Transferring $100 from Account A to Account B requires:
1. Read balance of Account A
2. Update Account A (subtract $100)
3. Update Account B (add $100)

These three queries must succeed or fail **together**.

---

## Transaction Lifespan

A transaction typically has three phases:

### **1. BEGIN**
Signals the start of a new transaction.

### **2. EXECUTE QUERIES**
You may run multiple queries (SELECT, UPDATE, INSERT, etc.).  
Changes made here are **not durable** yet — they are not permanently written to disk.

### **3. COMMIT**
Indicates all work is complete and should be **persisted**.  
This raises important implementation questions:

- Should the database persist each query to disk immediately?
- Or should it keep everything in memory and write once at commit?
- Immediate writes make rollback harder but commit fast.
- Deferred writes make rollback easy but commit slow.

Different databases make different trade-offs (e.g., PostgreSQL optimizes for fast commits).

---

## Rollback

A **ROLLBACK** discards all changes made during the transaction.

Rollback behavior depends on how the database handled writes:

- If previous operations were written to disk → rollback must **undo** those changes.
- If operations were kept in memory → rollback is cheap (just discard memory changes).

Databases maintain **undo/redo logs** to support rollback and crash recovery.

---

## Unexpected Transaction Endings (Crashes)

If a crash occurs:
- During the transaction → the database must automatically **rollback** when it restarts.
- During a commit → the outcome becomes ambiguous and must be handled carefully.

This is one of the hardest problems in database engineering.  
Each database engine (Postgres, SQL Server, MySQL, Oracle) solves it differently.

---

## Read-Only Transactions

Transactions are not only for modifications.  
A read-only transaction is useful when you need a **consistent snapshot** of the database.

Example: generating a financial report that should not change mid-query.

The transaction ensures:
- All reads reflect the database **as it looked at the moment the transaction began**.
- Concurrent changes do not affect the snapshot.

This ties directly into **isolation levels**, which are discussed in the next lecture.

---

## Example: Money Transfer Transaction

Given a table:

| Account ID | Balance |
|------------|---------|
| 1          | $1000   |
| 2          | $500    |

To transfer $100 from account 1 → account 2:

```sql
BEGIN;

SELECT balance FROM account WHERE id = 1;

-- Validate balance >= 100

UPDATE account SET balance = balance - 100 WHERE id = 1;
UPDATE account SET balance = balance + 100 WHERE id = 2;

COMMIT;
```
# Summary of the Atomicity Lecture

Atomicity is one of the four **ACID** properties that define reliable database behavior.  
It applies not only to relational databases but also to NoSQL, graph, time-series, and any system
that supports transactional operations.

---

## What Is Atomicity?

**Atomicity ensures that all queries inside a transaction succeed as one indivisible unit of work.**

- If **any** query fails, the **entire transaction must roll back**.
- Even if 99 out of 100 operations succeed, **one failure means none of them count**.
- A transaction is treated like an **atom**: it cannot be split into partially applied results.

Atomicity guarantees that no partial, inconsistent changes ever become visible.

---

## When Queries Fail

A query may fail due to:

- Constraint violations (e.g., negative balance)
- Duplicate primary key insert
- SQL syntax errors
- Any runtime exception

In all cases, atomicity requires the database to **undo all prior successful queries in the transaction**.

---

## What If the Database Crashes?

Atomicity also applies to **unexpected failures**, not just SQL errors.

- If the database crashes **before a COMMIT**, then **all uncommitted work must be rolled back**.
- When the database restarts, it must detect:
  - There was an in-progress transaction
  - It never reached commit
  - All partial writes must be undone

This requires databases to maintain undo/redo logs and recovery mechanisms.

Different engines implement this differently:
- PostgreSQL writes eagerly, making commits fast.
- Others buffer in memory, making rollbacks instant but commits slower.

There is no perfect approach—only trade-offs.

---

## Example: Money Transfer Failure

Account 1: `$1000`  
Account 2: `$500`

Transaction steps:
1. Check balance
2. Deduct $100 from account 1
3. Add $100 to account 2

If the database crashes after step 2 but before step 3:

| Account ID | Balance |
|-----------|----------|
| 1         | 900      |
| 2         | 500      |

This is **inconsistent** and violates atomicity.

The database must, on restart, **rollback** the debit and restore account 1's balance to `$1000`.

Some databases will not even allow startup until this cleanup completes.

Rollback for large transactions can take **minutes or even hours** depending on the engine.

---

## Key Takeaways

- Atomicity means **all-or-nothing**: a transaction cannot be partially applied.
- Any failure — SQL error, constraint issue, or system crash — must trigger a full rollback.
- Databases implement atomicity differently:
  - Some write changes as queries execute.
  - Others defer all writes until commit.
- Long transactions are dangerous because rollback and crash recovery become expensive.
- Maintaining atomicity is what prevents **data loss**, **money disappearing**, and **inconsistent views**.

---

## Summary Sentence

Atomicity ensures that a transaction is a single, indivisible unit of work:  
**Either everything happens, or nothing happens — even in the face of crashes.**

# Summary of the Isolation Lecture

Isolation is the **third ACID property** and one of the most subtle and critical aspects of database
behavior. It controls **how concurrent transactions see and affect shared data**, and what anomalies
(or “read phenomena”) can occur when many users are reading and writing at the same time.

---

## Why Isolation Matters

In a real system:

- Many **TCP connections** talk to the same database.
- Each connection may run **its own transactions**.
- These transactions might **read and write the same rows** at the same time.

Key questions isolation answers:

- Can my in-flight transaction **see uncommitted changes** made by another in-flight transaction?
- While I’m in one long transaction, should I see data that another transaction **committed partway** through mine?
- How do we prevent inconsistent, surprising, or incorrect reads?

Different answers → different **isolation levels** and **read phenomena**.

---

## Read Phenomena (Undesirable Behaviors)

These are classic anomalies that can happen under weaker isolation:

### 1. Dirty Read

> You read data that another transaction has written **but not committed yet**.

- If that other transaction **rolls back**, your read was based on data that **never “really” existed**.
- Result: reports, calculations, or decisions made on **temporary / dirty** state.

Example:  
Transaction A inserts/updates a value but hasn’t committed.  
Transaction B reads that value. Later A rolls back.  
B has now used **invalid data** in its logic.

---

### 2. Non-Repeatable Read

> Within a single transaction, you read the **same logical data twice** and get **different values**.

It’s not necessarily two identical SQL queries; it can be:

- First query: `SELECT column FROM table WHERE id = 1`
- Second query: `SELECT SUM(column) FROM table`

Both **depend** on the same row, but if another transaction changes that row between your two reads,
you get different results.

This is non-repeatable read: **your own transaction can’t “reproduce” the same read**.

---

### 3. Phantom Read

> You run a **range query** twice in one transaction and see **new rows appear** the second time.

Example:

- First query: `SELECT * FROM sales WHERE date BETWEEN '2025-01-01' AND '2025-01-31'`
- Another transaction inserts a **new row** that matches that date range and commits.
- Second query in your transaction now returns **extra rows** that weren’t there before.

It’s not the same row changing; it’s **new rows “appearing” in the range** → “phantoms”.

---

### 4. Lost Update

> Two concurrent transactions update the same row based on the **same old value**, and one update
> effectively **overwrites** the other.

Example:

- Both transactions read quantity = 10.
- T1 sets it to 10 + 10 = 20.
- T2 sets it to 10 + 5 = 15.
- Depending on who commits last, one update is **silently lost**.

This typically happens when there is **no locking or version checking** on writes.

---

## Isolation Levels

Isolation levels define **what phenomena are allowed**.

They are typically set with something like:

```sql
SET TRANSACTION ISOLATION LEVEL <LEVEL>;
```