package cs3500.pa01.contentcollection.question;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Class to test the methods for QuestionDifficulty
 */
class QuestionDifficultyTest {

  @Test
  public void testEasyDifficulty() {
    QuestionDifficulty difficulty = QuestionDifficulty.EASY;

    assertEquals("EASY", difficulty.name());
    assertEquals(0, difficulty.ordinal());
    assertEquals("EASY", difficulty.toString());
  }

  @Test
  public void testHardDifficulty() {
    QuestionDifficulty difficulty = QuestionDifficulty.HARD;

    assertEquals("HARD", difficulty.name());
    assertEquals(1, difficulty.ordinal());
    assertEquals("HARD", difficulty.toString());
  }
}




