# The Four Pillars of Object-Oriented Programming (OOP)

## 1. Abstraction
Abstraction is the process of exposing only the essential features of an object to the outside world while hiding internal implementation details.

**Example:**  
When you turn on a TV, you simply press the power button on the remote — you don’t need to understand how infrared signals are generated and processed internally.

---

## 2. Encapsulation
Encapsulation means bundling data (fields) and related operations (methods) into a single unit — typically a class. It also enforces **data hiding** by restricting direct access to internal state through access modifiers (e.g., `private`) and exposing controlled access via public methods or properties.

**Benefit:**  
Improves data security and integrity.

---

## 3. Inheritance
Inheritance allows a class (child/subclass) to acquire the properties and behaviors of another class (parent/superclass).

**Benefits:**
- Promotes code reuse
- Supports customization and extension of existing functionality

**Example:**  
A `Car` class can inherit from a `Vehicle` class, automatically gaining its attributes like `speed` and methods like `start()`.

---

## 4. Polymorphism
Polymorphism means "many forms" (from Greek: *poly* = many, *morph* = form). It enables the same operation to behave differently on different classes.

**Example:**  
A `draw()` method in a `Shape` base class may have different implementations in `Circle`, `Rectangle`, and `Triangle` subclasses.

## OOP Four Pillars – Quick Reference

1. **Abstraction** – Show only essential details, hide internal complexity.
2. **Encapsulation** – Bundle data and methods in a class, restrict direct access via access modifiers.
3. **Inheritance** – Create new classes from existing ones to reuse and extend functionality.
4. **Polymorphism** – Same interface, different implementations; enables method overriding and overloading.

# Code Example: Before and After Applying OOP Pillars

## ❌ Before – Procedural Approach
```java
public class ShapeApp {
    public static void main(String[] args) {
        String shapeType1 = "Circle";
        double radius = 5;

        String shapeType2 = "Rectangle";
        double width = 4;
        double height = 6;

        // Calculating area manually for each type
        double circleArea = Math.PI * radius * radius;
        double rectangleArea = width * height;

        System.out.println(shapeType1 + " area: " + circleArea);
        System.out.println(shapeType2 + " area: " + rectangleArea);
    }
}
```
## After – OOP Applied
```java
// 1. Abstraction – Shape defines the essential behavior.
abstract class Shape {
    public abstract double calculateArea();
}

// 2. Encapsulation – Fields are private; access through constructor.
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}

// 3. Inheritance – Circle and Rectangle extend Shape.
// 4. Polymorphism – Uniform handling of different shapes.
public class ShapeApp {
    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle(5),
            new Rectangle(4, 6)
        };

        for (Shape shape : shapes) {
            System.out.println(shape.getClass().getSimpleName() + " area: " + shape.calculateArea());
        }
    }
}
```
## This example 
Abstraction: Shape defines calculateArea() without revealing how each shape calculates it.

Encapsulation: Fields like radius, width, and height are private, ensuring controlled access.

Inheritance: Circle and Rectangle reuse structure from Shape.

Polymorphism: calculateArea() works differently depending on the actual object type.