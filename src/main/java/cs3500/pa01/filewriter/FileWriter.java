package cs3500.pa01.filewriter;

import java.nio.file.Path;

public interface FileWriter {
  void writeToFile(Path path, String contents);
}
