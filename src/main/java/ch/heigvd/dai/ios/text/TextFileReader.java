package ch.heigvd.dai.ios.text;

import ch.heigvd.dai.commands.Read;
import ch.heigvd.dai.ios.Readable;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * A class that reads text files. This implementation reads the file byte per byte. It manages the
 * file reader properly with a try-catch-finally block.
 */
public class TextFileReader implements Readable {

  @Override
  public void read(String filename) {
    //throw new UnsupportedOperationException("Please remove this exception and implement this method.");

    Reader reader = null;

    try {
      reader = new FileReader(filename, StandardCharsets.UTF_8);

      int c;
      while ((c = reader.read()) != -1) {
        //simulation for benchmark -> do nothing
      }
    } catch (IOException e) {
      System.err.println("Error -> " + e.getMessage());
    } finally {
      if (reader != null){
        try {
          reader.close();
        } catch (IOException e){
          System.err.println("Error closing reader -> " + e.getMessage());
        }
      }
    }
  }
}
