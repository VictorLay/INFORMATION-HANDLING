package by.epam.responsibility_chain;

import static org.junit.jupiter.api.Assertions.*;

import by.epam.composite.entities.BaseTextStructure;
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
import by.epam.tools.CustomTextTools;
import org.junit.jupiter.api.Test;

class ServerTest {

  String simpleText =
      "\tIt has survived - not only (five) centuries, but also the leap into electronic "
          + "typesetting, remaining essentially unchanged. It was popularised in the “Динамо” (Рига) "
          + "with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and "
          + "more recently with desktop publishing software like Aldus PageMaker Faclon9 including "
          + "versions of Lorem Ipsum! \n"
          + "\tIt is a long a!=b established fact that a reader will be distracted by the readable "
          + "content of a page when looking at its layout. The point of using Ipsum is that it has a "
          + "more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), "
          + "content here's, making it look like readable English? Так погибают замыслы с размахом! \n"
          + "\tIt is a established fact that a СамоеДлинноеСловоВТексте reader will be of a page when looking at its layout... \n"
          + "\tBye бандерлоги. \n";
  String simpleParagraph = "\tFirst paragraph and first sentence. First paragraph and second sentence.\n";
  String simpleSentence = "First paragraph and first sentence.";
  String simpleWord = "First";

  @Test
  void convertWordToCompositeBaseTextStructure() {
    Server server = new Server();
    server.setAbstractCreator(new WordCreator()).bindNextLink(new LetterCreator());

    BaseTextStructure wordStructure = server.useCreatorChain(simpleWord);
    String expectedToSting = simpleWord;
    String actualToString = wordStructure.toString();

    assertEquals(expectedToSting, actualToString);
  }

  @Test
  void convertSentenceToCompositeBaseTextStructure() {
    Server server = new Server();
    server.setAbstractCreator(new SentenceCreator()).bindNextLink(new WordCreator())
        .bindNextLink(new LetterCreator());

    BaseTextStructure wordStructure = server.useCreatorChain(simpleSentence);
    String expectedToSting = simpleSentence.replace("\s", "");
    String actualToString = wordStructure.toString();

    assertEquals(expectedToSting, actualToString);
  }

  @Test
  void convertParagraphToCompositeBaseTextStructure() {
    Server server = new Server();
    server.setAbstractCreator(new TextCreator()).bindNextLink(new SentenceCreator())
        .bindNextLink(new WordCreator()).bindNextLink(new LetterCreator());

    BaseTextStructure wordStructure = server.useCreatorChain(simpleParagraph);
    String[] excessStrings = {"\s", "\t", "\n"};
    String expectedToSting = CustomTextTools.clearTheChars(simpleParagraph, excessStrings);
    simpleParagraph.replace("\s", "").replace("\t", "").replace("\n", "");
    String actualToString = wordStructure.toString();

    assertEquals(expectedToSting, actualToString);
  }

  @Test
  void convertTextToCompositeTreeStructureAndTryToReadIt() {
    Server server = new Server();
    server.setAbstractCreator(new TextCreator()).bindNextLink(new ParagraphCreator())
        .bindNextLink(new SentenceCreator()).bindNextLink(new WordCreator())
        .bindNextLink(new LetterCreator());
    server.setAbstractReader(new AsTextReader()).bindNextLink(new AsParagraphReader())
        .bindNextLink(new AsSentenceReader()).bindNextLink(new AsWordReader())
        .bindNextLink(new AsLetterReader());

    BaseTextStructure textStructure = server.useCreatorChain(simpleText);
    String exceptedText = "\n" + simpleText;
    String actualText = server.useReaderChain(textStructure) + "\n";

    assertEquals(exceptedText, actualText);
  }

