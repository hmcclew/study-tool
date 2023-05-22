package cs3500.pa01.contentcollection.question;

/**
 * Abstract class to house methods used by EasyQuestion and
 * HardQuestion
 */
public abstract class AbstractQuestion implements Question {
  public String questionText;
  public String answer;
  public QuestionDifficulty questionDifficulty;

  /**
   * Constructor for an AbstractQuestion
   *
   * @param questionText the question content
   * @param answer the answer to the question
   * @param questionDifficulty the difficulty of the question
   */
  public AbstractQuestion(String questionText, String answer,
                          QuestionDifficulty questionDifficulty) {
    this.questionText = questionText;
    this.answer = answer;
    this.questionDifficulty = questionDifficulty;
  }

  /**
   * Getter for the question text
   *
   * @return the question text
   */
  @Override
  public String getQuestion() {
    return this.questionText;
  }

  /**
   * Getter for the question answer
   *
   * @return the answer
   */
  @Override
  public String getAnswer() {
    return this.answer;
  }

  /**
   * Getter for the question difficulty
   *
   * @return the question difficulty
   */
  @Override
  public QuestionDifficulty getQuestionDifficulty() {
    return this.questionDifficulty;
  }

  /**
   * Formats the question as a string based on it's fields
   *
   * @return the formatted string for this question
   */
  public String toString() {
    return "Q " + this.questionDifficulty + ": " + this.questionText
        +
        "\n A: " + this.answer + "\n\n";
  }
}
