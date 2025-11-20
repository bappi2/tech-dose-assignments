# SOLID Principles

The **SOLID** principles are five object-oriented design guidelines introduced by Robert C. Martin to create maintainable, scalable, and robust software systems.

---

## 1. Single Responsibility Principle (SRP)
**Definition:** A class should have one and only one reason to change, meaning it should have just one job.

**Example:**  
❌ `Report` handles both report generation and email sending.  
✅ `ReportGenerator` handles reports; `EmailSender` handles emails.

**Benefit:** Improves maintainability and reduces coupling.

---

## 2. Open/Closed Principle (OCP)
**Definition:** Software entities should be open for extension but closed for modification.

**Example:**  
Avoid editing existing class logic; extend via inheritance or interfaces.

**Benefit:** Avoids breaking existing functionality when adding features.

---

## 3. Liskov Substitution Principle (LSP)
**Definition:** Subclasses must be substitutable for their base classes without altering the correctness of the program.

**Example:**  
A `Square` subclass of `Rectangle` should behave consistently with `Rectangle` expectations.

**Benefit:** Maintains integrity when using polymorphism.

---

## 4. Interface Segregation Principle (ISP)
**Definition:** Clients should not be forced to depend on interfaces they do not use.

**Example:**  
Split a large `IMachine` interface into `IPrinter`, `IScanner`, `IFax`.

**Benefit:** Keeps interfaces small and relevant.

---

## 5. Dependency Inversion Principle (DIP)
**Definition:** High-level modules should not depend on low-level modules; both should depend on abstractions.

**Example:**  
`PaymentService` depends on `PaymentProcessor` interface, not `CreditCardProcessor` directly.

**Benefit:** Increases flexibility and testability.

---

## Quick Reference
1. **S:** Single Responsibility — One reason to change.
2. **O:** Open/Closed — Open for extension, closed for modification.
3. **L:** Liskov Substitution — Subclasses must be replaceable for their base classes.
4. **I:** Interface Segregation — No unused method dependencies.
5. **D:** Dependency Inversion — Depend on abstractions, not details.
