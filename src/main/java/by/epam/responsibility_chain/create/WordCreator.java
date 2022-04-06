package by.epam.responsibility_chain.create;

import by.epam.composite.entities.BaseTextStructure;
import by.epam.composite.entities.TextStructureNode;
import java.util.ArrayList;
import java.util.List;

public class WordCreator extends AbstractCreator {

  @Override
  public BaseTextStructure doSomething(String wordData) {
    List<BaseTextStructure> lettersStructure = new ArrayList<>();
    BaseTextStructure wordStructure = new TextStructureNode();

    for (char singleLetter : wordData.toCharArray()) {
      BaseTextStructure letterStructure = nextDoSomething(String.valueOf(singleLetter));
      letterStructure.setFatherNode(wordStructure);
      lettersStructure.add(letterStructure);
    }

    wordStructure.setChildNodes(lettersStructure);
    return wordStructure;
  }
}
