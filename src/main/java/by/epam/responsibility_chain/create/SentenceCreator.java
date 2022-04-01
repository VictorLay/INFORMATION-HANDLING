package by.epam.responsibility_chain.create;

import by.epam.composite.entities.BaseTextStructure;
import by.epam.composite.entities.TextStructureNode;
import by.epam.tools.CustomTextTools;
import java.util.ArrayList;
import java.util.List;

public class SentenceCreator extends AbstractCreator {

  @Override
  public BaseTextStructure doSomething(String sentenceData) {
    List<BaseTextStructure> words = new ArrayList<>();
    BaseTextStructure sentenceStructure = new TextStructureNode();

    for (String singleWord : CustomTextTools.customSplit(sentenceData, "\s")) {
      BaseTextStructure wordStructure = nextDoSomething(singleWord);
      wordStructure.setFatherNode(sentenceStructure);
      words.add(wordStructure);
    }

    sentenceStructure.setChildNodes(words);
    return sentenceStructure;
  }
}
