package by.epam.responsibility_chain.strchain;

import by.epam.composite.entities.BaseTextStructure;

public class AsParagraphReader extends AbstractReader {

  @Override
  public String doSomething(BaseTextStructure paragraphData) {
    StringBuilder paragraphBuilder = new StringBuilder("\n\t");

    for (BaseTextStructure sentenceStructure : paragraphData.getChildNodes()) {
      paragraphBuilder.append(nextDoSomething(sentenceStructure));
    }

    return paragraphBuilder.toString();
  }
}
