package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;

/**
 * Class to test the Driver for Pa02
 */
class DriverTest {

  @Test
  public void testMain() throws IOException {

    Path testDirectory = Files.createTempDirectory("DriverTest");

    Path p1 = Files.createTempFile(testDirectory, "test1", ".txt");
    Path p2 = Files.createTempFile(testDirectory, "test2", ".txt");
    Path p3 = Files.createTempFile(testDirectory, "test3", ".txt");

    String[] invalidArgs = new String[] {testDirectory.toString()};
    assertThrows(IndexOutOfBoundsException.class, () -> Driver.main(invalidArgs));

    String[] args = new String[] {testDirectory.toString(), "filename",
        testDirectory.resolve("output.txt").toString()};

    Driver.main(args);
  }

}