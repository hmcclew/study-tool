package cs3500.pa01.reader;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Class to test the methods for TagType
 */
class TagTypeTest {

  /**
   * Tests the getTag method
   */
  @Test
  public void testGetTag() {
    TagType four = TagType.FOUR;
    assertEquals("####", four.getTag());

    TagType three = TagType.THREE;
    assertEquals("###", three.getTag());

    TagType two = TagType.TWO;
    assertEquals("##", two.getTag());

    TagType one = TagType.ONE;
    assertEquals("#", one.getTag());
  }
}