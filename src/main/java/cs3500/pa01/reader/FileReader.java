package cs3500.pa01.reader;

import cs3500.pa01.contentCollection.QuestionCollection;
import cs3500.pa01.contentCollection.note.Note;
import cs3500.pa01.contentCollection.NoteCollection;
import cs3500.pa01.contentCollection.question.HardQuestion;
import cs3500.pa01.contentCollection.question.Question;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * A file reader that reads through a file and extracts relevant text
 */
public class FileReader {
  Path path;
  Scanner scanner = null;
  String fileContent = "";

  public FileReader(String p1) {
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
   * Edits a NoteCollection to include all Notes of the p field
   * in the correct format
   *
   * @param nc the note collection for which to add each created note
   */
  public void createNoteCollection(NoteCollection nc, QuestionCollection qc) {
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
            createQuestionCollection(qc, content);
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
            createQuestionCollection(qc, content);
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

  public void createQuestionCollection(QuestionCollection qc, String content) {
    int questionSeparatorStart = content.indexOf(":::");

    String question = content.substring(0,questionSeparatorStart).trim();
    String answer = content.substring(questionSeparatorStart + 3).trim();

    HardQuestion hq = new HardQuestion(question, answer);
    qc.addToHardQuestions(hq);
    qc.addToQuestionCollection(hq);
  }
}
