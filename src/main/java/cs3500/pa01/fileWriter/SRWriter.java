package cs3500.pa01.fileWriter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * A file writer that prints and saves all content to an .sr file
 * with a given path
 */
public class SRWriter implements FileWriter {

  /**
   * Writes the given String to the given filepath as an .sr file
   *
   * @param path     where to write the contents
   * @param contents contents to write to the file
   */
  public void writeToFile(Path path, String contents) {

    Path p = Path.of(path + ".sr");

    byte[] data = contents.getBytes();

    try {
      Files.write(p, data, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}

