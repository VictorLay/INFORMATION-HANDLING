package by.epam.responsibility_chain.read;

import by.epam.composite.entities.BaseTextStructure;

public class AsParagraphReader extends AbstractReader {

  @Override
  public String doSomething(BaseTextStructure paragraphStructure) {
    StringBuilder paragraphBuilder = new StringBuilder("\n\t");

    for (BaseTextStructure sentenceStructure : paragraphStructure.getChildNodes()) {
      paragraphBuilder.append(nextDoSomething(sentenceStructure));
    }

    return paragraphBuilder.toString();
  }
}
