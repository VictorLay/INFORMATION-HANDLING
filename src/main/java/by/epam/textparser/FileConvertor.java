package by.epam.textparser;

import by.epam.composite.entities.BaseTextStructure;
import by.epam.interpreter.BitwiseExpressionCalculator;
import by.epam.responsibility_chain.Server;
import by.epam.responsibility_chain.create.LetterCreator;
import by.epam.responsibility_chain.create.ParagraphCreator;
import by.epam.responsibility_chain.create.SentenceCreator;
import by.epam.responsibility_chain.create.TextCreator;
import by.epam.responsibility_chain.create.WordCreator;
import java.io.File;

public class FileConvertor {

  public BaseTextStructure convert(File file, boolean useBitwiseCalculator) {
    String actualText;
    if (useBitwiseCalculator) {
      BitwiseExpressionCalculator calculator = new BitwiseExpressionCalculator();
      actualText = calculator.calculate(TextFileReader.readAllData(file));
    }else {
      actualText = TextFileReader.readAllData(file);
    }

    Server server = new Server();
    server.setAbstractCreator(new TextCreator()).bindNextLink(new ParagraphCreator())
        .bindNextLink(new SentenceCreator()).bindNextLink(new WordCreator())
        .bindNextLink(new LetterCreator());

    return server.useCreatorChain(actualText);
  }

}
