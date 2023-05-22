package cs3500.pa01.contentcollection.question;

/**
 * Represents a question and it's properties
 */
public interface Question {
  /**
   * getter method for the question text
   *
   * @return the question text
   */
  String getQuestion();
  /**
   * getter method for the answer
   *
   * @return the answer
   */
  String getAnswer();
  /**
   * getter method for the question difficulty
   *
   * @return the question difficulty
   */
  QuestionDifficulty getQuestionDifficulty();
  /**
   * returns the formatted string of a question based on it's fields
   *
   * @return the formatted string for a question
   */
  String toString();
}
