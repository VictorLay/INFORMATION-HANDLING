package by.epam.responsibility_chain.create;

import by.epam.composite.entities.BaseTextStructure;
import by.epam.composite.entities.TextStructureNode;
import by.epam.tools.CustomTextTools;
import java.util.ArrayList;
import java.util.List;

public class TextCreator extends AbstractCreator {

  @Override
  public BaseTextStructure doSomething(String textData) {
    List<BaseTextStructure> paragraphs = new ArrayList<>();
    BaseTextStructure textStructure = new TextStructureNode();

    for (String singleParagraph : CustomTextTools.customSplit(textData, "\t")) {
      BaseTextStructure paragraphStructure = nextDoSomething(singleParagraph);
      paragraphStructure.setFatherNode(textStructure);
      paragraphs.add(paragraphStructure);
    }

    textStructure.setChildNodes(paragraphs);
    return textStructure;
  }
}
