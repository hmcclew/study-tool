package cs3500.pa01.visitor;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class to test methods for FileVisitor
 */
class FileVisitorTest {

  String content;

  Path path;

  Path nonexistentPath;

  FileVisitor fileVisitor;

  /**
   * setups up a path and visitor to be used for tests
   */
  @BeforeEach
  public void setup() throws IOException {
    content = "test string";
    path = Paths.get("TestFiles", "Test.md");
    nonexistentPath = Paths.get("NonExistentFolder", "file.txt");
    fileVisitor = new FileVisitor();
  }

  /**
   * tests that files are correctly visited and added to the
   * array list of files of the fileVisitor
   */
  @Test
  public void testVisitFile() throws IOException {
    Files.walkFileTree(path, fileVisitor);

    ArrayList<Path> files = fileVisitor.getFiles();
    assertTrue(files.contains(path));

    Files.walkFileTree(nonexistentPath, fileVisitor);
    BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);

    assertTrue(fileVisitor.visitFile(nonexistentPath, attr) == FileVisitResult.CONTINUE);
  }

  /**
   * Tests that the correct exception is thrown when a file cannot be visited
   */
  @Test
  public void testVisitFileFailed() throws IOException {
    IOException exception = new IOException("File cannot be visited");

    FileVisitResult result = fileVisitor.visitFileFailed(nonexistentPath, exception);

    assertTrue(result == FileVisitResult.CONTINUE);
  }

}