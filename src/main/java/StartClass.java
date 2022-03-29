import by.epam.composite.entities.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StartClass {

  public static void main(String[] args) {
    Logger log = LogManager.getLogger(StartClass.class);
    log.info("Запуск программы по разделению текста на параграфы! 3.. 2.. 1...");
    String userText = "\tFirst paragraph with some words! Second sentence of first paragraph.\n"
        + "\tSecond paragraph with some words...Second sentence of second paragraph."+
         "\t By by.";


    Text text = new Text(userText);
    log.debug(text.getInstance());






  }
}
