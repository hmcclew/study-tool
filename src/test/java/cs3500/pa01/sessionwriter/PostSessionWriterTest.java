package cs3500.pa01.sessionwriter;

import cs3500.pa01.contentcollection.QuestionCollection;
import cs3500.pa01.contentcollection.question.EasyQuestion;
import cs3500.pa01.contentcollection.question.HardQuestion;
import cs3500.pa01.reader.InputReader;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class to test the methods for PostSessionWriter
 */
class PostSessionWriterTest {

  InputReader ip;

  QuestionCollection qc1;

  QuestionCollection qc2;

  String filePath;

  PostSessionWriter psw;

  InSessionWriter isw;

  @BeforeEach
  public void setup() {
    HardQuestion hardQuestion1 = new HardQuestion("What is 2 + 2", "4");
    HardQuestion hardQuestion2 = new HardQuestion("What is 4 + 2", "6");
    EasyQuestion easyQuestion1 = new EasyQuestion("What is 0 + 0", "0");
    EasyQuestion easyQuestion2 = new EasyQuestion("What is 1 + 1", "2");
    ArrayList<HardQuestion>
        hardQuestions = new ArrayList<>(Arrays.asList(hardQuestion1, hardQuestion2));
    ArrayList<EasyQuestion> easyQuestions = new ArrayList<>(Arrays.asList(easyQuestion1,
        easyQuestion2));
    qc1 = new QuestionCollection(hardQuestions, easyQuestions, 10);
    qc2 = new QuestionCollection(hardQuestions, easyQuestions, 10);
    ip = new InputReader(qc1);
    isw = new InSessionWriter(qc1);
    filePath = "TestFiles/Test4.sr";

    String mockedInput = "1\n1\n3\n2\n3";
    System.setIn(new ByteArrayInputStream(mockedInput.getBytes()));

    isw.write();

    psw = new PostSessionWriter(qc1, qc2, filePath, ip);
  }

  @Test
  public void testWrite() {
    psw.write();
  }

}