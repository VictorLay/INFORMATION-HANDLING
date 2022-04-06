package by.epam.responsibility_chain.read;

import by.epam.composite.entities.BaseTextStructure;
import java.util.Locale;

public class VowelsLettersCounter extends AbstractReader {

  private static final String VOWEL_LETTERS = "[AEIOUY]";

  @Override
  public String doSomething(BaseTextStructure textStructure) {
    return String.valueOf(textStructure.getChildNodes().stream()
        .flatMap(paragraphStructure -> paragraphStructure.getChildNodes().stream())
        .flatMap(sentenceStructure -> sentenceStructure.getChildNodes().stream())
        .flatMap(wordStructure -> wordStructure.getChildNodes().stream()).filter(
            letterStructure -> letterStructure.toString().toUpperCase(Locale.ROOT)
                .matches(VOWEL_LETTERS)).count());
  }
}
