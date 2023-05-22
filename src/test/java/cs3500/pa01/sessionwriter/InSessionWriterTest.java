package cs3500.pa01.sessionwriter;

import static org.junit.jupiter.api.Assertions.*;

import cs3500.pa01.contentcollection.QuestionCollection;
import cs3500.pa01.contentcollection.question.EasyQuestion;
import cs3500.pa01.contentcollection.question.HardQuestion;
import cs3500.pa01.updater.SessionStatisticsUpdater;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    ArrayList<EasyQuestion> easyQuestions = new ArrayList<>(Arrays.asList(easyQuestion1, easyQuestion2));
    qc = new QuestionCollection(hardQuestions, easyQuestions, 4);
    isw = new InSessionWriter(qc);
  }
  @Test
  public void testWrite() {
    isw.write();
  }
}



