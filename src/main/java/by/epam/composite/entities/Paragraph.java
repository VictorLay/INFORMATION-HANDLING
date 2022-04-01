package by.epam.composite.entities;

import java.util.List;

public class Paragraph extends BaseTextStructure{

  public Paragraph(List<BaseTextStructure> sentenceList) {
    super.setChildNodes(sentenceList);
  }

  @Override
  public String toString() {
    StringBuilder paragraph = new StringBuilder();
    paragraph.append("\n\t");
    for(BaseTextStructure sentence : super.getChildNodes()){
      paragraph.append(sentence);
    }
//    paragraph.append("\n");
    return paragraph.toString();
  }
}
