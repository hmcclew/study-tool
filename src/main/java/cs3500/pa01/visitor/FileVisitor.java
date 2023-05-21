package cs3500.pa01.visitor;

import static java.nio.file.FileVisitResult.CONTINUE;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

/**
 * A file visitor that collects all the regular ".md" files in a given directory and
 * its subdirectories
 */
public class FileVisitor implements java.nio.file.FileVisitor<Path> {

  ArrayList<Path> files = new ArrayList<>();

  /**
   * Returns the list of files collected by this instance
   *
   * @return the list of files collected by this instance
   */
  public ArrayList<Path> getFiles() {
    return this.files;
  }

  /**
   * Visits a file and adds its path to the list of files if it has a ".md" extension and
   * is a regular file
   *
   * @param file the file being visited
   * @param attr the file's attributes
   * @return the visit result
   */
  @Override
  public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
    String fileName = file.toString();
    if (fileName.endsWith(".md") && attr.isRegularFile()) {
      files.add(file);
    }
    return CONTINUE;
  }

  /**
   * Called for a directory after paths in the directory are visited
   *
   * @param dir  the directory being visited
   * @param exec either null or the exception that caused visit termination
   * @return the visit result
   */
  @Override
  public FileVisitResult postVisitDirectory(Path dir, IOException exec) {
    return CONTINUE;
  }

  /**
   * Called for a directory before paths in the directory are visited
   *
   * @param dir   the directory being visited
   * @param attrs the directory attributes
   * @return the visit result
   */
  @Override
  public FileVisitResult preVisitDirectory(Path dir,
                                           BasicFileAttributes attrs) throws IOException {
    return CONTINUE;
  }

  /**
   * Called for a file that failed to be visited
   *
   * @param file the file that failed be visited
   * @param exc  the I/O exception that prevented the file from being visited
   * @return the visit result
   */
  @Override
  public FileVisitResult visitFileFailed(Path file, IOException exc) {
    System.err.println(exc);
    return CONTINUE;
  }

}
