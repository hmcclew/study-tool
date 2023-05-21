package cs3500.pa01.controller;

import cs3500.pa01.contentCollection.NoteCollection;
import cs3500.pa01.contentCollection.QuestionCollection;
import cs3500.pa01.fileWriter.FileWriter;
import cs3500.pa01.fileWriter.MarkDownWriter;
import cs3500.pa01.fileWriter.SRWriter;
import cs3500.pa01.reader.FileReader;
import cs3500.pa01.sorter.FileSorter;
import cs3500.pa01.sorter.Sorter;
import cs3500.pa01.visitor.FileVisitor;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;

public class StudyGuideController implements Controller {
  private final String inputPath;
  private final String orderingFlag;
  private final String outputPath;

  /**
   * Constructor for StudyGuideController
   *
   * @param inputPath the path to input files to be walked
   * @param orderingFlag the ordering of files to take place
   * @param outputPath the place to output the final study guide
   */
  public StudyGuideController(String inputPath, String orderingFlag, String outputPath) {
    this.inputPath = Objects.requireNonNull(inputPath);
    this.orderingFlag = Objects.requireNonNull(orderingFlag);
    this.outputPath = Objects.requireNonNull(outputPath);
  }

  public void run() {
    Path directoryPath = Paths.get(inputPath);
    FileVisitor fileVisitor = new FileVisitor();

    try {
      Files.walkFileTree(directoryPath, fileVisitor);
    } catch (IOException e) {
      e.printStackTrace();
    }

    ArrayList<Path> files = fileVisitor.getFiles();
    Sorter fileSorter = new FileSorter(files);
    fileSorter.sort(orderingFlag);
    NoteCollection noteCollection = new NoteCollection();
    QuestionCollection questionCollection = new QuestionCollection();

    for (Path file : fileSorter.getFiles()) {
      FileReader fileReader = new FileReader(file.toString());
      fileReader.setPath(file);
      fileReader.createContentCollections(noteCollection, questionCollection);
    }

    FileWriter markDownWriter = new MarkDownWriter();
    FileWriter srWriter = new SRWriter();
    Path output = Paths.get(outputPath);
    markDownWriter.writeToFile(output, noteCollection.toString());
    srWriter.writeToFile(output, questionCollection.toString());
  }
}
