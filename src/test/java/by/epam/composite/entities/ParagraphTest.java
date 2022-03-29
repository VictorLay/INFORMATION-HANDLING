package by.epam.composite.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

class ParagraphTest {

  @Test
  void setSentenceList() {
    String userText =
        "It has survived - not only (five) centuries, but also the leap into electronic "
            + "typesetting, remaining essentially unchanged. It was popularised in the “Динамо” (Рига) "
            + "with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and "
            + "more recently with desktop publishing software like Aldus PageMaker Faclon9 including "
            + "versions of Lorem Ipsum!";
    Paragraph paragraph = new Paragraph(userText);
    Logger log = LogManager.getLogger();
    log.debug(paragraph.sentText);
    String expectedText =
        "It has survived - not only (five) centuries, but also the leap into electronic "
            + "typesetting, remaining essentially unchanged.\n"
            + "It was popularised in the “Динамо” (Рига) "
            + "with the release of Letraset sheets."
            + "toString() containing Lorem Ipsum passages, and "
            + "more recently with desktop publishing software like Aldus PageMaker Faclon9 including "
            + "versions of Lorem Ipsum!\n";
    assertEquals(expectedText, paragraph.sentText);
  }
}