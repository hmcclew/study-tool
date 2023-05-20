package cs3500.pa01.contentCollection;

import cs3500.pa01.contentCollection.notes.Note;
import java.util.ArrayList;

/**
 * Represents a collection of notes from a .md file
 */
public class NoteCollection implements ContentCollection {

  private ArrayList<Note> noteCollection = new ArrayList<Note>();

  /**
   * Adds a note to this instance's noteCollection
   *
   * @param n the note to be added
   */
  public void add(Note n) {
    noteCollection.add(n);
  }

  /**
   * Gets the note in this instance's noteCollection at the given index
   *
   * @param index the index of the note to be returned
   * @return the note at the given index of noteCollection
   */
  @Override
  public Note get(int index) {
    return noteCollection.get(index);
  }

  /**
   * Converts the content of this NoteCollection to a single string
   *
   * @return the new string of this NoteCollection's content
   */
  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    for (Note n : this.noteCollection) {
      if (n.equals(noteCollection.get(0))) {
        s.append(n.toFirstLine() + "\n");
      } else {
        s.append(n + "\n");
      }
    }
    return s.toString();
  }
}
