package cs3500.pa01.controller;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

/**
 * Class to test the methods for StudySessionController
 */
class StudySessionControllerTest {

  @Test
  public void testRun() {
    StudySessionController ssc = new StudySessionController();

    String sswInput = "TestFiles/Test3.sr\n2\n";
    System.setIn(new ByteArrayInputStream(sswInput.getBytes()));

    //ssc.run();
  }
}
