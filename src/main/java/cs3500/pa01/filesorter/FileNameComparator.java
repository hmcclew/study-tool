package cs3500.pa01.filesorter;

import java.nio.file.Path;
import java.util.Comparator;

/**
 * A comparator used for sorting files by file name
 */
public class FileNameComparator implements Comparator<Path> {

  /**
   * Compares the given path objects based on file name
   *
   * @param p1 first path object of comparison
   * @param p2 second path object of comparison
   * @return an integer associated with file name, either 0, 1, -1
   */
  @Override
  public int compare(Path p1, Path p2) {
    return p1.getFileName().compareTo(p2.getFileName());
  }
}
