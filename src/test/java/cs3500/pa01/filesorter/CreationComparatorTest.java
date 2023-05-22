package cs3500.pa01.filesorter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class to test method for CreationComparator
 */
class CreationComparatorTest {

  Path testDirectory;
  Path p1;
  Path p2;

  /**
   * creates temporary files
   */
  @BeforeEach
  public void setup() throws IOException {
    testDirectory = Files.createTempDirectory("CreationCompareTest");
    p1 = Files.createTempFile(testDirectory, "test1", ".md");
    Files.setAttribute(p1, "basic:creationTime",
        FileTime.fromMillis(System.currentTimeMillis() - 50000));

    p2 = Files.createTempFile(testDirectory, "test2", ".md");
    Files.setAttribute(p2, "basic:creationTime",
        FileTime.fromMillis(System.currentTimeMillis() - 10000));
  }

  /**
   * Tests that files are properly compared by creation time
   */
  @Test
  public void testCompare() {
    ArrayList<Path> files = new ArrayList<>(Arrays.asList(p1, p2));

    Collections.sort(files, new CreationComparator());

    assertEquals(p1, files.get(0));
    assertEquals(p2, files.get(1));
  }

  /**
   * Tests that an improper file throws the correct exception
   */
  public void testException() throws IOException {
    Path p4 = Paths.get("SampleData", "spinner.pdf");

    ArrayList<Path> files = new ArrayList<>(Arrays.asList(p1, p2, p4));

    assertThrows(IOException.class, () -> Collections.sort(files, new CreationComparator()));
    assertEquals(0, new CreationComparator().compare(p2, p4));
  }
}