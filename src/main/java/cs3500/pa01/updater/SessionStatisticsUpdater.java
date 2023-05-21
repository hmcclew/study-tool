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

  public String printStatistics() {
    return "You answered " + numAnswered + " questions. \n"
        + easyToHard + " questions went from easy to hard. \n"
        + hardToEasy + " questions went from hard to easy. \n"
        + "There are now " + numEasy + " easy questions. \n"
        + "There are now " + numHard + " hard questions. \n";
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
    numEasy--;
  }

  public void increaseNumEasy() {
    numEasy++;
    numHard--;
  }


}
