package cs3500.pa01.reader;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa01.contentCollection.NoteCollection;
import cs3500.pa01.contentCollection.QuestionCollection;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;

/**
 * Class to test methods for FileReader
 */
class FileReaderTest {

  /**
   * Tests that noteCollections are properly created
   * based on the data within a file
   */
  @Test
  public void testCreateNoteCollection() {
    NoteCollection nc1 = new NoteCollection();
    Path p1 = Paths.get("SampleData", "vectors.md");
    FileReader fr1 = new FileReader();
    fr1.read(p1.toString());
    QuestionCollection qc = new QuestionCollection();
    fr1.createContentCollections(nc1, qc);

    assertEquals("#", nc1.getNote(0).getTag());
    assertEquals("Vectors", nc1.getNote(0).getContent());
    assertEquals("[[]]", nc1.getNote(1).getTag());
    assertEquals("Vectors act like resizable arrays",
        nc1.getNote(1).getContent());
    assertEquals("##", nc1.getNote(2).getTag());
    assertEquals("Declaring a vector",
        nc1.getNote(2).getContent());

    NoteCollection nc2 = new NoteCollection();
    Path p2 = Paths.get("SampleData", "linalg.md");
    FileReader fr2 = new FileReader();
    fr2.read(p2.toString());
    fr2.createContentCollections(nc2, qc);

    assertEquals("####", nc2.getNote(5).getTag());
    assertEquals("EigenValues", nc2.getNote(5).getContent());

    assertEquals("###", nc2.getNote(3).getTag());
    assertEquals("Matrices", nc2.getNote(3).getContent());
  }

  @Test
  public void testCreateQCFromSR() {
    Path p1 = Paths.get("TestFiles", "Test3.sr");
    FileReader fr1 = new FileReader();
    fr1.read(p1.toString());
    QuestionCollection qc = new QuestionCollection();
    fr1.createQuestionCollectionFromSr(qc);
  }

  /**
   * Tests that the path of the File Reader
   * is properly set
   */
  @Test
  public void testSetPath() {
    Path p1 = Paths.get("SampleData", "vectors.md");
    Path p2 = Paths.get("SampleData", "arrays.md");
    FileReader fr1 = new FileReader();
    fr1.read(p1.toString());
    fr1.setPath(p2);

    assertEquals(p2, fr1.path);
  }
}