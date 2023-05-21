package cs3500.pa01;

import cs3500.pa01.controller.Controller;
import cs3500.pa01.controller.StudyGuideController;

/**
 * This is the main driver of this project.
 */
public class Driver {
  /**
   * Project entry point
   * Executes a program that reads through files in a given directory,
   * pulls out all .md regular files, sorts them based on a given ordering flag,
   * and saves all their contents into a new .md file in this order
   *
   * @param args - array of command line arguments
   *             There will be either 3 command line arguments, or 0
   *             The first argument is the directory of files to be walked
   *             The second argument is the ordering flag, either "filename", "modified",
   *             or "created"
   *             The third argument is absolute or relative path and name for saving the output
   *             to a new .md file
   *             If there are no command line arguments, the Driver will enter into Study Session
   *             Mode
   */
  public static void main(String[] args) {

    if (args.length != 3 && args.length != 0) {
      System.err.print("Please provide either 3 or 0 command line arguments");
      throw new IndexOutOfBoundsException();
    }

    if (args.length == 3) {
      String directory = args[0];
      String orderingFlag = args[1];
      String output = args[2];

      Controller studyGuideController = new StudyGuideController(directory, orderingFlag, output);
      studyGuideController.run();
    }
  }
}