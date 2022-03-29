package by.epam.composite.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

class SentenceTest {

  @Test
  void setWordList() {
    String userText =
        "It has survived - not only (five) centuries, but also the leap into electronic sheets.toString() "
        + "typesetting, remaining essentially unchanged.";

    Sentence sentence = new Sentence(userText);
    Logger log = LogManager.getLogger();
    log.debug(sentence.sentText);
    String expectedText = """
        It
        has
        survived
        -
        not
        only
        (five)
        centuries,
        but
        also
        the
        leap
        into
        electronic
        sheets.toString()
        typesetting,
        remaining
        essentially
        unchanged.
        """;
    assertEquals(expectedText,sentence.sentText);

  }
}