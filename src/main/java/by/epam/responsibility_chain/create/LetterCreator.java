package by.epam.responsibility_chain.create;

import by.epam.composite.entities.BaseTextStructure;
import by.epam.composite.entities.TextStructureNode;

public class LetterCreator extends AbstractCreator {

  @Override
  public BaseTextStructure doSomething(String letterData) {
    TextStructureNode letterNode = new TextStructureNode();

    letterNode.setNodeObject(letterData.toCharArray()[0]);
    return letterNode;
  }
}
