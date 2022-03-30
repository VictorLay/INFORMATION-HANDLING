package by.epam.responsibility_chain.middleware;

import by.epam.composite.entities.BaseTextStructure;
import by.epam.composite.entities.Text;
import by.epam.tools.CustomTextTools;
import java.util.ArrayList;
import java.util.List;

public class TextInstaller extends AbstractInstaller{


  @Override
  public BaseTextStructure doSomethingWithThisShit(String textData) {
    List<BaseTextStructure> paragraphs = new ArrayList<>();
    for (String singleParagraph : CustomTextTools.customSplit(textData,"\t")) {
      paragraphs.add(nextDoSomething(singleParagraph));
    }
    return new Text(paragraphs);
  }
}
