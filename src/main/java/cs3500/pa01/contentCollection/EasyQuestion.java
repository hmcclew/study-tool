package cs3500.pa01.contentCollection;


public class EasyQuestion extends AbstractQuestion {
  public EasyQuestion(String questionText, String answer) {
    super(questionText, answer, QuestionDifficulty.EASY);
  }

  @Override
  public void replaceQuestion(AbstractQuestion newQuestion) {
    if (newQuestion instanceof EasyQuestion) {
      this.questionText = newQuestion.getQuestion();
      this.answer = newQuestion.getAnswer();
      this.questionDifficulty = newQuestion.getQuestionDifficulty();
    } else {
      throw new IllegalArgumentException("Invalid question type provided.");
    }
  }
}