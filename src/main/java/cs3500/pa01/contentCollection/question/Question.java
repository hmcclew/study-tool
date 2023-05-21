package cs3500.pa01.contentCollection.question;

public interface Question {
   String getQuestion();
   String getAnswer();
   QuestionDifficulty getQuestionDifficulty();
   String toString();
}
