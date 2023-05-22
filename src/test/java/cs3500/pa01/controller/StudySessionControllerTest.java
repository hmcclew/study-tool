package cs3500.pa01.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import cs3500.pa01.sessionwriter.InSessionWriter;
import cs3500.pa01.sessionwriter.PostSessionWriter;
import cs3500.pa01.sessionwriter.SessionSetupWriter;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

class StudySessionControllerTest {

  @Test
  public void testRun() {
    StudySessionController ssc = new StudySessionController();

    String sswInput = "TestFiles/Test3.sr\n2\n";
    System.setIn(new ByteArrayInputStream(sswInput.getBytes()));

    //ssc.run();
  }
}
