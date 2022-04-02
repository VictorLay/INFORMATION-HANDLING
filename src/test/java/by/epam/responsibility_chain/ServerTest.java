package by.epam.responsibility_chain;

import static org.junit.jupiter.api.Assertions.*;

import by.epam.composite.entities.BaseTextStructure;
import by.epam.responsibility_chain.create.LetterCreator;
import by.epam.responsibility_chain.create.ParagraphCreator;
import by.epam.responsibility_chain.create.SentenceCreator;
import by.epam.responsibility_chain.create.TextCreator;
import by.epam.responsibility_chain.create.WordCreator;
import by.epam.responsibility_chain.strchain.AsLetterReader;
import by.epam.responsibility_chain.strchain.AsParagraphReader;
import by.epam.responsibility_chain.strchain.AsSentenceReader;
import by.epam.responsibility_chain.strchain.AsTextReader;
import by.epam.responsibility_chain.strchain.AsWordReader;
import by.epam.responsibility_chain.workchain.GetAccessor;
import by.epam.responsibility_chain.workchain.Visualization;
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
          + "\tIt is a established fact that a reader will be of a page when looking at its layout... \n"
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
    String[] excessStrings = {"\s","\t","\n"};
    String expectedToSting = CustomTextTools.clearTheChars(simpleParagraph, excessStrings);
    simpleParagraph.replace("\s", "")
        .replace("\t", "").replace("\n", "");
    String actualToString = wordStructure.toString();

    assertEquals(expectedToSting, actualToString);
  }

  @Test
  void convertTextToCompositeTreeStructureAndTryToReadIt() {
    Server server = new Server();
    server.setAbstractCreator(new TextCreator()).bindNextLink(new ParagraphCreator())
        .bindNextLink(new SentenceCreator()).bindNextLink(new WordCreator())
        .bindNextLink(new LetterCreator());
    server.setAbstractReceiver(new AsTextReader()).bindNextLink(new AsParagraphReader())
        .bindNextLink(new AsSentenceReader()).bindNextLink(new AsWordReader())
        .bindNextLink(new AsLetterReader());

    BaseTextStructure textStructure = server.useCreatorChain(simpleText);
    String exceptedText = "\n"+simpleText;
    String actualText = server.useReaderChain(textStructure) + "\n";

    assertEquals(exceptedText, actualText);
  }

  @Test
  void convertToTreeAndGetAccessToBranchesOfParagraphs() {
    Server server = new Server();
    server.setAbstractCreator(new TextCreator()).bindNextLink(new ParagraphCreator())
        .bindNextLink(new SentenceCreator()).bindNextLink(new WordCreator())
        .bindNextLink(new LetterCreator());

    server.setAbstractWorker(new GetAccessor()).bindNextLink(new Visualization());

    BaseTextStructure textStructure = server.useCreatorChain(simpleText);
    server.chainAccessTestMethod(textStructure);
    //this test show log. Check logger.


//    Logger log = LogManager.getLogger();
//    log.debug("\n" + textStructure);
  }


}