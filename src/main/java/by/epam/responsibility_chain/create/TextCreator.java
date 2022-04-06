package by.epam.responsibility_chain.create;

import by.epam.composite.entities.BaseTextStructure;
import by.epam.composite.entities.TextStructureNode;
import by.epam.tools.CustomTextTools;
import java.util.ArrayList;
import java.util.List;

public class TextCreator extends AbstractCreator {

  private static final String PARAGRAPH_DELIMITER = "\t";

  @Override
  public BaseTextStructure doSomething(String textData) {
    List<BaseTextStructure> paragraphsStructure = new ArrayList<>();
    BaseTextStructure textStructure = new TextStructureNode();

    for (String singleParagraph : CustomTextTools.customSplit(textData, PARAGRAPH_DELIMITER)) {
      BaseTextStructure paragraphStructure = nextDoSomething(singleParagraph);
      paragraphStructure.setFatherNode(textStructure);
      paragraphsStructure.add(paragraphStructure);
    }

    textStructure.setChildNodes(paragraphsStructure);
    return textStructure;
  }
}
