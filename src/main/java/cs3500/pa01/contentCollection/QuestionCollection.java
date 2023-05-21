package cs3500.pa01.contentCollection;

import cs3500.pa01.contentCollection.question.AbstractQuestion;
import cs3500.pa01.contentCollection.question.EasyQuestion;
import cs3500.pa01.contentCollection.question.HardQuestion;
import cs3500.pa01.contentCollection.question.QuestionDifficulty;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Represents a collection of questions
 */
public class QuestionCollection implements ContentCollection {

  public ArrayList<AbstractQuestion> questionCollection = new ArrayList<>();
  public ArrayList<HardQuestion> hardQuestions;
  public ArrayList<EasyQuestion> easyQuestions;

  public QuestionCollection(ArrayList<HardQuestion> hardQuestions,
                            ArrayList<EasyQuestion> easyQuestions, int numQuestions) {
    this.hardQuestions = hardQuestions;
    this.easyQuestions = easyQuestions;
    this.createQuestionCollection(numQuestions);
  }

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

  public void createQuestionCollection(int numQuestions) {
    Collections.shuffle(hardQuestions);
    Collections.shuffle(easyQuestions);
    questionCollection.clear();

    Random random = new Random();

    int remainingQuestions = numQuestions;
    int numHardQuestions = Math.min(random.nextInt(remainingQuestions + 1),
        hardQuestions.size());
    remainingQuestions -= numHardQuestions;
    int numEasyQuestions = Math.min(remainingQuestions, easyQuestions.size());

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

