package by.epam.composite.entities;

import by.epam.tools.CustomTextTools;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Sentence extends BaseTextStructure{
  String sent;
  Logger log = LogManager.getLogger();
  private List<BaseTextStructure> wordList;
  String sentText="";

  public Sentence(List<BaseTextStructure> wordList) {
    this.wordList = wordList;
  }

  public Sentence(String sentenceData) {
    wordList = new ArrayList<>();
    setInstance(sentenceData);

//    log.info(sent);

  }

  public void setInstance(String sentenceData){
//    CustomTextTools tool = new CustomTextTools();
    for (String singleWord : CustomTextTools.customSplit(sentenceData,"\s")) { //"[\\s.]{1}([.]{2})?"
//      log.debug(singleWord);
      sentText += singleWord +"\n";
      wordList.add(new Word(singleWord));
    }

  }
  public String getInstance() {
    StringBuilder sentence = new StringBuilder();
    for(BaseTextStructure word: wordList){
      sentence.append(word.getInstance()).append("\s");
    }
    return sentence.toString();
  }
}
