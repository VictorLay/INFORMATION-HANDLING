package by.epam.composite.entities;

import by.epam.tools.CustomTextTools;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Text extends BaseTextStructure{
  private Logger log = LogManager.getLogger(Text.class);
  private List<BaseTextStructure> paragraphList;

  //Test variable
  public String sentText ="";


  public Text() {
    paragraphList = new ArrayList<>();

  }

  public Text(String text) {
    paragraphList = new ArrayList<>();
    setInstance(text);
  }

  public Text(List<BaseTextStructure> paragraphList) {
    this.paragraphList = paragraphList;
  }

  public void setInstance(String textData) {
//    CustomTextTools tool = new CustomTextTools();
    for (String singleParagraph : CustomTextTools.customSplit(textData,"\t")) {
      sentText += "\t" + singleParagraph +"\n";
      paragraphList.add(new Paragraph(singleParagraph));
    }
  }


  public String getInstance(){

    StringBuilder text = new StringBuilder();

    for(BaseTextStructure paragraph: paragraphList){
      text.append("\t").append(paragraph.getInstance()).append("\n");
    }
    return text.toString();
  }
}
