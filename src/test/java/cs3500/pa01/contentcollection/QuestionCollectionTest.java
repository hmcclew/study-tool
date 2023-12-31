package cs3500.pa01.contentcollection;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa01.contentcollection.question.EasyQuestion;
import cs3500.pa01.contentcollection.question.HardQuestion;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class to test the methods for QuestionCollection
 */
class QuestionCollectionTest {

  private ArrayList<HardQuestion> hardQuestions;
  private ArrayList<EasyQuestion> easyQuestions;

  private HardQuestion hardQuestion1;
  private HardQuestion hardQuestion2;

  private EasyQuestion easyQuestion1;
  private EasyQuestion easyQuestion2;

  QuestionCollection questionCollectionC;

  @BeforeEach
  void setUp() {
    hardQuestion1 = new HardQuestion("What is 2 + 2", "4");
    hardQuestion2 = new HardQuestion("What is 4 + 2", "6");
    easyQuestion1 = new EasyQuestion("What is 0 + 0", "0");
    easyQuestion2 = new EasyQuestion("What is 1 + 1", "2");
    hardQuestions = new ArrayList<>(Arrays.asList(hardQuestion1, hardQuestion2));
    easyQuestions = new ArrayList<>(Arrays.asList(easyQuestion1, easyQuestion2));
    questionCollectionC = new QuestionCollection(hardQuestions, easyQuestions, 4);
  }

  @Test
  void testToString() {
    String qcToString = questionCollectionC.toString();

    System.out.print(qcToString);
  }

  @Test
  public void testChangeDifficulty() {
    questionCollectionC.changeQuestionDifficulty(hardQuestion1);

    assertEquals(3, questionCollectionC.easyQuestions.size());
    assertEquals(1, questionCollectionC.hardQuestions.size());

    questionCollectionC.changeQuestionDifficulty(easyQuestion1);

    assertEquals(2, questionCollectionC.easyQuestions.size());
    assertEquals(2, questionCollectionC.hardQuestions.size());
  }

}