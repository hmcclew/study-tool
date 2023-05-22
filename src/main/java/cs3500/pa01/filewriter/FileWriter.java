package cs3500.pa01.filewriter;

import java.nio.file.Path;

/**
 * Handles writing contents to a file
 */
public interface FileWriter {
  /**
   * writes contents to a file
   *
   * @param path the filepath to write contents
   * @param contents the contents to be written
   */
  void writeToFile(Path path, String contents);
}
