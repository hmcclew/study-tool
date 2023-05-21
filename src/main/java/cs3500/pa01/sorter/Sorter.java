package cs3500.pa01.sorter;

import java.nio.file.Path;
import java.util.ArrayList;

public interface Sorter {

  ArrayList<Path> getFiles();

  void sort(String orderingMethod);
}
