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

  private String input;

  UserInput(String input) {
    this.input = input;
  }

  /**
   * Accesses user input
   *
   * @return the string of the matching input
   */
  public String getInput() {
    return input;
  }
}
