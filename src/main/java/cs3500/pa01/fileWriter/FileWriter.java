package cs3500.pa01.fileWriter;

import java.nio.file.Path;

public interface FileWriter {
  void writeToFile(Path path, String contents);
}
