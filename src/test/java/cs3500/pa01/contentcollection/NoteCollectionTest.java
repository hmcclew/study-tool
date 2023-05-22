package cs3500.pa01.contentcollection;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa01.contentcollection.note.Note;
import org.junit.jupiter.api.Test;

/**
 * Class to test methods for NoteCollection
 */
class NoteCollectionTest {

  /**
   * Checks that all Notes are properly formatted as a String
   * based on their order and tag
   */
  @Test
  public void testToString() {
    Note n1 = new Note("#", "test1");
    Note n2 = new Note("##", "test2");
    Note n3 = new Note("###", "test3");

    NoteCollection nc = new NoteCollection();
    nc.add(n1);
    nc.add(n2);
    nc.add(n3);

    assertEquals("# test1\n\n## test2\n\n### test3\n", nc.toString());
  }

}