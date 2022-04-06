package by.epam.composite.entities;

import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public abstract class BaseTextStructure implements Comparable<BaseTextStructure> {

  private BaseTextStructure fatherNode;
  private List<BaseTextStructure> childNodes;
  private Object nodeObject;

  public BaseTextStructure getFatherNode() {
    return fatherNode;
  }

  public void setFatherNode(BaseTextStructure fatherNode) {
    this.fatherNode = fatherNode;
  }

  public Object getNodeObject() {
    return nodeObject;
  }

  public void setNodeObject(Object nodeObject) {
    this.nodeObject = nodeObject;
  }


  protected BaseTextStructure() {
    childNodes = new ArrayList<>();
  }

  protected BaseTextStructure(List<BaseTextStructure> childNodes) {
    this.childNodes = childNodes;
  }

  public List<BaseTextStructure> getChildNodes() {
    return childNodes;
  }

  public void setChildNodes(List<BaseTextStructure> childNodes) {
    this.childNodes = childNodes;
  }

  @Override
  public int compareTo(@NotNull BaseTextStructure otherStructure) {
    return this.childNodes.size() - otherStructure.childNodes.size();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    BaseTextStructure other = (BaseTextStructure) obj;
    return childNodes == other.getChildNodes() && fatherNode == other.getFatherNode()
        && nodeObject == other.getNodeObject();
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }
}
