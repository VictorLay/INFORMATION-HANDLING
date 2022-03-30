package by.epam.responsibility_chain.middleware;

import by.epam.composite.entities.BaseTextStructure;
import by.epam.composite.entities.Paragraph;
import by.epam.tools.CustomTextTools;
import java.util.ArrayList;
import java.util.List;

public class ParagraphInstaller extends AbstractInstaller{

  @Override
  public BaseTextStructure doSomethingWithThisShit(String paragraphData) {
    List<BaseTextStructure> sentences = new ArrayList<>();
    for (String singleSentence : CustomTextTools.customSplit(paragraphData,"[.?!]([.]{2})?([\s\n])")) {
      sentences.add(nextDoSomething(singleSentence));
    }
    return new Paragraph(sentences);
  }
}
