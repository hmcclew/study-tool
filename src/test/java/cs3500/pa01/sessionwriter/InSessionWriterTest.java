package cs3500.pa01.sessionwriter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa01.contentcollection.QuestionCollection;
import cs3500.pa01.contentcollection.question.EasyQuestion;
import cs3500.pa01.contentcollection.question.HardQuestion;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class to test the methods for InSessionWriter
 */
class InSessionWriterTest {

  QuestionCollection qc;

  InSessionWriter isw;

  @BeforeEach
  public void setup() {
    HardQuestion hardQuestion1 = new HardQuestion("What is 2 + 2", "4");
    HardQuestion hardQuestion2 = new HardQuestion("What is 4 + 2", "6");
    EasyQuestion easyQuestion1 = new EasyQuestion("What is 0 + 0", "0");
    EasyQuestion easyQuestion2 = new EasyQuestion("What is 1 + 1", "2");
    ArrayList<HardQuestion>
        hardQuestions = new ArrayList<>(Arrays.asList(hardQuestion1, hardQuestion2));
    ArrayList<EasyQuestion> easyQuestions =
        new ArrayList<>(Arrays.asList(easyQuestion1, easyQuestion2));
    qc = new QuestionCollection(hardQuestions, easyQuestions, 4);
    isw = new InSessionWriter(qc);
  }

  @Test
  public void testWrite() {
    String mockedInput = "1\n1\n3\n2\n3";
    System.setIn(new ByteArrayInputStream(mockedInput.getBytes()));

    isw.write();

    assertEquals(3, qc.numEasyQuestions());
    assertEquals(1, qc.numHardQuestions());
  }
}



