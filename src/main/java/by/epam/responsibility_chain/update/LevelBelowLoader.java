package by.epam.responsibility_chain.update;

import by.epam.composite.entities.BaseTextStructure;

public class LevelBelowLoader extends AbstractUpdater{

  @Override
  public BaseTextStructure doSomething(BaseTextStructure dataTxt) {

    for (BaseTextStructure chileNode : dataTxt.getChildNodes()){
      nextDoSomething(chileNode);
    }
    return dataTxt;
  }
}
