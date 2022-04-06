package by.epam.responsibility_chain.update;

import by.epam.composite.entities.BaseTextStructure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LevelBelowLoader extends AbstractUpdater{

  @Override
  public BaseTextStructure doSomething(BaseTextStructure dataTxt) {

    for (BaseTextStructure chileNode : dataTxt.getChildNodes()){
      try {
        nextDoSomething(chileNode);
      } catch (Exception e) {
        Logger log = LogManager.getLogger();
        log.error("Achieve the last chain element");
        return dataTxt;
      }
    }
    return dataTxt;
  }
}
