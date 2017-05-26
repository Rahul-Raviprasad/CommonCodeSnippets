## How to compare object (implementing class or not) like Employee, Car, Movie?
Some times we need to compare object say for sorting.
Like you want to compare the year when a movie got released and then sort them in a specific order.

### In Java
Java provides two interfaces to sort objects using data members of the class:
1. Comparable
2. Comparator

#### Comparable vs Comparator in Java
If sorting of objects needs to be based on natural order then use Comparable whereas if you sorting needs to be done on attributes of different objects, then use Comparator in Java.
