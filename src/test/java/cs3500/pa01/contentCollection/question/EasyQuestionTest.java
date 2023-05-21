package cs3500.pa01.contentCollection.question;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class EasyQuestionTest {

  @Test
  public void testEasyQuestion() {
    EasyQuestion eq = new EasyQuestion("Where am I from?", "Memphis");

    assertEquals("Where am I from?", eq.getQuestion());
    assertEquals("Memphis", eq.getAnswer());
    assertEquals(QuestionDifficulty.EASY, eq.getQuestionDifficulty());
  }
}