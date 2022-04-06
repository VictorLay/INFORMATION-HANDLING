package by.epam.responsibility_chain.update;

import by.epam.composite.entities.BaseTextStructure;
import java.util.stream.Collectors;

public class InvalidSentenceFromParagraphRemover extends AbstractUpdater {

  private int minWordQuantity;

  public InvalidSentenceFromParagraphRemover(int minWordQuantity) {
    this.minWordQuantity = minWordQuantity;
  }

  @Override
  public BaseTextStructure doSomething(BaseTextStructure paragraphStructure) {

    paragraphStructure.setChildNodes(paragraphStructure.getChildNodes().stream()
        .filter(sentenceStructure -> sentenceStructure.getChildNodes().size() >= minWordQuantity)
        .collect(Collectors.toList()));
    return paragraphStructure;
  }
}
