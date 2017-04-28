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
example

```Python
# importing os from the standard library
import os
# get the current working directory
os.getcwd()
# change the path to the directory where the file is
os.chdir('../data')
# get the current working directory again to confirm you changed correctly

data =  open('file_name.txt')
# using read line to get a line from our file and print it.
print(data.readline(), end='')

# rewind back to start of a file.
data.seek(0)

for each_line in data
    print(each_line, end='')

# once you are done with reading the file make you close it.
data.close()


```
