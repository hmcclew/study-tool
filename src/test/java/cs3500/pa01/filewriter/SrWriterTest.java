package cs3500.pa01.filewriter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;

class SrWriterTest {

  /**
   * Tests that a file is correctly written to an output location
   */
  @Test
  public void testWriteToFile() {
    FileWriter srWriter = new SrWriter();
    String content = "test string sr";
    Path p1 = Paths.get("TestFiles", "Test2.sr");

    srWriter.writeToFile(p1, content);

    String fileContent = null;
    try {
      fileContent = Files.readString(p1);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    assertEquals(content, fileContent);
  }
}