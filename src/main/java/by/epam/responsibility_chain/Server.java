package by.epam.responsibility_chain;

import by.epam.composite.entities.BaseTextStructure;
import by.epam.responsibility_chain.create.*;
import by.epam.responsibility_chain.read.AbstractReader;
import by.epam.responsibility_chain.update.AbstractUpdater;


public class Server {

  private AbstractCreator abstractCreator;
  private AbstractUpdater abstractUpdater;
  private AbstractReader abstractReader;

  public AbstractCreator setAbstractCreator(AbstractCreator abstractCreator) {
    this.abstractCreator = abstractCreator;
    return this.abstractCreator;
  }

  public AbstractReader setAbstractReader(AbstractReader abstractReader) {
    this.abstractReader = abstractReader;
    return this.abstractReader;
  }

  public AbstractUpdater setAbstractWorker(AbstractUpdater abstractUpdater) {
    this.abstractUpdater = abstractUpdater;
    return this.abstractUpdater;
  }

  public BaseTextStructure useCreatorChain(String textData){
    return abstractCreator.doSomething(textData);
  }

  public BaseTextStructure useAbstractUpdater(BaseTextStructure structure){
    return abstractUpdater.doSomething(structure);
  }

  public String useReaderChain(BaseTextStructure textStructure){
    return abstractReader.doSomething(textStructure);
  }

  public void removeAll(){
    abstractReader = null;
    abstractCreator = null;
    abstractUpdater = null;
  }

}
