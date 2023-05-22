package cs3500.pa01.contentcollection.question;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AbstractQuestionTest {

  @Test
  public void testToString() {
    AbstractQuestion question = new EasyQuestion("What is the color of the sky?",
        "Blue");

    String expectedString = "Q EASY: What is the color of the sky?\n A: Blue\n\n";
    assertEquals(expectedString, question.toString());
  }

  @Test
  public void testGetterMethods() {
    AbstractQuestion question = new HardQuestion("What is the capital of TN",
        "Nashville");

    assertEquals(question.getQuestion(), "What is the capital of TN");
    assertEquals(question.getAnswer(), "Nashville");
    assertEquals(question.getQuestionDifficulty(), QuestionDifficulty.HARD);
  }
}