package cs3500.pa01.controller;

import cs3500.pa01.contentCollection.QuestionCollection;
import cs3500.pa01.contentCollection.question.AbstractQuestion;
import cs3500.pa01.fileWriter.FileWriter;
import cs3500.pa01.fileWriter.SRWriter;
import cs3500.pa01.reader.FileReader;
import cs3500.pa01.reader.InputReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class StudySessionController implements Controller {

  public void run() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Welcome to Spaced Repetition!");
    System.out.println("Please provide a path to an .sr file"
        + " with questions you would like to study");
    String filePath = scanner.nextLine();

    QuestionCollection qc1 = new QuestionCollection();
    QuestionCollection qc2 = new QuestionCollection();
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

    InputReader inputReader = new InputReader(qc1);

    for (AbstractQuestion question : qc1.getQuestionCollection()) {
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

    fr.createQuestionCollectionFromSr(qc2);
    QuestionCollection updatedQuestions = inputReader.getQuestionCollection();
    QuestionCollection updatedQuestionCollection =
        new QuestionCollection(updatedQuestions.getHardQuestions(),
        updatedQuestions.getEasyQuestions());
    updatedQuestionCollection.updateCollection(qc2.getQuestionCollection());
    FileWriter fileWriter = new SRWriter();
    filePath = filePath.substring(0, filePath.indexOf(".sr"));
    fileWriter.writeToFile(Path.of(filePath), updatedQuestionCollection.toString());
  }

}
