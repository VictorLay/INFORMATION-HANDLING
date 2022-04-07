package by.epam;

import by.epam.composite.entities.BaseTextStructure;
import by.epam.interpreter.BitwiseExpressionCalculator;
import by.epam.responsibility_chain.Server;
import by.epam.responsibility_chain.create.LetterCreator;
import by.epam.responsibility_chain.create.ParagraphCreator;
import by.epam.responsibility_chain.create.SentenceCreator;
import by.epam.responsibility_chain.create.TextCreator;
import by.epam.responsibility_chain.create.WordCreator;
import by.epam.responsibility_chain.read.AsLetterReader;
import by.epam.responsibility_chain.read.AsParagraphReader;
import by.epam.responsibility_chain.read.AsSentenceReader;
import by.epam.responsibility_chain.read.AsTextReader;
import by.epam.responsibility_chain.read.AsWordReader;
import by.epam.responsibility_chain.read.ConsonantLettersCounter;
import by.epam.responsibility_chain.read.LongestWordSentenceFinder;
import by.epam.responsibility_chain.read.ParagraphsSorter;
import by.epam.responsibility_chain.read.UniqueWordsCounter;
import by.epam.responsibility_chain.read.VowelsLettersCounter;
import by.epam.responsibility_chain.update.InvalidSentenceFromParagraphRemover;
import by.epam.responsibility_chain.update.LevelBelowLoader;
import by.epam.textparser.TextFileReader;
import java.io.File;

public class Service {

  public final Server server;

  public Service() {
    server = new Server();
  }

  public String sortParagraphsBySentencesQuantity(BaseTextStructure textStructure) {
    server.removeAll();
    server.setAbstractReader(new ParagraphsSorter()).bindNextLink(new AsParagraphReader())
        .bindNextLink(new AsSentenceReader()).bindNextLink(new AsWordReader())
        .bindNextLink(new AsLetterReader());

    return server.useReaderChain(textStructure);
  }

  public String findSentenceWithLongerWord(BaseTextStructure textStructure) {
    server.removeAll();
    server.setAbstractReader(new LongestWordSentenceFinder()).bindNextLink(new AsSentenceReader())
        .bindNextLink(new AsWordReader()).bindNextLink(new AsLetterReader());
    return server.useReaderChain(textStructure);
  }

  public BaseTextStructure convertTextStringToTextStructure(String text) {
    server.removeAll();
    server.setAbstractCreator(new TextCreator()).bindNextLink(new ParagraphCreator())
        .bindNextLink(new SentenceCreator()).bindNextLink(new WordCreator())
        .bindNextLink(new LetterCreator());

    return server.useCreatorChain(text);
  }

  public String readTextStructure(BaseTextStructure textStructure) {
    server.removeAll();
    server.setAbstractReader(new AsTextReader()).bindNextLink(new AsParagraphReader())
        .bindNextLink(new AsSentenceReader()).bindNextLink(new AsWordReader())
        .bindNextLink(new AsLetterReader());

    return server.useReaderChain(textStructure);
  }

  public String readFileAsText(File file) {
    //todo create validator for text and a class which would replace illegal strings
    BitwiseExpressionCalculator calculator = new BitwiseExpressionCalculator();
    return calculator.calculate(TextFileReader.readAllData(file));
  }

  public String readFileAsString(File file) {
    return TextFileReader.readAllData(file);
  }

  public BaseTextStructure deleteShortSentences(BaseTextStructure textStructure,
      int minWordQuantity) {
    server.removeAll();
    server.setAbstractUpdater(new LevelBelowLoader())
        .bindNextLink(new InvalidSentenceFromParagraphRemover(minWordQuantity));
    server.useAbstractUpdater(textStructure);
    return textStructure;
  }

  public String countSameWords(BaseTextStructure textStructure) {
    server.removeAll();
    server.setAbstractReader(new UniqueWordsCounter());
    return server.useReaderChain(textStructure);
  }

  public String countVowelAndConsonantLetter(BaseTextStructure textStructure) {
    server.removeAll();
    server.setAbstractReader(new VowelsLettersCounter());
    String vowels = server.useReaderChain(textStructure);
    server.setAbstractReader(new ConsonantLettersCounter());
    String consonants = server.useReaderChain(textStructure);
    return "Количество гласных букв: " + vowels + "\nКоличество согласных букв: " + consonants;
  }

}
