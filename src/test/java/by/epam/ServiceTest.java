package by.epam;

import static org.junit.jupiter.api.Assertions.assertEquals;

import by.epam.composite.entities.BaseTextStructure;
import by.epam.textparser.FileConvertor;
import by.epam.textparser.TextFileReader;
import java.io.File;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

class ServiceTest {

  Logger log = LogManager.getLogger();
  Service service = new Service();
  File simpleTextTestFile = new File("src/main/resources/service.test.files/SimpleText");
  File optionalTestFile = new File("src/main/resources/service.test.files/Optional");

  String sortParagraphExpected =
      "\n\tSecond paragraph. It have four sentences. This paragraph is the largest in this text. "
          + "Believe me! "
          + "\n\tThird paragraph. More than first but less than second. It has three sentences... "
          + "\n\tFirst paragraph. This paragraph has two sentences and has "
          + "Floccinaucinihilipilification by sentences Quantity. ";
  String findSentenceExpected = "This paragraph has two sentences and has "
      + "Floccinaucinihilipilification by sentences Quantity. ";
  String readTextStructureExpected =
      "" + "\n\tFirst paragraph. This paragraph has two sentences and has "
          + "Floccinaucinihilipilification by sentences Quantity. "
          + "\n\tSecond paragraph. It have four sentences. This paragraph is the largest in "
          + "this text. Believe me! "
          + "\n\tThird paragraph. More than first but less than second. It has three sentences... ";

  String readFileAsTextExpected =
      "\n" + "\tIt has survived - not only (five) centuries, but also the leap into " + (13 << 2)
          + " electronic typesetting, remaining " + (3 >> 5) + " essentially " + (~6 & 9 | (3 & 4))
          + " unchanged. It was popularised in the " + (5 | (
          1 & 2 & (3 | (4 & (1 ^ 5 | 6 & 47) | 3) | (~89 & 4 | (42 & 7))) | 1))
          + " with the release of Letraset sheets containing Lorem Ipsum passages, and more "
          + "recently with desktop publishing software like Aldus PageMaker including versions"
          + " of Lorem Ipsum.\n"
          + "\tIt is a long established fact that a reader will be distracted by the readable"
          + " content of a page when looking at its layout. The point of using " + (
          (~71 & (2 & 3 | (3 | (2 & 1 >> 2 | 2) & 2) | 10 & 2)) | 78)
          + " Ipsum is that it has a more-or-less normal distribution of letters, as opposed to "
          + "using (Content here), content here', making it look like readable English.\n"
          + "\tIt is a " + (((7 ^ 5 | 1 & 2) << ((2 | 5) >> (2 & 71))) | 1200)
          + " established fact that a reader will be of a page when looking at its layout.\n"
          + "\tBye.";

  String readFileAsStringExpected =
      "\n\tIt has survived - not only (five) centuries, but also the leap into (13<<2) electronic"
          + " typesetting, remaining (3>>5) essentially (~6&9|(3&4)) unchanged. It was popularised"
          + " in the (5|(1&2&(3|(4&(1^5|6&47)|3)|(~89&4|(42&7)))|1)) with the release of Letraset"
          + " sheets containing Lorem Ipsum passages, and more recently with desktop publishing"
          + " software like Aldus PageMaker including versions of Lorem Ipsum.\n"
          + "\tIt is a long established fact that a reader will be distracted by the readable"
          + " content of a page when looking at its layout. The point of using"
          + " ((~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78) Ipsum is that it has a more-or-less normal"
          + " distribution of letters, as opposed to using (Content here), content here', making"
          + " it look like readable English.\n"
          + "\tIt is a (((7^5|1&2)<<((2|5)>>(2&71)))|1200) established fact that a reader will"
          + " be of a page when looking at its layout.\n" + "\tBye.";

  String deleteShortSentencesExpected =
      "\n" + "\tThis paragraph has two sentences and has Floccinaucinihilipilification by sentences"
          + " Quantity. \n" + "\tThis paragraph is the largest in this text. \n"
          + "\tMore than first but less than second. ";


  @Test
  void sortParagraphBySentenceQuantity() {
    String actual = service.sortParagraphsBySentencesQuantity(
        createTextStructure(simpleTextTestFile, false));
    String expected = sortParagraphExpected;
    log.info("sortParagraphBySentenceQuantity:\n" + actual);

    assertEquals(expected, actual);
  }

  @Test
  void findSentenceWithLongerWord() {
    String actual = service.findSentenceWithLongerWord(
        createTextStructure(simpleTextTestFile, false));
    String expected = findSentenceExpected;
    log.info("findSentenceWithLongerWord:\n" + actual);

    assertEquals(expected, actual);
  }

  @Test
  void convertTextStringToTextStructure() {
    BaseTextStructure actualTextStructure = service.convertTextStringToTextStructure(
        TextFileReader.readAllData(simpleTextTestFile));
    String actual = service.readTextStructure(actualTextStructure);
    log.info("convertTextStringToTextStructure:\n" + actual);
  }

  @Test
  void readTextStructure() {
    String actual = service.readTextStructure(createTextStructure(simpleTextTestFile, false));
    String expected = readTextStructureExpected;
    log.info("readTextStructure:\n" + actual);
    assertEquals(expected, actual);
  }

  @Test
  void readFileAsText() {
    String actual = service.readFileAsText(optionalTestFile);
    String expected = readFileAsTextExpected;
    log.info("readFileAsText:\n" + actual);

    assertEquals(expected, actual);
  }

  @Test
  void readFileAsString() {
    String actual = service.readFileAsString(optionalTestFile);
    String expected = readFileAsStringExpected;
    log.info("readFileAsString:\n" + actual);

    assertEquals(expected, actual);
  }

  @Test
  void deleteShortSentences() {
    BaseTextStructure updated = service.deleteShortSentences(
        createTextStructure(simpleTextTestFile, false), 5);
    String actual = service.readTextStructure(updated);
    String expected = deleteShortSentencesExpected;
    log.info("deleteShortSentences:\n" + actual);

    assertEquals(expected, actual);
  }

  @Test
  void countSameWords() {
    String actual = service.countSameWords(createTextStructure(simpleTextTestFile, false));
    log.info("countSameWords:\n" + actual);
  }

  @Test
  void countVowelAndConsonantLetter() {
    String actual = service.countVowelAndConsonantLetter(
        createTextStructure(simpleTextTestFile, false));
    log.info("countVowelAndConsonantLetter:\n" + actual);
  }

  private BaseTextStructure createTextStructure(File file, boolean hasExpression) {
    FileConvertor convertor = new FileConvertor();
    return convertor.convert(file, hasExpression);
  }

}