package cs3500.pa01.controller;

import cs3500.pa01.contentCollection.QuestionCollection;
import cs3500.pa01.reader.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class StudySessionController implements Controller {

  public void run() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Welcome to Spaced Repetition!");
    System.out.println("Please provide a path to an .sr file" +
        " with questions you would like to study");
    String filePath = scanner.nextLine();

    QuestionCollection qc = new QuestionCollection();

    if (filePath.endsWith(".sr")) {
      FileReader fr = new FileReader(filePath);
      fr.createQuestionCollectionFromSR(qc);
    } else {
      System.out.println("Please provide a path to an SR file");
      scanner.nextLine();
    }

    System.out.println("Great! How many questions would you like to study?");
    int numQuestionsToStudy = scanner.nextInt();
    scanner.nextLine();
    qc.makeQuestionCollection(numQuestionsToStudy);
    System.out.println("Great! Let's begin");
  }
}
