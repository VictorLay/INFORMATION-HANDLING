package by.epam.responsibility_chain.read;

import by.epam.composite.entities.BaseTextStructure;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ParagraphsSorter extends AbstractReader {

  @Override
  public String doSomething(BaseTextStructure textStructure) {
    return textStructure.getChildNodes().stream().sorted(new NodeComparator())
        .map(this::nextDoSomething).collect(Collectors.joining());
  }

  private static final class NodeComparator implements Comparator<BaseTextStructure> {

    @Override
    public int compare(BaseTextStructure paragraph, BaseTextStructure otherParagraph) {
      return otherParagraph.getChildNodes().size() - paragraph.getChildNodes().size();
    }
  }
}


/*
 was left old variant
  @Override
  public String doSomething(BaseTextStructure dataTxt) {
    List<BaseTextStructure> paragraphs = dataTxt.getChildNodes();
    List<BaseTextStructure> sortedParagraphs = new ArrayList<>();
    sortedParagraphs.addAll(paragraphs);

    for (int i = 0; i < sortedParagraphs.size(); i++) {
      for (int j = sortedParagraphs.size() - 1; j > i; j--) {
        if (sortedParagraphs.get(i).getChildNodes().size() < sortedParagraphs.get(j).getChildNodes().size()) {
          BaseTextStructure tmp = sortedParagraphs.get(i);
          sortedParagraphs.set(i, dataTxt.getChildNodes().get(j));
          sortedParagraphs.set(j, tmp);
        }
      }
    }

    StringBuilder builder = new StringBuilder("Отсортировано по количеству childrenNodes элементов:");
    for (BaseTextStructure paragraph: sortedParagraphs){
      builder.append(nextDoSomething(paragraph));
    }


    return builder.toString();
  }
    */
