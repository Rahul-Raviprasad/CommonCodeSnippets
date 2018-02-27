# Regular Expressions

in Javascript, you can construct it in 2 ways

Using a regular expression literal, which consists of a pattern enclosed between slashes, as follows:
```js
var re = /ab+c/; // faster than new RegExp('ab+c')
```

Regular expression literals provide compilation of the regular expression when the script is loaded. If the regular expression remains constant, using this can improve performance.

Or calling the constructor function of the RegExp object, as follows:

```js
var re = new RegExp('ab+c');
```
Using the constructor function provides runtime compilation of the regular expression. Use the constructor function when you know the regular expression pattern will be changing, or you don't know the pattern and are getting it from another source, such as user input.


Examples

```js
// when you want to remove all the non-digit characters from a string.
// this could be used for validation, anywhere from ensuring you get a phone numbers, pin codes or values as input where you are expecting numbers only.
var str = "3q41t5 31"; // here q, t and space are non digit characters
var new_str = str.replace(/\D+/g, ''); // the g after the regular expression is an option or flag that performs a global search, looking in the whole string and returning all matches.

```
