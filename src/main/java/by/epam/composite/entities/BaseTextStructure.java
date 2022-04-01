package by.epam.composite.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseTextStructure {

  private List<BaseTextStructure> childNodes;

  public BaseTextStructure() {
    childNodes = new ArrayList<>();
  }

  public List<BaseTextStructure> getChildNodes() {
    return childNodes;
  }

  public void setChildNodes(List<BaseTextStructure> childNodes) {
    this.childNodes = childNodes;
  }
//todo replace the initialization at father class BaseStructure
}
