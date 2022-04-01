package by.epam.responsibility_chain.strchain;

import by.epam.composite.entities.BaseTextStructure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractReader {

  private AbstractReader next;

  public AbstractReader bindNextLink(AbstractReader next) {
    this.next = next;
    return next;
  }

  public abstract String doSomething(BaseTextStructure data);

  public String nextDoSomething(BaseTextStructure data) {
    if (next == null) {
      Logger log = LogManager.getLogger();
      log.error("The error is possible. The method 'nextDoSomething' return the empty value");
      return "";
    }
    return next.doSomething(data);
  }
}