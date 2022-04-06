package by.epam.responsibility_chain.read;

import by.epam.composite.entities.BaseTextStructure;

public class AsSentenceReader extends AbstractReader {

  @Override
  public String doSomething(BaseTextStructure sentenceparagraphStructure) {
    StringBuilder sentenceBuilder = new StringBuilder();

    for (BaseTextStructure wordStructure : sentenceparagraphStructure.getChildNodes()) {
      sentenceBuilder.append(nextDoSomething(wordStructure));
    }

    return sentenceBuilder.toString();
  }
}
