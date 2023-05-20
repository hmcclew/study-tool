package cs3500.pa01.fileWriter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * A file writer that prints and saves all content to an .md file
 * with a given path
 */
public class MarkDownWriter implements FileWriter {

  /**
   * Writes the given String to the given filepath as an .md file
   *
   * @param path     where to write the contents
   * @param contents contents to write to the file
   */
  @Override
  public void writeToFile(Path path, String contents) {

    Path p = Path.of(path + ".md");

    byte[] data = contents.getBytes();

    try {
      Files.write(p, data, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}

