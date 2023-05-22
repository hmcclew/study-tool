package cs3500.pa01.sessionwriter;

import cs3500.pa01.contentcollection.QuestionCollection;
import cs3500.pa01.contentcollection.question.AbstractQuestion;
import cs3500.pa01.reader.InputReader;
import java.util.Scanner;

/**
 * Handles Writing to the user during a Study Session
 */
public class InSessionWriter implements Writer {
  protected QuestionCollection qc1;
  public InputReader inputReader;

  /**
   * Constructor for an InSessionWriter
   *
   * @param qc1 the question collection displayed to a user
   */
  public InSessionWriter(QuestionCollection qc1) {
    this.qc1 = qc1;
    this.inputReader  = new InputReader(qc1);
  }

  /**
   * Writes individual questions to the user and calls the input reader
   * based on each response
   */
  public void write() {
    Scanner scanner = new Scanner(System.in);

    for (AbstractQuestion question : qc1.getQuestionCollection()) {
      inputReader.setCurrentQuestion(question);
      System.out.println(question.getQuestionDifficulty() + ": " + question.getQuestion() + "\n");
      System.out.println("Please enter the corresponding number for what you'd like to do");
      System.out.println("1. Mark this question as EASY");
      System.out.println("2. Mark this question as HARD");
      System.out.println("3. View Answer");
      System.out.println("4. Quit and Discard Session");
      String userInput = scanner.nextLine();
      inputReader.read(userInput);
      System.out.println();
    }
  }
}
