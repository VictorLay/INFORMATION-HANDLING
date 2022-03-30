package by.epam.composite.entities;

import by.epam.tools.CustomTextTools;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Word extends BaseTextStructure{

  public static final String[] ILLEGAL_STRINGS ={""};// {".", ",", "...", "!", "?"};
  public String sentText = "";

  Logger log = LogManager.getLogger();
  private List<BaseTextStructure> letterList;

  public Word(String wordData) {
    letterList = new ArrayList<>();
    setInstance(wordData);
  }

  public Word(List<BaseTextStructure> letterList) {
    this.letterList = letterList;
  }

  public void setInstance(String wordData) {
//    CustomTextTools tool = new CustomTextTools();
    for (char singleLetter : CustomTextTools.clearTheChars(wordData, ILLEGAL_STRINGS).toCharArray()) {
//      log.debug(singleLetter);
      sentText += singleLetter;
      letterList.add(new Letter(singleLetter));
    }
  }

  public String getInstance(){
    StringBuilder word = new StringBuilder();
    for (BaseTextStructure letter:letterList){
      word.append(letter.getInstance());
    }
    return word.toString();
  }

}
