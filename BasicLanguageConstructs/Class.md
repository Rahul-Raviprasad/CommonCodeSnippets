# Class
Class is common way to define a template for creating objects in many Languages.

### Java

In Java class declarations can include these components, in order:

**Modifiers** : A class can be public or has default access. Because it make no sense for class to be private or protected access specifiers and will give compilation error.
following program fails in compilation. Nested interfaces and classes can have all access specifiers.
```java
//File: Main.java
private class MyPrivateClass {}

public class Main {
    public static void main(String[] args) {
        System.out.println("This will never compile");
    }
}
```
**Superclass(if any)**: The name of the class’s parent (superclass), if any, preceded by the keyword extends. A class can only extend (subclass) one parent.
**Interfaces(if any)**: A comma-separated list of interfaces implemented by the class, if any, preceded by the keyword implements. A class can implement more than one interface.

example
```java
public class Person {
  private int age;
  private double height;
  private String name;

  public String getName() {
    return name;
  }

  // constructor method
  public Person(String name) {
    this.name = name;
  }
}

```
