import by.epam.composite.entities.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StartClass {

  public static void main(String[] args) {
    Logger log = LogManager.getLogger(StartClass.class);
    log.info("Запуск программы по разделению текста на параграфы! 3.. 2.. 1...");
    Text text = new Text();
    text.setText("\tFirst \n \tSecond paragraph and some words \n  and some more words.");

  }
}
