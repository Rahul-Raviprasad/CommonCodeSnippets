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
