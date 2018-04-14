# Functional Programming in javascript

## What is functional programming?
Functions are going to be the building blocks, they are going to be atomic.

In basic math set theory, you will see something like domain -> range

{1,2,3,4} --> {3,4,5,6}

or can be written as
input x -> [function f] -> Output f(x)

or we can write this as

f(x) = x+2


## Principles
* Predictable
Pure and declarative
* Safe
Immutable state
* Transparent
First Class state
* Modular
Composable first class closures


# Pure Function
example
```js
const add = (x,y) => {x+y;}

add(2,3) === 5;
```

This is pure, because it depends on the arguments and doesn't have any side effects, doesn't depend on the global state, doesn't mutate global state, doesn't print to standard output which is also considered to be a side effect.

Referentially transparent: means you can any day replace add(2,3) with 5 and it will have any affect on the program. It is guaranteed to be 5.

let see impure function examples

```js
let name = 'Rahul';

const getName = ()=>name;

const setName = (newName) => {
  name = newName;
};
const printName = ()=> {
  console.log(name.toUpperCase());
};
```

## Imperative vs Declarative

HOW to achieve the result.
```js
function doubleNumbers (numbers) {
  const doubled = [];
  for(let i = 0; i < number.length; i++ ) {
    doubled.push(numbers[i]*2);
  }
  return doubled;
}
doubleNumbers([1,2,3]);
// [2,4,6]
```

Declare WHAT the desired result is

```js
function doubleNumbers (numbers) {
  numbers.map(x=>x*2);
}
doubleNumbers([1,2,3]);
// [2,4,6]
```

## Immutable
create state, don't mutate it
```js
const hobbies = ['programming', 'reading', 'music'];

//typo + mutability
const firstTwoHobbies = hobbies.splice(0,2); // you typed splice accidentally instead of slice

console.log(firstTwoHobbies);
//['programming', 'reading']
console.log(hobbies);
// ['music'] but u wanted the original.

```

Object.freeze
immutable.js

```js
const hobbies = Object.freeze(['programming', 'reading', 'music']);

//typo + mutability
const firstTwoHobbies = hobbies.splice(0,2);
// this will give you a Type Error

```

## Free your state
```js
const createPoint = (x,y) => Object.freeze([x, y]);
const movePointBy = ([x,y],dx,dy) => {
  return Object.freeze([x+dx, y+dy]);
};

let point = createPoint(0,0);
point = movePointBy(point, 5,5);
point = movePointBy(point, -2,2);
console.log(point);
//[3,7]
```

## Pros
* Safety
* free undo/redo logs -- REDUX
* Explicit flow of data
* less memory usage(in certain cases)
* concurrency safety(in certain cases)

## Cons
* Verbose
* more object creation
* more garbage collection
* more memory usage
(alleviated by libs like immutable.js)

## First class functions

assign a function to variables and pass it as an arguments

## closures
encapsulation
```js
const createAdder = (x) => {
  return (y) => x+y;
};

const add3 = createAdder(3);
add3(3) == 6;
```
## Partial application
how to do it

```js
const partialFromBind = (fn, ...arg) => {
  return fn.bind(null, ...args);
};

const partial = (fn, ...args)=> {
  return (...otherArgs) => {
    return fn(...args, ...otherArgs);
  };
};
```

## Currying
```js
const add3 = add(3);
add3(2);
// 5

//how to achieve it

const add = x => y => x+y;

function add(x) {
  return function(y) {
    return x+y;
  };
}  

```

## an example

```js
// make map a curried function
const map = fn => array => array.map(fn);
//
const multiple = x => y => x * y;
// takes argument key then second object and returns the value of object [key]
const pluck = key => object => object[key];

const discount = multiply(0.98);
const tax = multiple(1.09);

const customRequest = request({
  headers: {'X-Custom': 'myKey'}
});

customRequest({url: '/cart/items'})
  .then(map(pluck('price')))
  .then(map(discount))
  .then(map(tax));


```

## composing closures
x -> [f] -> f(x) -> [g] -> g(f(x))

so we can change the above code to
```js
customRequest({url: '/cart/items'})
.then(
  map(
    compose(
      tax,
      discount,
      pluck('price')
    )
  )
);

```

# Using Recursion (might be more relevant in JS perf repo)
example factorial

4!  = 4*3*2*1

```js
const factorial = (n) => {
  // base case
  if(n < 2) {
    return 1;
  }
  return n * factorial(n-1);
};

factorial(4);
```

if you give a very big number like factorial(10000) it will fail as it will exceed the stack size

## Tail Call Optimization

more optimized example of above would be

```js
const factorial = (n, accum = 1) => {
  if(n<2) {
    return accum;
  }
  return factorial(n-1, n*accum);
};

/*
This is new feature in ES6
this time when the browser runs this, it will be smart enough to know with tail call
like factorial(4) is same as calling the function factorial(3, 4), so it doesn't create a new stack but replace the existing with factorial(3,4).
Now this factorial(3,4) is the same as calling factorial(2,12) and later calling factorial(1,24).

So the browser can optimize this and not increase the stack size.
*/
```

### Resources:
Professor frisby's Mostly Adequate guide to functional programming. - Brian Lonsdorf
https://drboolean.gitbooks.io/mostly-adequate-guide-old/content/

### Libraries to Check out:
* Lodash
* Ramba
* Rx
* Bacon.js
* Immutable.js
