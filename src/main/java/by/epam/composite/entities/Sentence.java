package by.epam.composite.entities;

import java.util.List;

public class Sentence extends BaseTextStructure {

  public Sentence(List<BaseTextStructure> wordList) {
    setChildNodes(wordList);
  }

  @Override
  public String toString() {
    StringBuilder sentence = new StringBuilder();
    for (BaseTextStructure word : getChildNodes()) {
      sentence.append(word);
    }
//    sentence.append("\n");
    return sentence.toString();
  }
}
