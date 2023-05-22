package cs3500.pa01.contentcollection.note;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Class to test methods for Note
 */
class NoteTest {

  /**
   * Checks that content is properly formatted as a String
   * based on it's tag
   */
  @Test
  public void checkToString() {
    Note n1 = new Note("#", "This is a test");
    assertEquals("\n" + "# This is a test", n1.toString());

    Note n2 = new Note("##", "test2");
    assertEquals("\n" + "## test2", n2.toString());

    Note n3 = new Note("###", "test3");
    assertEquals("\n" + "### test3", n3.toString());

    Note n4 = new Note("####", "test4");
    assertEquals("\n" + "#### test4", n4.toString());

    Note n5 = new Note("[[]]", "test5");
    assertEquals("- test5", n5.toString());

    Note n6 = new Note("-", "test6");
    assertEquals("\n" + "- test6", n6.toString());

    Note n7 = new Note("", "test7");
    assertEquals("\n " + "test7", n7.toString());
  }

  /**
   * Checks that content is properly formatted as a String
   * based on its tag and that it's the first line
   */
  @Test
  public void checkToFirstLine() {
    Note n1 = new Note("#", "First Line");
    assertEquals("# First Line", n1.toFirstLine());

    Note n2 = new Note("[[]]", "First Line 2");
    assertEquals("- First Line 2", n2.toFirstLine());
  }

}