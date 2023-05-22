package cs3500.pa01.contentcollection;

import cs3500.pa01.contentcollection.question.AbstractQuestion;
import cs3500.pa01.contentcollection.question.EasyQuestion;
import cs3500.pa01.contentcollection.question.HardQuestion;
import cs3500.pa01.contentcollection.question.QuestionDifficulty;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents a collection of questions
 */
public class QuestionCollection implements ContentCollection {

  protected ArrayList<AbstractQuestion> questionCollection = new ArrayList<>();
  protected ArrayList<HardQuestion> hardQuestions = new ArrayList<>();
  protected ArrayList<EasyQuestion> easyQuestions = new ArrayList<>();

  /**
   * Empty Constructor
   */
  public QuestionCollection() {
  }

  /**
   * Constructor for a QuestionCollection
   *
   * @param hardQuestions HardQuestions to choose from
   * @param easyQuestions EasyQuestions to choose from
   * @param numQuestions the number of questions to include in the final
   *                     question collection
   */
  public QuestionCollection(ArrayList<HardQuestion> hardQuestions,
                            ArrayList<EasyQuestion> easyQuestions, int numQuestions) {
    this.hardQuestions = hardQuestions;
    this.easyQuestions = easyQuestions;
    this.makeQuestionCollection(numQuestions);
  }

  /**
   * Constructor that uses all hard and easy questions
   *
   * @param hardQuestions hard questions to choose from
   * @param easyQuestions easy questions to choose from
   */
  public QuestionCollection(ArrayList<HardQuestion> hardQuestions,
                            ArrayList<EasyQuestion> easyQuestions) {
    this.hardQuestions = hardQuestions;
    this.easyQuestions = easyQuestions;
    this.makeQuestionCollection(hardQuestions.size() + easyQuestions.size());
  }

  /**
   * Updated this question collection to add only unique elements of the parameter
   *
   * @param qc the question collection to be added to this question collection
   */
  public void updateCollection(ArrayList<AbstractQuestion> qc) {
    Set<String> uniqueQuestions = new HashSet<>();

    for (AbstractQuestion q : questionCollection) {
      uniqueQuestions.add(q.getQuestion());
    }
    for (AbstractQuestion q : qc) {
      if (!uniqueQuestions.contains(q.getQuestion())) {
        questionCollection.add(q);
      }
    }
  }

  /**
   * Getter method for questionCollection
   *
   * @return this instance's questionCollection
   */
  public ArrayList<AbstractQuestion> getQuestionCollection() {
    return this.questionCollection;
  }

  /**
   * Getter method for hardQuestions
   *
   * @return this instance's hardQuestions
   */
  public ArrayList<HardQuestion> getHardQuestions() {
    return this.hardQuestions;
  }

  /**
   * Getter method for easyQuestions
   *
   * @return this instance's easyQuestions
   */
  public ArrayList<EasyQuestion> getEasyQuestions() {
    return this.easyQuestions;
  }

  /**
   * Get the number of easy questions in this QC
   *
   * @return the number of easy questions
   */
  public int numEasyQuestions() {
    return easyQuestions.size();
  }

  /**
   * Get the number of hard questions in this QC
   *
   * @return the number of hard questions
   */
  public int numHardQuestions() {
    return hardQuestions.size();
  }

  /**
   * update the parameter question's difficulty level in this question collection
   *
   * @param q the question to be updated
   */
  public void changeQuestionDifficulty(AbstractQuestion q) {
    if (q.questionDifficulty.equals(QuestionDifficulty.HARD)) {
      EasyQuestion updatedQuestion = new EasyQuestion(q.questionText, q.answer);
      hardQuestions.remove(q);
      easyQuestions.add(updatedQuestion);
    } else {
      HardQuestion updatedQuestion = new HardQuestion(q.questionText, q.answer);
      easyQuestions.remove(q);
      hardQuestions.add(updatedQuestion);
    }
  }

  /**
   * Creates a question collection from the hard and easy questions
   *
   * @param numQuestions the number of questions to include in the final question collection
   */
  public void makeQuestionCollection(int numQuestions) {
    Collections.shuffle(hardQuestions);
    Collections.shuffle(easyQuestions);

    questionCollection.clear();

    int numHardQuestions = Math.min(numQuestions, hardQuestions.size());
    int numEasyQuestions = Math.min(numQuestions - numHardQuestions, easyQuestions.size());

    for (int i = 0; i < numHardQuestions; i++) {
      questionCollection.add(hardQuestions.get(i));
    }

    for (int i = 0; i < numEasyQuestions; i++) {
      questionCollection.add(easyQuestions.get(i));
    }
  }

  /**
   * Gets the question in this instance's questionCollection at the given index
   *
   * @param index the index of the question to be returned
   * @return the question at the given index of questionCollection
   */
  public AbstractQuestion getQuestion(int index) {
    return questionCollection.get(index);
  }

  /**
   * Adds a question to this instance's questionCollection
   *
   * @param q the question to be added
   */
  public void addToQuestionCollection(AbstractQuestion q) {
    questionCollection.add(q);
  }

  /**
   * Adds a question to this instance's hardQuestions
   *
   * @param q the question to be added
   */
  public void addToHardQuestions(HardQuestion q) {
    hardQuestions.add(q);
  }

  /**
   * Adds a question to this instance's easyQuestions
   *
   * @param q the question to be added
   */
  public void addToEasyQuestions(EasyQuestion q) {
    easyQuestions.add(q);
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

