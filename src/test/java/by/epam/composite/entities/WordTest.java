package by.epam.composite.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

class WordTest {

  @Test
  void setLetterList() {
    Logger log = LogManager.getLogger();
    String userText = "electronic";

    Word word = new Word(userText);
    log.debug(word.sentText);
  }
}