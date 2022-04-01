package by.epam.responsibility_chain.create;

import by.epam.composite.entities.BaseTextStructure;
import by.epam.composite.entities.TextStructureNode;
import by.epam.tools.CustomTextTools;
import java.util.ArrayList;
import java.util.List;

public class ParagraphCreator extends AbstractCreator {

  @Override
  public BaseTextStructure doSomething(String paragraphData) {
    List<BaseTextStructure> sentences = new ArrayList<>();
    BaseTextStructure paragraphStructure = new TextStructureNode();

    for (String singleSentence : CustomTextTools.customSplit(paragraphData,
        "[.?!]([.]{2})?([\s\n])")) {
      BaseTextStructure sentenceStructure = nextDoSomething(singleSentence);
      sentenceStructure.setFatherNode(paragraphStructure);
      sentences.add(sentenceStructure);
    }

    paragraphStructure.setChildNodes(sentences);
    return paragraphStructure;
  }
}
