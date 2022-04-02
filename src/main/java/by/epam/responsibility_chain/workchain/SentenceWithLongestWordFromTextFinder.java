package by.epam.responsibility_chain.workchain;

import by.epam.composite.entities.BaseTextStructure;
import by.epam.composite.entities.TextStructureNode;
import java.util.ArrayList;
import java.util.List;

public class SentenceWithLongestWordFromTextFinder extends AbstractUpdater {

  @Override
  public BaseTextStructure doSomething(BaseTextStructure textData) {

    List<BaseTextStructure> paragraphs = textData.getChildNodes();
    List<BaseTextStructure> sortedSentencesList = new ArrayList<>();

    for (BaseTextStructure paragraph : paragraphs) {
      BaseTextStructure sentenceWithLongestWord = nextDoSomething(paragraph);
      sortedSentencesList.add(sentenceWithLongestWord);
    }
    BaseTextStructure sentenceWithLongestWord = nextDoSomething(
        new TextStructureNode(sortedSentencesList));

    return createTextWithSingleParagraphAndSentence(sentenceWithLongestWord);
  }


  private BaseTextStructure createTextWithSingleParagraphAndSentence(
      BaseTextStructure sentenceWithLongestWord) {
    List<BaseTextStructure> sentenceList = new ArrayList<>();
    sentenceList.add(sentenceWithLongestWord);
    BaseTextStructure paragraph = new TextStructureNode(sentenceList);
    List<BaseTextStructure> paragraphList = new ArrayList<>();
    paragraphList.add(paragraph);

    return new TextStructureNode(paragraphList);
  }
}