  @Test
  void convertTextToStructureNextToTextNextToStructureNextToTextAndTryToReadIt() {
    Server server = new Server();
    server.setAbstractCreator(new TextCreator()).bindNextLink(new ParagraphCreator())
        .bindNextLink(new SentenceCreator()).bindNextLink(new WordCreator())
        .bindNextLink(new LetterCreator());
    server.setAbstractReader(new AsTextReader()).bindNextLink(new AsParagraphReader())
        .bindNextLink(new AsSentenceReader()).bindNextLink(new AsWordReader())
        .bindNextLink(new AsLetterReader());

    BaseTextStructure textStructure = server.useCreatorChain(simpleText);
    String exceptedText = "\n" + simpleText;
    String actualText =
        server.useReaderChain(server.useCreatorChain(server.useReaderChain(textStructure))) + "\n";

    assertEquals(exceptedText, actualText);
  }

  @Test
  void convertToTreeReturnStringWithSortedParagraphsBySentencesQuantity() {
    Server server = new Server();
    server.setAbstractCreator(new TextCreator()).bindNextLink(new ParagraphCreator())
        .bindNextLink(new SentenceCreator()).bindNextLink(new WordCreator())
        .bindNextLink(new LetterCreator());

    server.setAbstractReader(new ParagraphsSorter())
        .bindNextLink(new AsParagraphReader()).bindNextLink(new AsSentenceReader())
        .bindNextLink(new AsWordReader()).bindNextLink(new AsLetterReader());

    BaseTextStructure textStructure = server.useCreatorChain(simpleText);
    String actual = server.useReaderChain(textStructure);
    String expected =
//        "Отсортировано по количеству childrenNodes элементов:\n"        +
        "\n\tIt is a long a!=b established fact that a reader will be distracted by the readable "
            + "content of a page when looking at its layout. The point of using Ipsum is that it has a "
            + "more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), "
            + "content here's, making it look like readable English? Так погибают замыслы с размахом! "
            + "\n\tIt has survived - not only (five) centuries, but also the leap into electronic "
            + "typesetting, remaining essentially unchanged. It was popularised in the “Динамо” (Рига) "
            + "with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and "
            + "more recently with desktop publishing software like Aldus PageMaker Faclon9 including "
            + "versions of Lorem Ipsum! "
            + "\n\tIt is a established fact that a СамоеДлинноеСловоВТексте reader will be of a page when looking at its layout... "
            + "\n\tBye бандерлоги.\s";
    assertEquals(expected, actual);
    server = new Server();
    server.setAbstractReader(new AsTextReader()).bindNextLink(new AsParagraphReader())
        .bindNextLink(new AsSentenceReader()).bindNextLink(new AsWordReader())
        .bindNextLink(new AsLetterReader());
    String exceptedText = "\n" + simpleText;
    String actualText = server.useReaderChain(textStructure) + "\n";
    assertEquals(exceptedText, actualText);
  }


  @Test
  void tryToDeleteInvalidSentence() {
    Server server = new Server();
    server.setAbstractCreator(new TextCreator()).bindNextLink(new ParagraphCreator())
        .bindNextLink(new SentenceCreator()).bindNextLink(new WordCreator())
        .bindNextLink(new LetterCreator());
    server.setAbstractReader(new AsTextReader()).bindNextLink(new AsParagraphReader())
        .bindNextLink(new AsSentenceReader()).bindNextLink(new AsWordReader())
        .bindNextLink(new AsLetterReader());
    server.setAbstractUpdater(new LevelBelowLoader())
        .bindNextLink(new InvalidSentenceFromParagraphRemover(5));

    BaseTextStructure textStructure = server.useCreatorChain(simpleText);
    server.useAbstractUpdater(textStructure);
    String exceptedText =
        "\n\tIt has survived - not only (five) centuries, but also the leap into electronic "
            + "typesetting, remaining essentially unchanged. It was popularised in the “Динамо” (Рига) "
            + "with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and "
            + "more recently with desktop publishing software like Aldus PageMaker Faclon9 including "
            + "versions of Lorem Ipsum! \n"
            + "\tIt is a long a!=b established fact that a reader will be distracted by the readable "
            + "content of a page when looking at its layout. The point of using Ipsum is that it has a "
            + "more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), "
            + "content here's, making it look like readable English? Так погибают замыслы с размахом! \n"
            + "\tIt is a established fact that a СамоеДлинноеСловоВТексте reader will be of a page when looking at its layout... \n";
    String actualText = server.useReaderChain(textStructure) + "\n";

    assertEquals(exceptedText, actualText);
  }

