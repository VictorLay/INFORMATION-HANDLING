package by.epam.responsibility_chain.read;

import by.epam.composite.entities.BaseTextStructure;

public class AsWordReader extends AbstractReader {

  @Override
  public String doSomething(BaseTextStructure wordData) {
    StringBuilder wordBuilder = new StringBuilder();
    for (BaseTextStructure letterStructure : wordData.getChildNodes()) {
      wordBuilder.append(nextDoSomething(letterStructure));
    }
    return wordBuilder.append("\s").toString();
  }
}
