package by.epam.responsibility_chain.read;

import by.epam.composite.entities.BaseTextStructure;
import java.util.Comparator;

public class LongestWordSentenceFinder extends AbstractReader {


  // TODO: 05.04.2022  create isEmpty or isPresent validation for optional type

  @Override
  public String doSomething(BaseTextStructure data) {
    Comparator<BaseTextStructure> sentenceComparator = (sentence, otherSentence) ->
        sentence.getChildNodes().stream().mapToInt(w -> w.getChildNodes().size()).max().getAsInt()
            - otherSentence.getChildNodes().stream().mapToInt(w -> w.getChildNodes().size()).max()
            .getAsInt();

    return nextDoSomething(data.getChildNodes().stream().flatMap(p -> p.getChildNodes().stream())
        .max(sentenceComparator).get());
  }
}


//public class MostChildrenQuantityFinder extends AbstractUpdater {
//
//  /**
//   * Method get node of BaseTextStructure and find child-node with the most quantity of children.
//   * @return child of dataTxt which have children more that the others.
//   */
//  @Override
//  public BaseTextStructure doSomething(BaseTextStructure dataTxt) {
//
//    BaseTextStructure nodeWithHighestQuantityOfChildNodes = new TextStructureNode();
//
//    for (BaseTextStructure childNode : dataTxt.getChildNodes()) {
//      if (childNode.getChildNodes().size() > nodeWithHighestQuantityOfChildNodes.getChildNodes().size()) {
//        nodeWithHighestQuantityOfChildNodes.setChildNodes(childNode.getChildNodes());
//      }
//    }
//
//    return nodeWithHighestQuantityOfChildNodes;
//  }
//}


//public class SentenceWithLongestWordFinder extends AbstractUpdater {
//
//  /**
//   * Usage with {@link MostChildrenQuantityFinder#doSomething(BaseTextStructure)}
//   * compare the longest words of sentences and return sentence with the longest
//   * words as {@link  TextStructureNode} object.
//   */
//  @Override
//  public BaseTextStructure doSomething(BaseTextStructure paragraph) {
//
//    List<BaseTextStructure> sentences = paragraph.getChildNodes();
//    BaseTextStructure sentenceWithLongestWordInParagraph = new TextStructureNode();
//    BaseTextStructure longestWordInParagraph = new TextStructureNode();
//
//    for (BaseTextStructure sentence : sentences) {
//      BaseTextStructure longestWordInThisSentence = nextDoSomething(sentence);
//
//      if (longestWordInThisSentence.getChildNodes().size() > longestWordInParagraph.getChildNodes()
//          .size()) {
//        sentenceWithLongestWordInParagraph.setChildNodes(sentence.getChildNodes());
//        longestWordInParagraph.setChildNodes(longestWordInThisSentence.getChildNodes());
//      }
//    }
//
//
//    return sentenceWithLongestWordInParagraph;
//  }
//}

//public class SentenceWithLongestWordFromTextFinder extends AbstractUpdater {
//
//  @Override
//  public BaseTextStructure doSomething(BaseTextStructure textData) {
//
//    List<BaseTextStructure> paragraphs = textData.getChildNodes();
//    List<BaseTextStructure> sortedSentencesList = new ArrayList<>();
//
//    for (BaseTextStructure paragraph : paragraphs) {
//      BaseTextStructure sentenceWithLongestWord = nextDoSomething(paragraph);
//      sortedSentencesList.add(sentenceWithLongestWord);
//    }
//    BaseTextStructure sentenceWithLongestWord = nextDoSomething(
//        new TextStructureNode(sortedSentencesList));
//
//    return createTextWithSingleParagraphAndSentence(sentenceWithLongestWord);
//  }
//
//
//  private BaseTextStructure createTextWithSingleParagraphAndSentence(
//      BaseTextStructure sentenceWithLongestWord) {
//    List<BaseTextStructure> sentenceList = new ArrayList<>();
//    sentenceList.add(sentenceWithLongestWord);
//    BaseTextStructure paragraph = new TextStructureNode(sentenceList);
//    List<BaseTextStructure> paragraphList = new ArrayList<>();
//    paragraphList.add(paragraph);
//
//    return new TextStructureNode(paragraphList);
//  }
//}