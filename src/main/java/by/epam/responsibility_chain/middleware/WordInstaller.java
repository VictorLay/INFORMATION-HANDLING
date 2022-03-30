package by.epam.responsibility_chain.middleware;

import static by.epam.composite.entities.Word.ILLEGAL_STRINGS;

import by.epam.composite.entities.BaseTextStructure;
import by.epam.composite.entities.Letter;
import by.epam.composite.entities.Word;
import by.epam.tools.CustomTextTools;
import java.util.ArrayList;
import java.util.List;

public class WordInstaller extends AbstractInstaller{

  @Override
  public BaseTextStructure doSomethingWithThisShit(String wordData) {
    List<BaseTextStructure> letters = new ArrayList<>();
    for (char singleLetter : wordData.toCharArray()) {
      letters.add(nextDoSomething(String.valueOf(singleLetter)));
    }
    return new Word(letters);
  }
}
