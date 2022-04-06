package by.epam.responsibility_chain.create;

import by.epam.composite.entities.BaseTextStructure;
import by.epam.composite.entities.TextStructureNode;
import by.epam.tools.CustomTextTools;
import java.util.ArrayList;
import java.util.List;

public class ParagraphCreator extends AbstractCreator {

  private static final String SENTENCE_DELIMITERS = "[.?!]([.]{2})?([\s\n])";

  @Override
  public BaseTextStructure doSomething(String paragraphData) {
    List<BaseTextStructure> sentencesStructure = new ArrayList<>();
    BaseTextStructure paragraphStructures = new TextStructureNode();

    for (String singleSentence : CustomTextTools.customSplit(paragraphData, SENTENCE_DELIMITERS)) {
      BaseTextStructure sentenceStructure = nextDoSomething(singleSentence);
      sentenceStructure.setFatherNode(paragraphStructures);
      sentencesStructure.add(sentenceStructure);
    }

    paragraphStructures.setChildNodes(sentencesStructure);
    return paragraphStructures;
  }
}
