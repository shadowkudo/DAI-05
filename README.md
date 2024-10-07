# Labo [Java IOs](https://github.com/heig-vd-dai-course/heig-vd-dai-course/tree/main/05-java-ios)

# Benchmark

Input in Terminal for WRITE
```Terminal
java -jar target/java-ios-1.0-SNAPSHOT.jar -i=<BINARY/BUFFERED_BINARY/TEXT/BUFFERED_TEXT> test.bin/test.txt write -s=<sizeInByte>
```
Input in Terminal for READ

```Terminal
java -jar target/java-ios-1.0-SNAPSHOT.jar -i=<BINARY/BUFFERED_BINARY/TEXT/BUFFERED_TEXT> test.bin/test.txt read
```

## Result with the time in [ms]

|  | BINARY | BUFFERED_BINARY | TEXT | BUFFERED_TEXT |
| ----------- | ----------- | ----------- | ----------- | ----------- |
| WRITE 1B (s=1) | 86 | 95 | 86 | 96 |
| READ 1B | 92 | 97 | 87 | 115 |
| WRITE 1KiB (s=1'024)| 86 | 86 | 103 | 88 |
| READ 1KiB | 93 | 87 | 88 | 86 |
| WRITE 1MiB (s=1'048'576)| 589 | 112 | 163 | 142 |
| READ 1MiB | 348 | 109 | 157 | 118 |
| WRITE 5MiB (s=5'242'880)| 2675 | 235 | 350 | 245 |
| READ 5MiB| 1392 | 170 | 318 | 200 |

## Conclusion

The conclusion is based on the result written [here](#result-with-the-time-in-ms).

### Which type of stream is the most efficient for each use case?
BUFFERED_BINARY seems to be the most efficient in all cases even more for bigger data chunks. 
### Why is it more efficient than the other types of streams?
Buffered streams are more efficient for larger data sizes because they reduce the number of I/O operations by aggregating data into a buffer before reading or writing it, thus reducing the overhead caused by multiple I/O system calls.

Binary is better than text as it doesn't need any conversion.
### What is the difference between binary data and text data?
Binary data consists of raw bytes while text data consists of human-readable characters and typically requires encoding schemes like UTF-8 or ASCII to convert characters to bytes.
### What is a character encoding?
Character encoding is a system that maps characters (such as letters, numbers, and symbols) to their corresponding binary representations. Common character encodings include UTF-8, ASCII, and UTF-16.
### Why is this benchmark methodology important?
 - The benchmark evaluates different stream types and buffer use, which directly translates to real-world application performance.
 - By comparing binary vs text and buffered vs unbuffered streams, developers can make informed choices based on performance needs.
 - Benchmarking like this provides empirical evidence for decision-making rather than assumptions.

To sum up, buffered Binary streams are the most efficient for handling large data, while unbuffered Binary streams are faster for small data sizes. This demonstrates the importance of choosing the correct stream type and buffering strategy based on the size of the data being handled.
