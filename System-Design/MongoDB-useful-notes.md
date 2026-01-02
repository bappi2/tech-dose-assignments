MOST-USED MONGOSH COMMANDS (Cheat Sheet)
1. Connecting & Basic Info
   mongosh
   mongosh "mongodb://localhost:27017"
2. mongosh "mongodb://root:example@localhost:27017/?authSource=admin"

Check current DB
db

List all databases
show dbs

Switch to a database (creates if not exists)
use mydb

2. Working With Collections
   List all collections
   show collections

Create a collection
db.createCollection("users")

Drop a collection
db.users.drop()

3. Insert Documents
   Insert one
   db.users.insertOne({ name: "Areeb", age: 17 })

Insert many
db.users.insertMany([
{ name: "John", age: 22 },
{ name: "Sarah", age: 25 }
])

4. Query Documents (Very Common)
   Find all
   db.users.find()

Pretty print
db.users.find().pretty()

Find with filter
db.users.find({ age: { $gt: 20 } })

Find one
db.users.findOne({ name: "Areeb" })

5. Update Documents
   Update one
   db.users.updateOne(
   { name: "Areeb" },
   { $set: { age: 18 } }
   )

Update many
db.users.updateMany(
{ age: { $lt: 18 } },
{ $set: { status: "minor" } }
)

Replace
db.users.replaceOne(
{ name: "Areeb" },
{ name: "Areeb", age: 18, status: "active" }
)

6. Delete Documents
   Delete one
   db.users.deleteOne({ name: "John" })

Delete many
db.users.deleteMany({ age: { $gt: 30 } })

7. Indexes (Very Common in Real Projects)
   Create index
   db.users.createIndex({ email: 1 })

List indexes
db.users.getIndexes()

8. Aggregation (Super Important)
   Basic pipeline
   db.users.aggregate([
   { $match: { age: { $gt: 20 } } },
   { $group: { _id: "$status", avgAge: { $avg: "$age" } } }
   ])

9. Admin Commands
   Server status
   db.serverStatus()

Current operations
db.currentOp()

10. Helpful Shell Utilities
    Clear the screen
    cls

Show help
help
db.help()

🔥 TL;DR – Commands you will use DAILY
show dbs
use mydb
show collections
db.collection.find()
db.collection.insertOne()
db.collection.updateOne()
db.collection.deleteOne()
db.collection.aggregate()
