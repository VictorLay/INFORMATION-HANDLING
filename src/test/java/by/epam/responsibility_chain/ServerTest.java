package by.epam.responsibility_chain;

import static org.junit.jupiter.api.Assertions.*;

import by.epam.composite.entities.BaseTextStructure;
import by.epam.responsibility_chain.middleware.LetterInstaller;
import by.epam.responsibility_chain.middleware.ParagraphInstaller;
import by.epam.responsibility_chain.middleware.SentenceInstaller;
import by.epam.responsibility_chain.middleware.TextInstaller;
import by.epam.responsibility_chain.middleware.WordInstaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

class ServerTest {
  String userText = "\tIt has survived - not only (five) centuries, but also the leap into electronic\n"
      + "typesetting, remaining essentially unchanged. It was popularised in the “Динамо” (Рига)\n"
      + "with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and\n"
      + "more recently with desktop publishing software like Aldus PageMaker Faclon9 including\n"
      + "versions of Lorem Ipsum!\n"
      + "\tIt is a long a!=b established fact that a reader will be distracted by the readable\n"
      + "content of a page when looking at its layout. The point of using Ipsum is that it has a\n"
      + "more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here),\n"
      + "content here's, making it look like readable English?\n"
      + "\tIt is a established fact that a reader will be of a page when looking at its layout...\n"
      + "\tBye бандерлоги.\n";

  @Test
  void convertToTree() {
    Server server = new Server();
    server.setAbstractInstaller(new TextInstaller())
        .bindNextLink(new ParagraphInstaller())
        .bindNextLink(new SentenceInstaller())
        .bindNextLink(new WordInstaller())
        .bindNextLink(new LetterInstaller());

    BaseTextStructure textStructure = server.convertToTree(userText);
    Logger log = LogManager.getLogger();
    log.debug(textStructure);
  }
}