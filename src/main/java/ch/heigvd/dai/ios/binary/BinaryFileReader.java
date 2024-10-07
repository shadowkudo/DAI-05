package ch.heigvd.dai.ios.binary;

import ch.heigvd.dai.ios.Readable;

import java.io.*;

/**
 * A class that reads binary files. This implementation reads the file byte per byte. It manages the
 * file input stream properly with a try-catch-finally block.
 */
public class BinaryFileReader implements Readable {

  @Override
  public void read(String filename) {
    //throw new UnsupportedOperationException("Please remove this exception and implement this method.");

    InputStream fis = null;

    try {
      fis = new FileInputStream(filename);

      int b;
      while ((b = fis.read()) != -1) {
        // simulation for benchmark -> do nothing
      }

    } catch (Exception e) {
      System.err.println("Error -> " + e.getMessage());
    } finally {
      if (fis != null){
        try {
          fis.close();
        } catch (IOException e){
          System.err.println("Error closing fis -> " + e.getMessage());
        }
      }
    }
  }
}