  @Test
  void findQuantityOfUniqueWords() {
    Server server = new Server();
    server.setAbstractCreator(new TextCreator()).bindNextLink(new ParagraphCreator())
        .bindNextLink(new SentenceCreator()).bindNextLink(new WordCreator())
        .bindNextLink(new LetterCreator());
    server.setAbstractReader(new UniqueWordsCounter());

    String simpleText =
        "\n\tWord1 word1 word1 word2 word2 word3 word3 word4 word4 word5 word6 word7 word7 "
            + "word7 word7 word7 word8 word8 word8 word8 word8 word9 word9 word10 \n";
    BaseTextStructure textStructure = server.useCreatorChain(simpleText);
    String actualText = server.useReaderChain(textStructure);
    String exceptedText =
        "{word1:3}\s{word2:2}\s{word3:2}\s{word4:2}\s{word5:1}\s{word6:1}\s{word7:5}\s"
            + "{word8:5}\s{word9:2}\s{word10:1}\s";

    assertEquals(exceptedText, actualText);
  }

  @Test
  void countQuantityOfVowelLetters() {
    Server server = new Server();
    server.setAbstractCreator(new TextCreator()).bindNextLink(new ParagraphCreator())
        .bindNextLink(new SentenceCreator()).bindNextLink(new WordCreator())
        .bindNextLink(new LetterCreator());
    server.setAbstractReader(new VowelsLettersCounter());

    String simpleText =
        "\n\tWord1 word1 word1 word2 word2 word3 word3 word4 word4 word5 word6 word7 word7 "
            + "word7 word7 word7 word8 word8 word8 word8 word8 word9 word9 word10 \n";
    BaseTextStructure textStructure = server.useCreatorChain(simpleText);
    String actualText = server.useReaderChain(textStructure);
    String exceptedText =
        "24";

    assertEquals(exceptedText, actualText);
  }

  @Test
  void countQuantityOfConsonantLetters() {
    Server server = new Server();
    server.setAbstractCreator(new TextCreator()).bindNextLink(new ParagraphCreator())
        .bindNextLink(new SentenceCreator()).bindNextLink(new WordCreator())
        .bindNextLink(new LetterCreator());
    server.setAbstractReader(new ConsonantLettersCounter());

    String simpleText =
        "\n\tWord1 word1 word1 word2 word2 word3 word3 word4 word4 word5 word6 word7 word7 "
            + "word7 word7 word7 word8 word8 word8 word8 word8 word9 word9 word10 \n";
    BaseTextStructure textStructure = server.useCreatorChain(simpleText);
    String actualText = server.useReaderChain(textStructure);
    String exceptedText =
        "72";

    assertEquals(exceptedText, actualText);
  }

  @Test
  void findSentenceWithLongerWord() {
    Server server = new Server();
    server.setAbstractCreator(new TextCreator()).bindNextLink(new ParagraphCreator())
        .bindNextLink(new SentenceCreator()).bindNextLink(new WordCreator())
        .bindNextLink(new LetterCreator());
    server.setAbstractReader(new LongestWordSentenceFinder()).bindNextLink(new AsSentenceReader())
        .bindNextLink(new AsWordReader())
        .bindNextLink(new AsLetterReader());

    String simpleText =
        "\n\tWord1 word1 word1 word2 word2 word3 word3 word4 word4 word5 word6 word7 word7 "
            + "word7 word7 word7 word8 word8 word8 word8 word8. word9 word9 word10. \n";
    BaseTextStructure textStructure = server.useCreatorChain(simpleText);
    String actualText = server.useReaderChain(textStructure);
    String exceptedText =
        "word9 word9 word10. ";

    assertEquals(exceptedText, actualText);
  }

}