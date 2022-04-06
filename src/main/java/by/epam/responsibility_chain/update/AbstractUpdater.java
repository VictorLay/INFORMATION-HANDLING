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

  public abstract BaseTextStructure doSomething(BaseTextStructure textStructure);

  public BaseTextStructure nextDoSomething(BaseTextStructure textStructure) throws Exception {
    if (next == null) {
      Logger log = LogManager.getLogger();
      log.error("The error is possible. The method 'nextDoSomething' return the null value");
      throw new Exception("Attempt to calling unidentified next-chain-element");
    }
    return next.doSomething(textStructure);
  }
}
