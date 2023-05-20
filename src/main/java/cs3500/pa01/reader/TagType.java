package cs3500.pa01.reader;

/**
 * Enumerations to represent four different levels of # type
 */
public enum TagType {
  FOUR("####"),
  THREE("###"),
  TWO("##"),
  ONE("#");

  private String tag;

  TagType(String tag) {
    this.tag = tag;
  }

  /**
   * Accesses a tag
   *
   * @return the string of the matching tag
   */
  public String getTag() {
    return tag;
  }
}

