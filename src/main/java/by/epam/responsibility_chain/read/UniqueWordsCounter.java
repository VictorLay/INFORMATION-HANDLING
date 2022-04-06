package by.epam.responsibility_chain.read;

import by.epam.composite.entities.BaseTextStructure;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;

public class UniqueWordsCounter extends AbstractReader {

  private static final String NOT_A_LETTER_SYMBOL = "([.,?!]\\B)|(\\(|\\))|(\\A-\\Z)|“|”";
  private static final String EXCLUDE_AN_EXPRESSION_SYMBOL = "[^.:?!=]+";

  @Override
  public String doSomething(BaseTextStructure textStructure) {
    StringBuilder countedWordsStringResponse = new StringBuilder();

    for (String countedWord : countUniqueWordsInList(separateSingleWords(textStructure))) {
      countedWordsStringResponse.append(countedWord);
    }
    return countedWordsStringResponse.toString();
  }

  @NotNull
  private List<String> countUniqueWordsInList(List<String> words) {
    List<String> countedWordsList = new ArrayList<>();
    for (int i = 0; i < words.size(); ) {
      String word = words.get(i);
      countedWordsList.add(
          "{" + word + ":" + words.stream().filter(x -> x.equals(word)).count() + "}\s");
      words = words.stream().filter(x -> !(x.equals(word))).collect(Collectors.toList());
      i = 0;
    }
    return countedWordsList;
  }

  @NotNull
  private List<String> separateSingleWords(BaseTextStructure textStructure) {
    return textStructure.getChildNodes().stream()
        .flatMap(paragraphStructure -> paragraphStructure.getChildNodes().stream())
        .flatMap(sentenceStructure -> sentenceStructure.getChildNodes().stream()).map(
            wordStructure -> wordStructure.toString().replaceAll(NOT_A_LETTER_SYMBOL, "")
                .toLowerCase(Locale.ROOT))
        .filter(wordString -> wordString.matches(EXCLUDE_AN_EXPRESSION_SYMBOL))
        .collect(Collectors.toList());
  }
}
