package cs3500.pa01.sessionwriter;

import cs3500.pa01.contentcollection.QuestionCollection;
import cs3500.pa01.reader.FileReader;
import java.util.Scanner;

public class SessionSetupWriter implements Writer {

  public QuestionCollection qc1 = new QuestionCollection();
  public QuestionCollection qc2 = new QuestionCollection();
  public String filePath;

  public void write() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Welcome to Spaced Repetition!");
    System.out.println("Please provide a path to an .sr file"
        + " with questions you would like to study");
    filePath = scanner.nextLine();

    FileReader fr = new FileReader();
    fr.read(filePath);

    if (filePath.endsWith(".sr")) {
      fr.createQuestionCollectionFromSr(qc1);
    } else {
      System.out.println("Please ensure the path leads to an .sr file");
      scanner.nextLine();
    }

    System.out.println("Great! How many questions would you like to study?");
    int numQuestionsToStudy = scanner.nextInt();
    scanner.nextLine();
    qc1.makeQuestionCollection(numQuestionsToStudy);
    System.out.println("Great! Let's begin" + "\n");
  }
}
