package cs3500.pa01.reader;

import static org.junit.jupiter.api.Assertions.*;

import cs3500.pa01.contentcollection.QuestionCollection;
import cs3500.pa01.contentcollection.question.EasyQuestion;
import cs3500.pa01.contentcollection.question.HardQuestion;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;

class InputReaderTest {

  InputReader ip;

  QuestionCollection qc;

  @BeforeEach
  public void setup() {
    HardQuestion hardQuestion1 = new HardQuestion("What is 2 + 2", "4");
    HardQuestion hardQuestion2 = new HardQuestion("What is 4 + 2", "6");
    EasyQuestion easyQuestion1 = new EasyQuestion("What is 0 + 0", "0");
    EasyQuestion easyQuestion2 = new EasyQuestion("What is 1 + 1", "2");
    ArrayList<HardQuestion>
        hardQuestions = new ArrayList<>(Arrays.asList(hardQuestion1, hardQuestion2));
    ArrayList<EasyQuestion> easyQuestions = new ArrayList<>(Arrays.asList(easyQuestion1, easyQuestion2));
    qc = new QuestionCollection(hardQuestions, easyQuestions, 10);
    ip = new InputReader(qc);
  }

  public void testReader() {
    assertEquals(2, qc.numEasyQuestions());
    assertEquals(2, qc.numHardQuestions());

    ip.setCurrentQuestion(qc.getQuestionCollection().get(0));
    ip.read(UserInput.ONE.getValue());

    assertEquals(3, qc.numEasyQuestions());
    assertEquals(1, qc.numHardQuestions());

    ip.setCurrentQuestion(qc.getQuestionCollection().get(3));
    ip.read(UserInput.TWO.getValue());

    assertEquals(2, qc.numEasyQuestions());
    assertEquals(2, qc.numHardQuestions());

    assertEquals(qc, ip.getQuestionCollection());
  }

}