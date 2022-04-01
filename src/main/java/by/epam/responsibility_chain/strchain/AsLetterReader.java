package by.epam.responsibility_chain.strchain;

import by.epam.composite.entities.BaseTextStructure;

public class AsLetterReader extends AbstractReader {

  @Override
  public String doSomething(BaseTextStructure letterData) {
    return letterData.getNodeObject().toString();
  }
}