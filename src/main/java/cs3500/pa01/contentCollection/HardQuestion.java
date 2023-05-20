package cs3500.pa01.contentCollection;

public class HardQuestion extends AbstractQuestion {
  public HardQuestion(String questionText, String answer) {
    super(questionText, answer, QuestionDifficulty.HARD);
  }

  @Override
  public void replaceQuestion(AbstractQuestion newQuestion) {
    if (newQuestion instanceof HardQuestion) {
      this.questionText = newQuestion.getQuestion();
      this.answer = newQuestion.getAnswer();
      this.questionDifficulty = newQuestion.getQuestionDifficulty();
    } else {
      throw new IllegalArgumentException("Invalid question type provided.");
    }
  }
}
