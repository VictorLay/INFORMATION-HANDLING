package by.epam.composite.entities;

import java.util.List;

public class Text extends BaseTextStructure {

  public Text(List<BaseTextStructure> paragraphList) {
    super.setChildNodes(paragraphList);
  }

  @Override
  public String toString() {
    StringBuilder text = new StringBuilder();
    for (BaseTextStructure paragraph : super.getChildNodes()) {
      text.append(paragraph);
    }
    return text.toString();
  }
}

//todo the all methods (which extended BaseStructure) have a same field "List<BaseStructure>"
// replace this field to BaseStructure abstract class
