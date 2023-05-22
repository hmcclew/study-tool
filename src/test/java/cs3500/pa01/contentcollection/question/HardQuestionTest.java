package cs3500.pa01.contentcollection.question;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class HardQuestionTest {

  @Test
  public void testHardQuestion() {
    HardQuestion hq = new HardQuestion("Where am I from?", "Memphis");

    assertEquals("Where am I from?", hq.getQuestion());
    assertEquals("Memphis", hq.getAnswer());
    assertEquals(QuestionDifficulty.HARD, hq.getQuestionDifficulty());
  }

}