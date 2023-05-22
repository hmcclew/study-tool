package cs3500.pa01.contentcollection.note;

/**
 * Represents a single line of formatted Markdown text, including the content,
 * and it's associated tag
 */
public class Note {
  private String tag;
  private String content;

  public Note(String tag, String content) {
    this.tag = tag;
    this.content = content;
  }

  /**
   * Gets the tag of this note
   *
   * @return the tag of this note
   */
  public String getTag() {
    return this.tag;
  }

  /**
   * Gets the content of this note
   *
   * @return the content of this note
   */
  public String getContent() {
    return this.content;
  }

  /**
   * Formats the content of this Note based on the tag
   *
   * @return the new string of this Note's content based on the tag
   */
  public String toString() {
    if (tag.equals("[[]]")) {
      return "- " + content;
    } else {
      return "\n" + tag + " " + content;
    }
  }

  /**
   * Formats the content of this Note based on the tag and as a first line
   * to not have a space above it
   *
   * @return the new string of this Note's content based on the tag
   */
  public String toFirstLine() {
    if (tag.equals("[[]]")) {
      return "- " + content;
    } else {
      return tag + " " + content;
    }
  }
}

