package by.epam.responsibility_chain.workchain;

import by.epam.composite.entities.BaseTextStructure;
import by.epam.composite.entities.TextStructureNode;

public class MostChildrenQuantityFinder extends AbstractUpdater {

  /**
   * Method get node of BaseTextStructure and find child-node with the most quantity of children.
   * @return child of dataTxt which have children more that the others.
   */
  @Override
  public BaseTextStructure doSomething(BaseTextStructure dataTxt) {

    BaseTextStructure nodeWithHighestQuantityOfChildNodes = new TextStructureNode();

    for (BaseTextStructure childNode : dataTxt.getChildNodes()) {
      if (childNode.getChildNodes().size() > nodeWithHighestQuantityOfChildNodes.getChildNodes().size()) {
        nodeWithHighestQuantityOfChildNodes.setChildNodes(childNode.getChildNodes());
      }
    }

    return nodeWithHighestQuantityOfChildNodes;
  }
}
