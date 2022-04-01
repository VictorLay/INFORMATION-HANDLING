package by.epam.composite.entities;

import java.util.List;

public class TextStructureNode extends BaseTextStructure {

  public TextStructureNode() {
  }

  public TextStructureNode(List<BaseTextStructure> childNodes) {
    super(childNodes);
  }

  public String readChildrenNodesAsString() {
    StringBuilder childrenToString = new StringBuilder();
    for (BaseTextStructure structure : getChildNodes()) {
      childrenToString.append(structure.toString());
    }
    return childrenToString.toString();
  }

  @Override
  public String toString() {

    if (getChildNodes().isEmpty()) {
      if (getNodeObject() != null) {
        return getNodeObject().toString();
      } else {
        return "";
      }
    } else {
      if (getNodeObject() != null) {

        return getNodeObject().toString() + "\n" + readChildrenNodesAsString();
      } else {
        return readChildrenNodesAsString();
      }
    }
  }
}
