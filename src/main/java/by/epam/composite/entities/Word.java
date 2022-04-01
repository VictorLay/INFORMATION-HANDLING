package by.epam.composite.entities;

import java.util.List;

public class Word extends BaseTextStructure {

  public Word(List<BaseTextStructure> letterList) {
    setChildNodes(letterList);
  }

  @Override
  public String toString() {
    StringBuilder word = new StringBuilder();
    for (BaseTextStructure letter : getChildNodes()) {
      word.append(letter);
    }
    word.append("\s");
    return word.toString();
  }
}
