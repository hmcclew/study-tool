package cs3500.pa01.filesorter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Test;

/**
 * Class to test method for FileNameComparator
 */
class FileNameComparatorTest {

  /**
   * Tests that files are properly compared by filename
   */
  @Test
  public void testCompare() {
    Path p1 = Paths.get("vectors.md");
    Path p2 = Paths.get("arrays.md");
    Path p3 = Paths.get("spinner.pdf");

    ArrayList<Path> files = new ArrayList<>(Arrays.asList(p1, p2, p3));
    Collections.sort(files, new FileNameComparator());

    assertEquals(p1, files.get(2));
    assertEquals(p2, files.get(0));
    assertEquals(p3, files.get(1));
  }
}