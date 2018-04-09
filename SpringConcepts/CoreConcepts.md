##Overview


## Dependency Injection

What problems you run into if you don't use Dependency injection?

Let say we have the following structure in our program with 2 classes as shown below.
```java
Class Restaurant {

  Tea tea = new Tea();

  public void prepareHotDrink() {
    tea.prepareTea();
  }

}

Class Tea {
  public void prepareTea() {
    System.out.println("Tea is ready");
  }
}
```
What are the 3 problems you will run into in the future?
1. Problem 1: Replacing Tea class in the future with another class like MasalaTea.
So now you need to do code change in Restaurant Class, this might look simple in this example as it is a 1 line change.
But in a big real world problem, there will be multiple place the class will be used, like imagine Restaurant like other classes Hotel, Dhaba, House, TeaPoint and so on. If you miss in one place it can cause lot of time to debug and find the issue. Even if no mistake is done, this takes a lot of development and later testing effort and QA sign off that no regression got introduced.

2. Problem 2: Modifying the tea class for example parameterizing the its constructor
3. Problem 3: You can't test Restaurant class without including Tea class ie. without including it's dependencies.

Few things to note:-
* Restaurant class is dependent on Tea class
* These classes are tightly coupled

Using the Dependency injection concept, we should never create an object inside another class, using a new operator.
We would like to outsource the task of handling all dependencies of an object to some third-party (Instead of re inventing the wheel).
So the idea is that, when a class has Dependency like the Restaurant class, then when its object is created, the dependencies (like Tea) are dynamically created and provided to it from outside.

To decouple the classes in our case, we can introduce an interface.
```java
interface IHotDrink {
  public void prepareTea();
}
// lets modify the Tea class to implement this interface
Class Tea implements IHotDrink {
  public void prepareTea() {
    System.out.println("Tea ready");
  }
}

// Now in the Restaurant class, we will implement a constructor or a setter method for the third party to create a Tea object and it for us.
Class Restaurant {
  IHotDrink hotDrink;

  //constructor: so when creating Restaurant itself you the third party DI passes the tea object
  Restaurant(IHotDrink hotDrink) {
    hotDrink = this.hotDrink;
  }

  // we can also get it passed from a setter method
  public void setHotDrink(IHotDrink hotDrink) {
    hotDrink = this.hotDrink;
  }

  // the old method
  public void prepareHotDrink() {
    hotDrink.prepareTea();
  }
}
```
Now we simply have to instruct whatever DI system we are using to pass the object when the constructor of the dependent class is called.
In the case of Spring we will mention in the configuration file.


### Commonly used terms
* Wiring: The act of creating associations between different application components is called wiring. In spring there are different ways to wire components, one such way is via XML.
In a spring application, an application context loads bean definition and wires them together.

### Multiple Containers in Spring
Spring  comes with several container implementations that can be categorized into two distinct types.
1. Bean factories  (defined  by the org.springframework.beans.factory.BeanFactory  interface) are the  simplest of containers, providing basic  support for  DI.
2. Application contexts  (defined  by the org.springframework.context.ApplicationContext  interface) build on the notion of a  bean  factory by providing application  framework services, such  as the ability  to resolve textual messages from  a properties file  and  the  ability to publish application events  to  interested event  listeners.

* it’s  possible  to  work with  Spring  using  either bean factories or  application contexts, bean factories are often too low-level for most applications.
* Therefore,  application  contexts  are  preferred  over bean factories.
