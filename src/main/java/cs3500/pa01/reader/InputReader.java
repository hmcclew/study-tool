package cs3500.pa01.reader;

import cs3500.pa01.contentcollection.QuestionCollection;
import cs3500.pa01.contentcollection.question.AbstractQuestion;
import cs3500.pa01.contentcollection.question.QuestionDifficulty;
import cs3500.pa01.updater.SessionStatisticsUpdater;
import java.util.Objects;
import java.util.Scanner;

public class InputReader implements Reader {
  private AbstractQuestion currentQuestion;
  private QuestionCollection questionCollection;

  private SessionStatisticsUpdater statisticsUpdater;

  public InputReader(QuestionCollection qc) {
    this.questionCollection = Objects.requireNonNull(qc);
    this.statisticsUpdater = new SessionStatisticsUpdater(questionCollection);
  }

  public QuestionCollection getQuestionCollection() {
    return questionCollection;
  }

  public void setCurrentQuestion(AbstractQuestion q) {
    this.currentQuestion = q;
  }

  public String printStatistics() {
    return statisticsUpdater.printStatistics();
  }

  @Override
  public void read(String userInput) {
    Scanner scanner = new Scanner(System.in);

    if (userInput.trim().equals(UserInput.ONE.getValue())
        &&
        currentQuestion.getQuestionDifficulty().equals(QuestionDifficulty.HARD)) {
      questionCollection.changeQuestionDifficulty(currentQuestion);
      System.out.println("\nQuestion now marked as easy");
      statisticsUpdater.incrementNumAnswered();
      statisticsUpdater.incrementHardToEasy();
      statisticsUpdater.increaseNumEasy();
    } else if (userInput.trim().equals(UserInput.TWO.getValue())
        &&
        currentQuestion.getQuestionDifficulty().equals(QuestionDifficulty.EASY)) {
      questionCollection.changeQuestionDifficulty(currentQuestion);
      System.out.println("\nQuestion now marked as hard");
      statisticsUpdater.incrementNumAnswered();
      statisticsUpdater.incrementEasyToHard();
      statisticsUpdater.increaseNumHard();
    } else if (userInput.trim().equals(UserInput.THREE.getValue())) {
      System.out.println("Answer: " + currentQuestion.getAnswer());
    } else if (userInput.trim().equals(UserInput.FOUR.getValue())) {
      System.exit(0);
      statisticsUpdater.printStatistics();
    } else {
      String nextLine = scanner.nextLine();
      read(nextLine);
    }
  }
}
