package cs3500.pa01.filesorter;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;

/**
 * A file sorter that sorts an arraylist of files by calling a different
 * comparator based on a given parameter
 */
public class FileSorter implements Sorter {

  ArrayList<Path> files = new ArrayList<>();

  public FileSorter(ArrayList<Path> files) {
    this.files = files;
  }

  /**
   * Gets all the files contained in this instance
   *
   * @return all files in this instance as an arraylist
   */
  public ArrayList<Path> getFiles() {
    return this.files;
  }

  /**
   * Sorts all files using a comparator that corresponds to the parameter
   *
   * @param orderingFlag the indicator for how files should be sorted
   * @throws IllegalArgumentException if the orderingFlag does not
   *                                  correspond to one of three allowed and implemented comparators
   */
  public void sort(String orderingFlag) {
    if (orderingFlag.equals("filename")) {
      Collections.sort(files, new FileNameComparator());
    } else if (orderingFlag.equals("created")) {
      Collections.sort(files, new CreationComparator());
    } else if (orderingFlag.equals("modified")) {
      Collections.sort(files, new ModifiedComparator());
    } else {
      throw new IllegalArgumentException("Files may only be sorted by "
          +
          "filename, creation, and modification");
    }
  }

}

