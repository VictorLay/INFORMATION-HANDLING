package by.epam.responsibility_chain.workchain;

import by.epam.composite.entities.BaseTextStructure;
import by.epam.composite.entities.TextStructureNode;
import java.util.List;

public class SentenceWithLongestWordFinder extends AbstractUpdater {

  /**
   * Usage with {@link MostChildrenQuantityFinder#doSomething(BaseTextStructure)}
   * compare the longest words of sentences and return sentence with the longest
   * words as {@link  TextStructureNode} object.
   */
  @Override
  public BaseTextStructure doSomething(BaseTextStructure paragraph) {

    List<BaseTextStructure> sentences = paragraph.getChildNodes();
    BaseTextStructure sentenceWithLongestWordInParagraph = new TextStructureNode();
    BaseTextStructure longestWordInParagraph = new TextStructureNode();

    for (BaseTextStructure sentence : sentences) {
      BaseTextStructure longestWordInThisSentence = nextDoSomething(sentence);

      if (longestWordInThisSentence.getChildNodes().size() > longestWordInParagraph.getChildNodes()
          .size()) {
        sentenceWithLongestWordInParagraph.setChildNodes(sentence.getChildNodes());
        longestWordInParagraph.setChildNodes(longestWordInThisSentence.getChildNodes());
      }
    }

    return sentenceWithLongestWordInParagraph;
  }
}
