package cs3500.pa01.contentcollection.question;

/**
 * Represents an Easy Question
 */
public class EasyQuestion extends AbstractQuestion {

  /**
   * Constructor for an easy question
   *
   * @param questionText the question text
   * @param answer the question answer
   */
  public EasyQuestion(String questionText, String answer) {
    super(questionText, answer, QuestionDifficulty.EASY);
  }
}