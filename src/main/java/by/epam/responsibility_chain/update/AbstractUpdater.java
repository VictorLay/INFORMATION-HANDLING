package by.epam.responsibility_chain.update;

import by.epam.composite.entities.BaseTextStructure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractUpdater {

  private AbstractUpdater next;

  public AbstractUpdater bindNextLink(AbstractUpdater next) {
    this.next = next;
    return next;
  }

  public abstract BaseTextStructure doSomething(BaseTextStructure dataTxt);

  public BaseTextStructure nextDoSomething(BaseTextStructure dataTxt) {
    if (next == null) {
      Logger log = LogManager.getLogger();
      log.error("The error is possible. The method 'nextDoSomething' return the null value");
      return null;
      // todo replace null to another value
    }
    return next.doSomething(dataTxt);
  }
}
