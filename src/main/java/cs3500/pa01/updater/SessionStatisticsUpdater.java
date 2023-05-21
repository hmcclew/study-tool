package cs3500.pa01.updater;

import cs3500.pa01.contentCollection.QuestionCollection;
import cs3500.pa01.contentCollection.question.Question;

/**
 * Class that keeps track of all statistics
 * displayed to a user at the end of each study session
 */
public class SessionStatisticsUpdater {
  private int hardToEasy;
  private int easyToHard;
  private int numAnswered;
  private int numHard;
  private int numEasy;
  private QuestionCollection qc;

  public SessionStatisticsUpdater(QuestionCollection qc) {
    this.qc = qc;
    this.hardToEasy = 0;
    this.easyToHard = 0;
    this.numAnswered = 0;
    this.numEasy = qc.numEasyQuestions();
    this.numHard = qc.numHardQuestions();
  }
  public void incrementHardToEasy() {
    hardToEasy++;
  }

  public void incrementEasyToHard() {
    easyToHard++;
  }

  public void incrementNumAnswered() {
    numAnswered++;
  }

  public void increaseNumHard() {
    numHard++;
  }

  public void decreaseNumHard() {
    numHard--;
  }

  public void increaseNumEasy() {
    numEasy++;
  }

  public void decreaseNumEasy() {
    numEasy--;
  }

}
