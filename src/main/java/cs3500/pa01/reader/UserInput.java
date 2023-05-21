package cs3500.pa01.reader;

/**
 * enumerations to represent all four types
 * of user input during a study session
 */
public enum UserInput {
  ONE("1"),
  TWO("2"),
  THREE("3"),
  FOUR("4");

  private String value;

  UserInput(String value) {
    this.value = value;
  }

  /**
   * Accesses user input
   *
   * @return the string of the matching input
   */
  public String getValue() {
    return value;
  }
}
