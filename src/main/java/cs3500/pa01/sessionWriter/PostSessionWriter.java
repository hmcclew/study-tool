package cs3500.pa01.sessionWriter;

import cs3500.pa01.contentCollection.QuestionCollection;
import cs3500.pa01.fileWriter.FileWriter;
import cs3500.pa01.fileWriter.SRWriter;
import cs3500.pa01.reader.FileReader;
import cs3500.pa01.reader.InputReader;
import java.nio.file.Path;

public class PostSessionWriter implements Writer{

  public QuestionCollection qc1;
  public QuestionCollection qc2;

  public String filePath;

  public InputReader inputReader;

  public PostSessionWriter(QuestionCollection qc1, QuestionCollection qc2, String filePath,
                           InputReader inputReader) {
    this.qc1 = qc1;
    this.qc2 = qc2;
    this.filePath = filePath;
    this.inputReader = inputReader;
  }

  public void write() {
    System.out.println(inputReader.printStatistics());
    FileReader fr = new FileReader();
    fr.read(filePath);
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
