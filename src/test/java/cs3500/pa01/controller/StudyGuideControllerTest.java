package cs3500.pa01.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;

/**
 * Class to test the methods for StudyGuideController
 */
class StudyGuideControllerTest {

  @Test
  public void testRun() throws IOException {

    Path testDirectory = Files.createTempDirectory("RunTest");

    Path p1 = Files.createTempFile(testDirectory, "test1", ".txt");
    Path p2 = Files.createTempFile(testDirectory, "test2", ".txt");
    Path p3 = Files.createTempFile(testDirectory, "test3", ".txt");

    StudyGuideController controller = new StudyGuideController(testDirectory.toString(),
        "filename",
        testDirectory.resolve("output.txt").toString());

    controller.run();
  }

}