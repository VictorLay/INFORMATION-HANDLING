package by.epam.responsibility_chain.read;

import by.epam.composite.entities.BaseTextStructure;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class UniqueWordsCounter extends AbstractReader {

  @Override
  public String doSomething(BaseTextStructure data) {
    List<String> words = data.getChildNodes().stream().flatMap(p -> p.getChildNodes().stream())
        .flatMap(s -> s.getChildNodes().stream()).map(
            w -> w.toString().replaceAll("([.,?!]\\B)|(\\(|\\))|(\\A-\\Z)|“|”", "")
                .toLowerCase(Locale.ROOT)).filter(x -> x.matches("[^.:?!=]+"))
        .collect(Collectors.toList());

    StringBuilder response = new StringBuilder();
    for (int i = 0; i < words.size(); ) {
      String word = words.get(i);
      response.append("{" + word + ":" + words.stream().filter(x -> x.equals(word)).count()
          + "}\s");
      words = words.stream().filter(x -> !(x.equals(word))).collect(Collectors.toList());
      i = 0;
    }

    return response.toString();
  }
}
