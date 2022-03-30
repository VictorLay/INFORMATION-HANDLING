package by.epam.responsibility_chain.middleware;

import by.epam.composite.entities.BaseTextStructure;
import by.epam.composite.entities.Sentence;
import by.epam.tools.CustomTextTools;
import java.util.ArrayList;
import java.util.List;

public class SentenceInstaller extends AbstractInstaller{

  @Override
  public BaseTextStructure doSomethingWithThisShit(String sentenceData) {
    List<BaseTextStructure> words = new ArrayList<>();
    for (String singleWord : CustomTextTools.customSplit(sentenceData,"\s")) { //"[\\s.]{1}([.]{2})?"
      words.add(nextDoSomething(singleWord));
    }
    return new Sentence(words);
  }
}
