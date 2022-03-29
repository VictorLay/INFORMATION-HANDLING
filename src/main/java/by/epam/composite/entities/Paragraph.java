package by.epam.composite.entities;

import by.epam.tools.CustomTools;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Paragraph {

  Logger log = LogManager.getLogger();
  private List<Sentence> sentenceList;
  //Test variable
  public String sentText ="";

  public Paragraph(String paragraph) {
    sentenceList = new ArrayList<>();
    setSentenceList(paragraph);
  }

  public List<Sentence> getSentenceList() {
    return sentenceList;
  }

  public void setSentenceList(String paragraphData) {
    CustomTools tool = new CustomTools();
    for (String singleSentence : tool.customSplit(paragraphData,"[.?!]([.]{2})?([\s\n])")) {
      sentText += singleSentence +"\n";
      sentenceList.add(new Sentence(singleSentence));
    }
//          log.debug(sentText);
  }

  public String getInstance(){

    StringBuilder paragraph = new StringBuilder();
    for(Sentence sentence: sentenceList){
      paragraph.append(sentence.getInstance());
    }
    return paragraph.toString();
  }

}
