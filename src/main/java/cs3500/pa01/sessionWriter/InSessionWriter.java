package cs3500.pa01.sessionWriter;

import cs3500.pa01.contentCollection.QuestionCollection;
import cs3500.pa01.contentCollection.question.AbstractQuestion;
import cs3500.pa01.reader.InputReader;
import java.util.Scanner;

public class InSessionWriter implements Writer {

  public QuestionCollection qc1;
  public QuestionCollection qc2;

  public InputReader inputReader;


  public InSessionWriter(QuestionCollection qc1, QuestionCollection qc2) {
    this.qc1 = qc1;
    this.qc2 = qc2;
    this.inputReader  = new InputReader(qc1);
  }

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
