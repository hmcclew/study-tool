package cs3500.pa01.contentCollection.question;

public abstract class AbstractQuestion implements Question {
  public String questionText;
  public String answer;
  public QuestionDifficulty questionDifficulty;

  public AbstractQuestion(String questionText, String answer, QuestionDifficulty questionDifficulty) {
    this.questionText = questionText;
    this.answer = answer;
    this.questionDifficulty = questionDifficulty;
  }

  @Override
  public String getQuestion() {
    return this.questionText;
  }

  @Override
  public String getAnswer() {
    return this.answer;
  }

  @Override
  public QuestionDifficulty getQuestionDifficulty() {
    return this.questionDifficulty;
  }

  public String toString() {
    return "Q " + this.questionDifficulty + ": " + this.questionText +
        "\n A: " + this.answer + "\n\n";
  }
}
