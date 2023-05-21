package cs3500.pa01.sorter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class to test methods for FileSorter
 */
class FileSorterTest {

  Path p1;
  Path p2;
  Path p3;

  Path testDirectory;

  ArrayList<Path> files;

  FileSorter fs;

  /**
   * Resets the order of the files before each sorting method is tested
   * and creates temporary files
   */
  @BeforeEach
  public void setup() throws IOException {
    testDirectory = Files.createTempDirectory("FileSorterTest");
    p1 = Files.createTempFile(testDirectory, "test1", ".md");
    Files.setLastModifiedTime(p1, FileTime.fromMillis(System.currentTimeMillis() - 10000));
    Files.setAttribute(p1, "basic:creationTime",
        FileTime.fromMillis(System.currentTimeMillis() - 20000));

    p2 = Files.createTempFile(testDirectory, "test2", ".md");
    Files.setLastModifiedTime(p2, FileTime.fromMillis(System.currentTimeMillis() - 5000));
    Files.setAttribute(p2, "basic:creationTime",
        FileTime.fromMillis(System.currentTimeMillis() - 10000));

    p3 = Files.createTempFile(testDirectory, "test3", ".md");
    Files.setLastModifiedTime(p3, FileTime.fromMillis(System.currentTimeMillis() - 15000));
    Files.setAttribute(p3, "basic:creationTime",
        FileTime.fromMillis(System.currentTimeMillis() - 30000));

    files = new ArrayList<>(Arrays.asList(p2, p1, p3));
    fs = new FileSorter(files);
  }

  /**
   * Tests that files are sorted by their name
   */
  @Test
  public void testSortFileName() {
    fs.sort("filename");

    assertEquals(p1, files.get(0));
    assertEquals(p2, files.get(1));
    assertEquals(p3, files.get(2));
  }


  /**
   * Tests that files are sorted by their creation time
   */
  @Test
  public void testSortCreation() {
    fs.sort("created");

    assertEquals(p3, files.get(0));
    assertEquals(p1, files.get(1));
    assertEquals(p2, files.get(2));
  }

  /**
   * Tests that files are sorted by their modification time
   */
  @Test
  public void testSortModified() {
    fs.sort("modified");

    assertEquals(p3, files.get(0));
    assertEquals(p1, files.get(1));
    assertEquals(p2, files.get(2));
  }

  /**
   * Tests that an invalid ordering flag throws the correct exception
   */
  @Test
  public void testSortInvalid() {
    assertThrows(IllegalArgumentException.class, () -> fs.sort("size"));
  }

  /**
   * Tests that files can be properly retrieved from the class
   */
  @Test
  public void testGetFiles() {
    assertEquals(fs.files, fs.getFiles());
  }
}