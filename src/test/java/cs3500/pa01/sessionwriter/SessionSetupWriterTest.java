package cs3500.pa01.sessionwriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

/**
 * Class to test the methods for SessionSetupWriter
 */
public class SessionSetupWriterTest {

  @Test
  public void testWrite() {
    String mockedInput = "TestFiles/Test3.sr\n2\n";
    System.setIn(new ByteArrayInputStream(mockedInput.getBytes()));
    SessionSetupWriter writer = new SessionSetupWriter();

    writer.write();

    assertEquals(2, writer.qc1.getQuestionCollection().size());
  }

  @Test
  public void testPathException() {
    String mockedInput = "TestFiles/Test.md";
    System.setIn(new ByteArrayInputStream(mockedInput.getBytes()));
    SessionSetupWriter writer = new SessionSetupWriter();

    assertThrows(NoSuchElementException.class, () -> {
      writer.write();
    });
  }
}
