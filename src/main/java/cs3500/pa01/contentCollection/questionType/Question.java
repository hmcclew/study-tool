package cs3500.pa01.contentCollection.questionType;

public class Question {

  boolean isHard;

  private String question;

  private String answer;

  public Question(boolean isHard, String question, String answer) {
    this.isHard = isHard;
    this.question = question;
    this.answer = answer;
  }

  /**
   * Gets the question of this question
   *
   * @return the question of this question
   */
  public String getQuestion() {
    return this.question;
  }

  /**
   * Gets the answer of this question
   *
   * @return the answer of this question
   */
  public String getAnswer() {
    return this.answer;
  }

  /**
   * Formats the content of this question based on the difficulty
   *
   * @return the new string of this question's content based on if it's labeled hard or not
   */
  public String toString() {
    if (isHard) {
      return "Q HARD: " + question + "\nA: " + answer + "\n\n";
    } else {
      return "Q EASY: " + question + "\nA: " + answer + "\n\n";
    }
  }
}
