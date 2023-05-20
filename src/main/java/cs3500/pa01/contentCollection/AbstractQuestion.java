package cs3500.pa01.contentCollection;

public abstract class AbstractQuestion implements Question{

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

  @Override
  public void changeQuestionDifficulty(QuestionDifficulty updatedDifficulty) {
    if (updatedDifficulty.equals(QuestionDifficulty.EASY) && !(this instanceof EasyQuestion)) {
      EasyQuestion updatedQuestion = new EasyQuestion(this.getQuestion(), this.getAnswer());
      replaceQuestion(updatedQuestion);
    } else if (updatedDifficulty.equals(QuestionDifficulty.HARD)
        &&
        !(this instanceof HardQuestion)) {
      HardQuestion updatedQuestion = new HardQuestion(this.getQuestion(), this.getAnswer());
      replaceQuestion(updatedQuestion);
    }
  }

  public abstract void replaceQuestion(AbstractQuestion updatedQuestion);
}
