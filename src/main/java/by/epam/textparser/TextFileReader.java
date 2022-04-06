package by.epam.textparser;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextFileReader {
  private static final Logger logger = LogManager.getLogger(TextFileReader.class);

  private TextFileReader() {
  }

  public static String readAllData(File file) {
    StringBuilder result;
    try (Reader reader = new InputStreamReader(new FileInputStream(file))) {
      char[] array = new char[1024];
      int count = reader.read(array);
      result = new StringBuilder();
      while (count > 0) {
        result.append(new String(array, 0, count));
        count = reader.read(array);
      }
      return result.toString();
    } catch (Exception e) {
      logger.error("The file can't be read.\n" + e.getMessage());
      return null;
    }
  }

}
