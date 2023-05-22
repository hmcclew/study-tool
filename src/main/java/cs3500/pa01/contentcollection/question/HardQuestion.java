package cs3500.pa01.contentcollection.question;

/**
 * Represents a Hard Question
 */
public class HardQuestion extends AbstractQuestion {

  /**
   * Constructor for a hard question
   *
   * @param questionText the question text
   * @param answer the question answer
   */
  public HardQuestion(String questionText, String answer) {
    super(questionText, answer, QuestionDifficulty.HARD);
  }
}
