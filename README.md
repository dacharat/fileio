# fileio 
>by Dacharat Pankong(5910546643)

Task                                        |Time(sec)
--------------------------------------------|-----------:
Copy file one byte at a time                |11.618320
Copy file 1 KB at a time                    |0.015892
Copy file 4 KB at a time                    |0.006251
Copy file 64 KB at a time                   |0.002985
Copy a file by BufferReader                 |0.088891
Copy a file by BufferReader and BufferWriter|0.007128

##Explain
>Copy file one byte at the time is the slowest because it copy one byte for each time, and copy file 64 KB at a time is the fastest because it copy 64 KB for each time. And use BufferWriter is faster than PrintWriter because it can write String, Character without change to byte. 
