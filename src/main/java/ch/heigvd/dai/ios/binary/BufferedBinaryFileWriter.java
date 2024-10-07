package ch.heigvd.dai.ios.binary;

import ch.heigvd.dai.ios.Writable;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * A class that writes binary files. This implementation writes the file using a buffered output
 * stream. It manages the file output stream properly with a try-with-resources block.
 */
public class BufferedBinaryFileWriter implements Writable {

  @Override
  public void write(String filename, int sizeInBytes) {
    //throw new UnsupportedOperationException("Please remove this exception and implement this method.");
    try (OutputStream fos = new FileOutputStream(filename);
         BufferedOutputStream bos = new BufferedOutputStream(fos)) {

      for (int i = 0; i < sizeInBytes; i++) {
        bos.write(i);
      }

      bos.flush();

    } catch (IOException e) {
      System.err.println("Error -> " + e.getMessage());
    }
  }
}
