package by.epam.responsibility_chain.create;

import by.epam.composite.entities.BaseTextStructure;
import by.epam.composite.entities.TextStructureNode;
import by.epam.tools.CustomTextTools;
import java.util.ArrayList;
import java.util.List;

public class SentenceCreator extends AbstractCreator {

  private static final String WORD_DELIMITER = "\s";

  @Override
  public BaseTextStructure doSomething(String sentenceData) {
    List<BaseTextStructure> wordsStructure = new ArrayList<>();
    BaseTextStructure sentenceStructure = new TextStructureNode();

    for (String singleWord : CustomTextTools.customSplit(sentenceData, WORD_DELIMITER)) {
      BaseTextStructure wordStructure = nextDoSomething(singleWord);
      wordStructure.setFatherNode(sentenceStructure);
      wordsStructure.add(wordStructure);
    }

    sentenceStructure.setChildNodes(wordsStructure);
    return sentenceStructure;
  }
}
