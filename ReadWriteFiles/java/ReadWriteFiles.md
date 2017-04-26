# Read and write files in java

```java
// Use Scanner to read various types of data from a file.

import java.util.*;
import java.io.*;

class ScanMixed {
  public static void main(String args[]) throws IOException {
    int i;
    double d;
    boolean b;
    String str;

    // write output to file.
    FileWriter fOut = new FileWriter('test.txt');

    fOut.write("Testing Scanner 10 12.2 one true two false");
    fOut.close();

    FileReader fIn = new FileReader('Text.txt');

    Scanner src = new Scanner(fIn);

    // Read to end.
    /*
      Notice here the order of the data types is chosen in specific way. like int -> double -> string etc.
      Had double preceded int, then int block won't reach since nextDouble() method matches any numeric string.  
    */
    /* It is best to confirm with hasNext() method, else if next() is called then there is chance for it to throw   NoSuchElementException when no more input is present.
    */
    while(src.hasNext()) {
      if(src.hasNextInt()) {
        i = src.nextInt();
        System.out.println("int: " + i);
      } else if(src.hasNextDouble()) {
        d = src.nextDouble();
        System.out.println("Double: " + d);
      } else if(src.hasNextBoolean()) {
        b = src.nextBoolean();
        System.out.println("Boolean: " + b);
      } else {
        str = src.next();
        System.out.println("String: " + str);
      }
    }
    src.close();
  }
}
```
