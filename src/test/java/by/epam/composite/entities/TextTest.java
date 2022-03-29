package by.epam.composite.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

class TextTest {

  @Test
  void setText() {
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
    Text text = new Text();
    text.setText(userText);

    String expectedText = "\tIt has survived - not only (five) centuries, but also the leap into electronic\n"
        + "typesetting, remaining essentially unchanged. It was popularised in the “Динамо” (Рига)\n"
        + "with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and\n"
        + "more recently with desktop publishing software like Aldus PageMaker Faclon9 including\n"
        + "versions of Lorem Ipsum!\s\n"
        + "\tIt is a long a!=b established fact that a reader will be distracted by the readable\n"
        + "content of a page when looking at its layout. The point of using Ipsum is that it has a\n"
        + "more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here),\n"
        + "content here's, making it look like readable English?\s\n"
        + "\tIt is a established fact that a reader will be of a page when looking at its layout...\s\n"
        + "\tBye бандерлоги.\s\n";
    Logger log = LogManager.getLogger();
    log.debug(text.sentText);
    assertEquals(expectedText,text.getInstance());

//    text.getParagraphList();


  }
}