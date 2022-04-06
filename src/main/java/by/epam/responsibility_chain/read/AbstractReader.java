package by.epam.responsibility_chain.read;

import by.epam.composite.entities.BaseTextStructure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractReader {

  private AbstractReader next;

  public AbstractReader bindNextLink(AbstractReader next) {
    this.next = next;
    return next;
  }

  public abstract String doSomething(BaseTextStructure textStructure);

  public String nextDoSomething(BaseTextStructure textStructure) {
    if (next == null) {
      Logger log = LogManager.getLogger();
      log.error("The error is possible. The method 'nextDoSomething' return the empty value");
      return "";
    }
    return next.doSomething(textStructure);
  }
}