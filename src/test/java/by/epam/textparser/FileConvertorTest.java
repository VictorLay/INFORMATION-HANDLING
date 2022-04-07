package by.epam.textparser;

import static org.junit.jupiter.api.Assertions.*;

import by.epam.composite.entities.BaseTextStructure;
import by.epam.responsibility_chain.Server;
import by.epam.responsibility_chain.read.AsLetterReader;
import by.epam.responsibility_chain.read.AsParagraphReader;
import by.epam.responsibility_chain.read.AsSentenceReader;
import by.epam.responsibility_chain.read.AsTextReader;
import by.epam.responsibility_chain.read.AsWordReader;
import java.io.File;
import org.junit.jupiter.api.Test;

class FileConvertorTest {

  File file = new File("src/main/resources/texts/Text2.txt");

  @Test
  void convert() {
    FileConvertor convertor = new FileConvertor();
    Server server = new Server();



    server.setAbstractReader(new AsTextReader()).bindNextLink(new AsParagraphReader())
        .bindNextLink(new AsSentenceReader()).bindNextLink(new AsWordReader())
        .bindNextLink(new AsLetterReader());

    BaseTextStructure textStructure = convertor.convert(file, true);
    String actualText = server.useReaderChain(textStructure) ;
    String exceptedText = "\n\tIt has survived - not only (five) centuries, but also the leap into "
        +(13<<2)+" electronic typesetting, remaining "+(3>>5)+" essentially "+(~6&9|(3&4))
        +" unchanged. It was popularised in the "+(5|(1&2&(3|(4&(1^5|6&47)|3)|(~89&4|(42&7)))|1))
        +" with the release of Letraset sheets containing Lorem Ipsum passages, and more recently "
        + "with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\s\n"
        + "\tIt is a long established fact that a reader will be distracted by the readable "
        + "content of a page when looking at its layout. The point of using "
        +((~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78)+" Ipsum is that it has a more-or-less normal "
        + "distribution of letters, as opposed to using (Content here), content here', making it "
        + "look like readable English.\s\n"
        + "\tIt is a " + (((7^5|1&2)<<((2|5)>>(2&71)))|1200) + " established fact that a reader will be "
        + "of a page when looking at its layout.\s\n"
        + "\tBye.\s";
    assertEquals(exceptedText, actualText);

  }
}