package by.epam.responsibility_chain.middleware;

import by.epam.composite.entities.BaseTextStructure;

public abstract class AbstractInstaller {

  /**
   * link for next chain element
   */
  private AbstractInstaller next;

  /**
   * Method set next chain element. It helps to construct chain.
   */
  public AbstractInstaller bindNextLink(AbstractInstaller nextMiddleware) {
    this.next = nextMiddleware;
    return nextMiddleware;
  }

  /**
   *
   * @return
   */
  public abstract BaseTextStructure doSomethingWithThisShit(String data);

  public BaseTextStructure nextDoSomething(String data) {
    if (next == null) {
      return null;// todo replace null to another value
    }
    return next.doSomethingWithThisShit(data);
  }
}
