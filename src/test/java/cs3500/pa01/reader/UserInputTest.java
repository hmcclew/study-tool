package cs3500.pa01.reader;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Test the methods for user input enumerations
 */
class UserInputTest {

  /**
   * Tests the getValue method
   */
  @Test
  public void testGetValue() {
    UserInput one = UserInput.ONE;
    assertEquals("1", one.getValue());

    UserInput two = UserInput.TWO;
    assertEquals("2", two.getValue());

    UserInput three = UserInput.THREE;
    assertEquals("3", three.getValue());

    UserInput four = UserInput.FOUR;
    assertEquals("4", four.getValue());
  }
}