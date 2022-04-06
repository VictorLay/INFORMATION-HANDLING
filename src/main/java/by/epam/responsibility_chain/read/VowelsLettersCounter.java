package by.epam.responsibility_chain.read;

import by.epam.composite.entities.BaseTextStructure;
import java.util.Locale;

public class VowelsLettersCounter extends AbstractReader {

  @Override
  public String doSomething(BaseTextStructure data) {
  return String.valueOf(data.getChildNodes().stream().flatMap(p -> p.getChildNodes().stream())
      .flatMap(s -> s.getChildNodes().stream()).flatMap(w -> w.getChildNodes().stream())
      .filter(x -> x.toString().toUpperCase(Locale.ROOT).matches("[AEIOUY]")).count());
  }
}
