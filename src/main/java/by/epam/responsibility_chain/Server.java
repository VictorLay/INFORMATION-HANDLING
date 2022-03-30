package by.epam.responsibility_chain;

import by.epam.composite.entities.BaseTextStructure;
import by.epam.responsibility_chain.middleware.*;


public class Server {

  private AbstractInstaller abstractInstaller;

  public Server() {
  }

  public AbstractInstaller setAbstractInstaller(AbstractInstaller abstractInstaller) {
    this.abstractInstaller = abstractInstaller;
    return this.abstractInstaller;
  }

  public BaseTextStructure convertToTree(String textData){
    return abstractInstaller.doSomethingWithThisShit(textData);
  }


}
