package cs3500.pa01.sorter;

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
 * Class to test method for ModifiedComparator
 */
class ModifiedComparatorTest {

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
    Files.setLastModifiedTime(p1, FileTime.fromMillis(System.currentTimeMillis() - 10000));

    p2 = Files.createTempFile(testDirectory, "test2", ".md");
    Files.setLastModifiedTime(p1, FileTime.fromMillis(System.currentTimeMillis() - 50000));
  }
  /**
   * Tests that files are properly compared by modification time
   */

  @Test
  public void testCompare() {
    ArrayList<Path> files = new ArrayList<>(Arrays.asList(p2, p1));

    Collections.sort(files, new ModifiedComparator());

    assertEquals(p1, files.get(0));
    assertEquals(p2, files.get(1));
  }

  /**
   * Tests that an improper file throws the correct exception
   */
  public void testException() throws IOException {
    Path p3 = Paths.get("nonexistent.txt");

    ArrayList<Path> files = new ArrayList<>(Arrays.asList(p1, p2, p3));

    assertThrows(IOException.class, () -> Collections.sort(files, new ModifiedComparator()));
    assertEquals(0, new ModifiedComparator().compare(p2, p3));
  }
}