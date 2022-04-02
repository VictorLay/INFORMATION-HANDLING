package by.epam.responsibility_chain;

import by.epam.composite.entities.BaseTextStructure;
import by.epam.responsibility_chain.create.*;
import by.epam.responsibility_chain.strchain.AbstractReader;
import by.epam.responsibility_chain.workchain.AbstractWorker;


public class Server {

  private AbstractCreator abstractCreator;
  private AbstractWorker abstractWorker;
  private AbstractReader abstractReader;

  public AbstractCreator setAbstractCreator(AbstractCreator abstractCreator) {
    this.abstractCreator = abstractCreator;
    return this.abstractCreator;
  }

  public AbstractReader setAbstractReceiver(AbstractReader abstractReader) {
    this.abstractReader = abstractReader;
    return this.abstractReader;
  }

  public AbstractWorker setAbstractWorker(AbstractWorker abstractWorker) {
    this.abstractWorker = abstractWorker;
    return this.abstractWorker;
  }

  public BaseTextStructure useCreatorChain(String textData){
    return abstractCreator.doSomething(textData);
  }

  public BaseTextStructure chainAccessTestMethod(BaseTextStructure structure){
    return abstractWorker.doSomething(structure);
  }

  public String useReaderChain(BaseTextStructure textStructure){
    return abstractReader.doSomething(textStructure);
  }

}
