package cs3500.pa01.reader;

import cs3500.pa01.contentcollection.NoteCollection;
import cs3500.pa01.contentcollection.QuestionCollection;
import cs3500.pa01.contentcollection.note.Note;
import cs3500.pa01.contentcollection.question.EasyQuestion;
import cs3500.pa01.contentcollection.question.HardQuestion;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * A file reader that reads through a file and extracts relevant text
 */
public class FileReader implements Reader {
  Path path;
  Scanner scanner = null;
  String fileContent = "";

  /**
   * reads the content of a file and converts it to a string
   *
   * @param p1 the string version of the path to be read
   */
  public void read(String p1) {
    path = Path.of(p1);
    try {
      fileContent = Files.readString(path);
      scanner = new Scanner(fileContent);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Sets the given path as this instance's p field
   *
   * @param path the path set to this instance's p field
   */
  public void setPath(Path path) {
    this.path = path;
  }

  /**
   * creates appropriate ContentCollections based on an .md file's content
   *
   * @param nc the note collection to be added to
   * @param qc the question collection to be added to
   */
  public void createContentCollections(NoteCollection nc, QuestionCollection qc) {
    String[] lines = fileContent.split(System.lineSeparator());
    String content = "";
    boolean inBracket = false;

    for (String line : lines) {
      int bracketStart = line.indexOf("[[");
      int bracketEnd = line.indexOf("]]");

      if (bracketStart >= 0) {
        inBracket = true;
        if (bracketEnd >= 0) {
          content += line.substring(bracketStart + 2, bracketEnd);
          if (content.contains(":::")) {
            createQuestionCollectionFromMd(qc, content);
          } else {
            nc.add(new Note("[[]]", content.trim()));
          }
          content = "";
          inBracket = false;
        } else {
          content += line.substring(bracketStart + 2);
        }
      } else if (inBracket) {
        if (bracketEnd >= 0) {
          content += line.substring(0, bracketEnd);
          if (content.contains(":::")) {
            createQuestionCollectionFromMd(qc, content);
          } else {
            nc.add(new Note("[[]]", content.trim()));
          }
          content = "";
          inBracket = false;
        }
      } else {
        boolean tagMatch = false;
        for (TagType tag : TagType.values()) {
          if (line.startsWith(tag.getTag()) && !tagMatch) {
            tagMatch = true;
            content = line.substring(tag.getTag().length() + 1);
            nc.add(new Note(tag.getTag(), content.trim()));
            content = "";
          }
        }
      }
    }
  }

  /**
   * Creates a question collection from an .md file
   *
   * @param qc the question collection to add the question to
   * @param content the content to be formatted to a question
   */
  public void createQuestionCollectionFromMd(QuestionCollection qc, String content) {
    int questionSeparatorStart = content.indexOf(":::");

    String question = content.substring(0, questionSeparatorStart).trim();
    String answer = content.substring(questionSeparatorStart + 3).trim();

    HardQuestion hq = new HardQuestion(question, answer);
    qc.addToHardQuestions(hq);
    qc.addToQuestionCollection(hq);
  }

  /**
   * creates a question collection from a properly formatted .sr file
   *
   * @param qc the question collection to add the question to
   */
  public void createQuestionCollectionFromSr(QuestionCollection qc) {
    String[] lines = fileContent.split(System.lineSeparator());

    for (int i = 0; i < lines.length - 1; i++) {
      String line = lines[i];
      if (line.startsWith("Q HARD")) {
        String question = line.substring(line.indexOf(":") + 1).trim();
        String answer = lines[i + 1].substring(4).trim();
        HardQuestion hq = new HardQuestion(question, answer);
        qc.addToQuestionCollection(hq);
        qc.addToHardQuestions(hq);
      } else if (line.startsWith("Q EASY")) {
        String question = line.substring(line.indexOf(":") + 1).trim();
        String answer = lines[i + 1].substring(4).trim();
        EasyQuestion eq = new EasyQuestion(question, answer);
        qc.addToQuestionCollection(eq);
        qc.addToEasyQuestions(eq);
      }
    }
  }
}
