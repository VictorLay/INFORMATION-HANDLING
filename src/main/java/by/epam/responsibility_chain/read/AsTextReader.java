package by.epam.responsibility_chain.read;

import by.epam.composite.entities.BaseTextStructure;

public class AsTextReader extends AbstractReader {

  @Override
  public String doSomething(BaseTextStructure textStructure) {
    StringBuilder textBuilder = new StringBuilder();

    for (int i = 0; i < textStructure.getChildNodes().size(); ) {
      if (textStructure.getChildNodes().get(i).getChildNodes().isEmpty()) {
        textStructure.getChildNodes().remove(i);
        continue;
      }
      textBuilder.append(nextDoSomething(textStructure.getChildNodes().get(i)));
      i++;
    }

    return textBuilder.toString();
  }
}
