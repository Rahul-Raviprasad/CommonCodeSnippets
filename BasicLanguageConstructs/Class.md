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

Various types of classes in java
1. Nested class
2. Anonymous class
3. Lambda expressions

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

# Object

It is basic unit in most programming languages. It represents real life entities(Employee, Cup, TVRemote etc).
Objects have these properties
1. **State** : It is represented by attributes of an object. It also reflect the properties of an object.
2. **Behavior** : It is represented by methods of an object.
3. **Identity** : It gives a unique name to an object and enables one object to interact with other objects.


### Declaring Objects in Java
Objects in Java are created from a class template. This process is called instantiation. All the instances created from a class share the attribute and the behavior of the class, but the values of those objects are unique.

Declaring variables like "ClassType name;", notifies the compiler that we will use name to refer to data whose type is "ClassType". With a primitive variable, this declaration also reserves the proper amount of memory for the variable. So for reference variable, type must be strictly a concrete class name. We can’t create objects of an abstract class or an interface.
```
Employee Chintu;
```
The value of Chintu now is null until an object is actually created and assigned to it. Simply declaring a reference variable does not create an object. When we only declare a variable of a class type, only a reference is created (memory is not allocated for the object). To allocate memory to an object, we must use new(). So the object is always allocated memory on heap.

### Initializing an object

The new operator instantiates a class by allocating memory for a new object and returning a reference to that memory. The new operator also invokes the class constructor.

All classes have at least one constructor. If a class does not explicitly declare any, the Java compiler automatically provides a no-argument constructor, also called the default constructor. This default constructor calls the class parent’s no-argument constructor (as it contain only one statement i.e super();), or the Object class constructor if the class has no other parent (as Object class is parent of all classes either directly or indirectly).

#### Ways to create object of a class

There are four ways to create objects in java.Strictly speaking there is only one way(by using new keyword),and the rest internally use new keyword.

1. **Using new keyword** : It is the most common and general way to create object in java.
Example:
```java
// creating object of class Test
Test t = new Test();
```
2. **Using Class.forName(String className) method** : There is a pre-defined class in java.lang package with name Class. The forName(String className) method returns the Class object associated with the class with the given string name. We have to give the fully qualified name for a class. On calling new Instance() method on this Class object returns new instance of the class with the given string name.
```java
// creating object of public class Test
// consider class Test present in com.p1 package
Test obj = (Test)Class.forName("com.p1.Test").newInstance();
```
3. **Using clone() method**: clone() method is present in Object class. It creates and returns a copy of the object.

// creating object of class Test
Test t1 = new Test();

// creating clone of above object
Test t2 = (Test)t1.clone();


4. **Deserialization** : De-serialization is technique of reading an object from the saved state in a file.
```java
FileInputStream file = new FileInputStream(filename);
ObjectInputStream in = new ObjectInputStream(file);
Object obj = in.readObject();
```
5. Creating multiple objects by one type only (A good practice)

In real-time, we need different objects of a class in different methods. Creating a number of references for storing them is not a good practice and therefore we declare a static reference variable and use it whenever required. In this case, wastage of memory is less. The objects that are not referenced anymore will be destroyed by Garbage Collector of java.

In inheritance system, we use parent class reference variable to store a sub-class object. In this case, we can switch into different subclass objects using same referenced variable. Example:
class Animal {}

class Dog extends Animal {}
class Cat extends Animal {}

public class Test
{
    // using Dog object
    Animal obj = new Dog();

    // using Cat object
    obj = new Cat();
}       
Anonymous objects

 Anonymous objects are the objects that are instantiated but are not stored in a reference variable.

They are used for immediate method calling.
They will be destroyed after method calling.
They are widely used in different libraries. For example, in AWT libraries, they are used to perform some action on capturing an event(eg a key press).
In example below, when a key is button(referred by the btn) is pressed, we are simply creating anonymous object of EventHandler class for just calling handle method.
btn.setOnAction(new EventHandler()
{
    public void handle(ActionEvent event)
    {
        System.out.println("Hello World!");
    }
});
