package by.epam.responsibility_chain.middleware;

import by.epam.composite.entities.BaseTextStructure;
import by.epam.composite.entities.Letter;

public class LetterInstaller extends AbstractInstaller{

  @Override
  public BaseTextStructure doSomethingWithThisShit(String letterData) {
    return new Letter(letterData.toCharArray()[0]);
  }
}
