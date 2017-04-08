## Python's open() BIF

Python has a Built in Function(BIF) which is basically meant for interacting with files.

The basic input mechanism is line based: when read into your program from a text file, data will come line by line.

when open() is used then the object comes with an iterator, to feed the line of data, into into our program one line at a time.

once you are done with the file you need to call close on the file object given by open.

```Python
file_data = open('file_name.txt')
# Process the data
# Once done close this
file_data.close()
```
