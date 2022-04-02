package by.epam.responsibility_chain.read;

import by.epam.composite.entities.BaseTextStructure;

public class AsTextReader extends AbstractReader {

  @Override
  public String doSomething(BaseTextStructure textStructure) {
    StringBuilder textBuilder = new StringBuilder();

    for (BaseTextStructure paragraphStructure : textStructure.getChildNodes()) {
      textBuilder.append(nextDoSomething(paragraphStructure));
    }

    return textBuilder.toString();
  }
}
