package cs3500.pa01.contentcollection.question;

public interface Question {
  String getQuestion();

  String getAnswer();

  QuestionDifficulty getQuestionDifficulty();

  String toString();
}
