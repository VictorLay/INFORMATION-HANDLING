package by.epam.textparser;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import org.junit.jupiter.api.Test;

class TextFileReaderTest {

  File file = new File("src/main/resources/texts/Text1.txt");

  @Test
  void readAllData() {
    String actual = TextFileReader.readAllData(file);
    String expected =
        "\tIt is a long a!=b established fact that a reader will be distracted by the readable "
            + "content of a page when looking at its layout. The point of using Ipsum is that it"
            + " has a more-or-less normal distribution ob.toString(a?b:c), as opposed to using "
            + "(Content here), content here's, making it look like readable English? Так погибают "
            + "замыслы с размахом! \r\n"
            + "\tIt has survived - not only (five) centuries, but also the leap into electronic "
            + "typesetting, remaining essentially unchanged. It was popularised in the “Динамо” "
            + "(Рига) with the release of Letraset sheets.toString() containing Lorem Ipsum "
            + "passages, and more recently with desktop publishing software like Aldus PageMaker "
            + "Faclon9 including versions of Lorem Ipsum! \r\n"
            + "\tIt is a established fact that a reader will be of a page when looking at its "
            + "layout... \r\n"
            + "\tBye бандерлоги. ";

    assertEquals(expected, actual);
  }
}