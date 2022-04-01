package by.epam.responsibility_chain.create;

import by.epam.composite.entities.BaseTextStructure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractCreator {

  private AbstractCreator next;

  public AbstractCreator bindNextLink(AbstractCreator nextMiddleware) {
    this.next = nextMiddleware;
    return nextMiddleware;
  }

  public abstract BaseTextStructure doSomething(String data);

  public BaseTextStructure nextDoSomething(String data) {
    if (next == null) {
      Logger log = LogManager.getLogger();
      log.error("The error is possible. The method 'nextDoSomething' return the null value");
      return null;
    }
    return next.doSomething(data);
  }
}
