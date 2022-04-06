package by.epam.responsibility_chain.read;

import by.epam.composite.entities.BaseTextStructure;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;

public class UniqueWordsCounter extends AbstractReader {

  @Override
  public String doSomething(BaseTextStructure data) {
    List<String> words = separateSingleWords(data);
    StringBuilder countedWordsStringResponse = new StringBuilder();

    for (String countedWord : countUniqueWordsInList(words)){
      countedWordsStringResponse.append(countedWord);
    }

    return countedWordsStringResponse.toString();
  }

  @NotNull
  private List<String> countUniqueWordsInList(List<String> words) {
    List<String> countedWordsList = new ArrayList<>();
    for (int i = 0; i < words.size(); ) {
      String word = words.get(i);
      countedWordsList.add("{" + word + ":" + words.stream().filter(x -> x.equals(word)).count()
          + "}\s");
      words = words.stream().filter(x -> !(x.equals(word))).collect(Collectors.toList());
      i = 0;
    }
    return countedWordsList;
  }

  @NotNull
  private List<String> separateSingleWords(BaseTextStructure data) {
    return data.getChildNodes().stream().flatMap(p -> p.getChildNodes().stream())
        .flatMap(s -> s.getChildNodes().stream()).map(
            w -> w.toString().replaceAll("([.,?!]\\B)|(\\(|\\))|(\\A-\\Z)|“|”", "")
                .toLowerCase(Locale.ROOT)).filter(x -> x.matches("[^.:?!=]+"))
        .collect(Collectors.toList());
  }
}
