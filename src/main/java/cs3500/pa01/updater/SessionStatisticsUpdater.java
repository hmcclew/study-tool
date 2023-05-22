package cs3500.pa01.updater;

import cs3500.pa01.contentcollection.QuestionCollection;

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

  /**
   * Constructor for a session statistics updater
   *
   * @param qc the question collection being used during a session
   */
  public SessionStatisticsUpdater(QuestionCollection qc) {
    this.qc = qc;
    this.hardToEasy = 0;
    this.easyToHard = 0;
    this.numAnswered = 0;
    this.numEasy = qc.numEasyQuestions();
    this.numHard = qc.numHardQuestions();
  }

  /**
   * Formats the session statistics to be displayed to a user
   *
   * @return the string of session statistics to be displayed to the user at the end of a session
   */
  public String printStatistics() {
    return "You answered " + numAnswered + " questions. \n"
        + easyToHard + " questions went from easy to hard. \n"
        + hardToEasy + " questions went from hard to easy. \n"
        + "There are now " + numEasy + " easy questions. \n"
        + "There are now " + numHard + " hard questions. \n";
  }

  /**
   * increments the number of questions that change from hard to easy
   */
  public void incrementHardToEasy() {
    hardToEasy++;
  }

  /**
   * increments the number of questions that change from easy to hard
   */
  public void incrementEasyToHard() {
    easyToHard++;
  }

  /**
   * increments the number of questions that the user answers
   */
  public void incrementNumAnswered() {
    numAnswered++;
  }

  /**
   * updates question counts when a question is marked as hard
   */
  public void increaseNumHard() {
    numHard++;
    numEasy--;
  }

  /**
   * updates question counts when a question is marked as easy
   */
  public void increaseNumEasy() {
    numEasy++;
    numHard--;
  }


}
