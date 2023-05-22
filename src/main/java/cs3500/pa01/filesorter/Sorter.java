package cs3500.pa01.filesorter;

import java.nio.file.Path;
import java.util.ArrayList;

/**
 * Handles sorting files
 */
public interface Sorter {
  /**
   * getter method for the files to be sorted
   *
   * @return all files to be sorted
   */
  ArrayList<Path> getFiles();

  /**
   * Sorts all files
   *
   * @param orderingMethod the method to order all files
   */
  void sort(String orderingMethod);
}
