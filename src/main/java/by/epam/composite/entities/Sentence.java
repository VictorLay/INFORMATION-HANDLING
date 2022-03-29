package by.epam.composite.entities;

import by.epam.tools.CustomTools;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Sentence {
  String sent;
  Logger log = LogManager.getLogger();
  private List<Word> wordList;
  String sentText="";

  public Sentence(String sentenceData) {
    wordList = new ArrayList<>();
    setWordList(sentenceData);

//    log.info(sent);

  }

  public void setWordList(String sentenceData){
    CustomTools tool = new CustomTools();
    for (String singleWord : tool.customSplit(sentenceData,"\s")) { //"[\\s.]{1}([.]{2})?"
//      log.debug(singleWord);
      sentText += singleWord +"\n";
      wordList.add(new Word(singleWord));
    }

  }
  public String getInstance() {
    StringBuilder sentence = new StringBuilder();
    for(Word word: wordList){
      sentence.append(word.getInstance()).append("\s");
    }
    return sentence.toString();
  }
}
