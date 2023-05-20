package cs3500.pa01.contentCollection.questions;

public interface Question {
   String getQuestion();
   String getAnswer();
   void changeQuestionDifficulty(QuestionDifficulty updatedDifficulty);
   QuestionDifficulty getQuestionDifficulty();
   void replaceQuestion(AbstractQuestion question);
   String toString();
}
