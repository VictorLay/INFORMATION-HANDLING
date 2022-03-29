package by.epam.composite.entities;

import by.epam.tools.CustomTools;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Word {

  public static final String[] ILLEGAL_STRINGS ={""};// {".", ",", "...", "!", "?"};
  public String sentText = "";

  Logger log = LogManager.getLogger();
  private List<Letter> letterList;

  public Word(String wordData) {
    letterList = new ArrayList<>();
    setLetterList(wordData);

  }

  public void setLetterList(String wordData) {
    CustomTools tool = new CustomTools();
    for (char singleLetter : tool.clearTheChars(wordData, ILLEGAL_STRINGS).toCharArray()) {
//      log.debug(singleLetter);
      sentText += singleLetter;
      letterList.add(new Letter(singleLetter));
    }
  }

  public String getInstance(){
    StringBuilder word = new StringBuilder();
    for (Letter letter:letterList){
      word.append(letter.getInstance());
    }
    return word.toString();
  }

}
