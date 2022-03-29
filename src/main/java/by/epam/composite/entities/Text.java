package by.epam.composite.entities;

import by.epam.tools.CustomTools;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Text {
  private Logger log = LogManager.getLogger(Text.class);
  private List<Paragraph> paragraphList;

  //Test variable
  public String sentText ="";


  public Text() {
    paragraphList = new ArrayList<>();

  }

  public Text(String text) {
    paragraphList = new ArrayList<>();
    setText(text);
  }

  public void setText(String textData) {
    CustomTools tool = new CustomTools();
    for (String singleParagraph : tool.customSplit(textData,"\t")) {
      sentText += "\t" + singleParagraph +"\n";
      paragraphList.add(new Paragraph(singleParagraph));
    }
  }


  public String getInstance(){

    StringBuilder text = new StringBuilder();

    for(Paragraph paragraph: paragraphList){
      text.append("\t").append(paragraph.getInstance()).append("\n");
    }
    return text.toString();
  }
}
