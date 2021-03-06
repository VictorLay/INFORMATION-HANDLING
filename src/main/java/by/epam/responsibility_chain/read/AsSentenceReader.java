package by.epam.responsibility_chain.read;

import by.epam.composite.entities.BaseTextStructure;

public class AsSentenceReader extends AbstractReader {

  @Override
  public String doSomething(BaseTextStructure sentenceStructure) {
    StringBuilder sentenceBuilder = new StringBuilder();

    for (BaseTextStructure wordStructure : sentenceStructure.getChildNodes()) {
      sentenceBuilder.append(nextDoSomething(wordStructure));
    }

    return sentenceBuilder.toString();
  }
}
