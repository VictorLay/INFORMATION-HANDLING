package by.epam.composite.entities;

import by.epam.tools.CustomTextTools;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Paragraph extends BaseTextStructure{

  Logger log = LogManager.getLogger();
  private List<BaseTextStructure> sentenceList;
  //Test variable
  public String sentText ="";

  public Paragraph(String paragraph) {
    sentenceList = new ArrayList<>();
    setInstance(paragraph);
  }

  public Paragraph(List<BaseTextStructure> sentenceList) {
    this.sentenceList = sentenceList;
  }

  public List<BaseTextStructure> getSentenceList() {
    return sentenceList;
  }

  public void setInstance(String paragraphData) {
//    CustomTextTools tool = new CustomTextTools();
    for (String singleSentence : CustomTextTools.customSplit(paragraphData,"[.?!]([.]{2})?([\s\n])")) {
      sentText += singleSentence +"\n";
      sentenceList.add(new Sentence(singleSentence));
    }
//          log.debug(sentText);
  }

  public String getInstance(){

    StringBuilder paragraph = new StringBuilder();
    for(BaseTextStructure sentence: sentenceList){
      paragraph.append(sentence.getInstance());
    }
    return paragraph.toString();
  }

}
