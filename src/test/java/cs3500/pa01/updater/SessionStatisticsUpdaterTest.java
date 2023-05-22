package cs3500.pa01.updater;

import static org.junit.jupiter.api.Assertions.*;

import cs3500.pa01.contentcollection.QuestionCollection;
import cs3500.pa01.contentcollection.question.EasyQuestion;
import cs3500.pa01.contentcollection.question.HardQuestion;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SessionStatisticsUpdaterTest {

  SessionStatisticsUpdater sst;

  QuestionCollection qc;

  @BeforeEach
  public void setup() {
    HardQuestion hardQuestion1 = new HardQuestion("What is 2 + 2", "4");
    HardQuestion hardQuestion2 = new HardQuestion("What is 4 + 2", "6");
    EasyQuestion easyQuestion1 = new EasyQuestion("What is 0 + 0", "0");
    EasyQuestion easyQuestion2 = new EasyQuestion("What is 1 + 1", "2");
    ArrayList<HardQuestion> hardQuestions = new ArrayList<>(Arrays.asList(hardQuestion1, hardQuestion2));
    ArrayList<EasyQuestion> easyQuestions = new ArrayList<>(Arrays.asList(easyQuestion1, easyQuestion2));
    qc = new QuestionCollection(hardQuestions, easyQuestions, 4);
    sst = new SessionStatisticsUpdater(qc);
  }
  @Test
  public void testTrackStatistics() {
    sst.incrementEasyToHard();
    sst.incrementHardToEasy();
    sst.increaseNumEasy();
    sst.increaseNumEasy();
    sst.increaseNumHard();
    sst.incrementNumAnswered();

    assertEquals(2, qc.numHardQuestions());
    assertEquals(2, qc.numEasyQuestions());

    String statistics = sst.printStatistics();

    assertTrue(statistics.contains("You answered 1 questions."));
    assertTrue(statistics.contains("1 questions went from easy to hard."));
    assertTrue(statistics.contains("1 questions went from hard to easy."));
  }


}