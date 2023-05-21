package cs3500.pa01.controller;

import cs3500.pa01.contentCollection.QuestionCollection;
import cs3500.pa01.contentCollection.question.AbstractQuestion;
import cs3500.pa01.reader.FileReader;
import cs3500.pa01.reader.InputReader;
import java.io.IOException;
import java.util.Scanner;

public class StudySessionController implements Controller {

  public void run() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Welcome to Spaced Repetition!");
    System.out.println("Please provide a path to an .sr file"
        + " with questions you would like to study");
    String filePath = scanner.nextLine();

    QuestionCollection qc = new QuestionCollection();

    if (filePath.endsWith(".sr")) {
      FileReader fr = new FileReader(filePath);
      fr.createQuestionCollectionFromSr(qc);
    } else {
      System.out.println("Please ensure the path leads to an .sr file");
      scanner.nextLine();
    }

    System.out.println("Great! How many questions would you like to study?");
    int numQuestionsToStudy = scanner.nextInt();
    scanner.nextLine();
    qc.makeQuestionCollection(numQuestionsToStudy);
    System.out.println("Great! Let's begin" + "\n");

    InputReader inputReader = new InputReader(qc);

    for (AbstractQuestion question : qc.getQuestionCollection()) {
      inputReader.setCurrentQuestion(question);
      System.out.println(question.getQuestionDifficulty() + ": " + question.getQuestion() + "\n");
      System.out.println("Please enter the corresponding number for what you'd like to do");
      System.out.println("1. Mark this question as EASY");
      System.out.println("2. Mark this question as HARD");
      System.out.println("3. View Answer");
      System.out.println("4. Exit Application");

      String userInput = scanner.nextLine();
      inputReader.read(userInput);
      System.out.println();
    }

    System.out.println(inputReader.printStatistics());

  }

}
