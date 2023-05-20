package cs3500.pa01.sorter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Comparator;

/**
 * A comparator used for sorting files by modification time
 */
public class ModifiedComparator implements Comparator<Path> {

  /**
   * Compares the given path objects based on last modification time
   *
   * @param p1 first path object of comparison
   * @param p2 second path object of comparison
   * @return an integer associated with last modification time, either 0, 1, -1
   */
  @Override
  public int compare(Path p1, Path p2) {
    try {
      BasicFileAttributes attrs1 = Files.readAttributes(p1, BasicFileAttributes.class);
      BasicFileAttributes attrs2 = Files.readAttributes(p2, BasicFileAttributes.class);
      FileTime time1 = attrs1.lastModifiedTime();
      FileTime time2 = attrs2.lastModifiedTime();
      return time1.compareTo(time2);
    } catch (IOException e) {
      e.printStackTrace();
      return 0;
    }
  }
}


