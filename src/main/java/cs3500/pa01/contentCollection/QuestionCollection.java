package cs3500.pa01.contentCollection;

import cs3500.pa01.contentCollection.questions.AbstractQuestion;
import java.util.ArrayList;

/**
 * Represents a collection of questions
 */
public class QuestionCollection implements ContentCollection {

  private ArrayList<AbstractQuestion> questionCollection = new ArrayList<>();

  /**
   * Adds a question to this instance's questionCollection
   *
   * @param q the question to be added
   */
  public void add(AbstractQuestion q) {
    questionCollection.add(q);
  }

  /**
   * Gets the question in this instance's questionCollection at the given index
   *
   * @param index the index of the question to be returned
   * @return the question at the given index of questionCollection
   */
  @Override
  public AbstractQuestion get(int index) {
    return questionCollection.get(index);
  }

  /**
   * Converts the content of this QuestionCollection to a single string
   *
   * @return the new string of this QuestionCollection's content
   */
  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    for (AbstractQuestion q : this.questionCollection) {
        s.append(q);
      }
    return s.toString();
  }
}

