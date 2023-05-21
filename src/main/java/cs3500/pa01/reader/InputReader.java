package cs3500.pa01.reader;

import cs3500.pa01.contentCollection.QuestionCollection;
import cs3500.pa01.contentCollection.question.AbstractQuestion;
import cs3500.pa01.contentCollection.question.QuestionDifficulty;
import cs3500.pa01.updater.SessionStatisticsUpdater;
import java.util.Objects;
import java.util.Scanner;

public class InputReader {
  private AbstractQuestion currentQuestion;
  private QuestionCollection questionCollection;

  private SessionStatisticsUpdater statisticsUpdater;

  public InputReader(QuestionCollection qc) {
    this.questionCollection = Objects.requireNonNull(qc);
    this.statisticsUpdater = new SessionStatisticsUpdater(questionCollection);
  }

  public void setCurrentQuestion(AbstractQuestion q) {
    this.currentQuestion = q;
  }

  public void read(String userInput) {

    if (userInput.equals(UserInput.ONE.getValue())
        &&
        currentQuestion.getQuestionDifficulty().equals(QuestionDifficulty.HARD)) {
      questionCollection.changeQuestionDifficulty(currentQuestion);
      System.out.println("Question now marked as easy");
      statisticsUpdater.incrementNumAnswered();
      statisticsUpdater.incrementHardToEasy();
      statisticsUpdater.decreaseNumHard();
      statisticsUpdater.increaseNumEasy();
    }
    else if (userInput.equals(UserInput.TWO.getValue())
        &&
        currentQuestion.getQuestionDifficulty().equals(QuestionDifficulty.EASY)) {
      questionCollection.changeQuestionDifficulty(currentQuestion);
      System.out.println("Question now marked as hard");
      statisticsUpdater.incrementNumAnswered();
      statisticsUpdater.incrementEasyToHard();
      statisticsUpdater.increaseNumHard();
      statisticsUpdater.decreaseNumEasy();
    }
    else if (userInput.trim().equals(UserInput.THREE.getValue())) {
      System.out.println("Answer: " + currentQuestion.getAnswer());
    }
    else if (userInput.equals(UserInput.FOUR.getValue())) {
      System.exit(0);
    }
  }
}
