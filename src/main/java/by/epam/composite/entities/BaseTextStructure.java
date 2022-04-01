package by.epam.composite.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseTextStructure {

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
}
