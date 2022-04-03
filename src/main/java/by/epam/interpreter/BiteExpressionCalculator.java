package by.epam.interpreter;

import by.epam.interpreter.controller.Controller;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BiteExpressionCalculator {

  public static final String REGEXP_OF_OPERATORS_FOR_SEARCHING = "(\\d+[>]{2}\\d+)|(\\d+[<]{2}\\d+)";

  public String calculate(String text) {
    Controller controller = new Controller();
    Pattern pattern = Pattern.compile(REGEXP_OF_OPERATORS_FOR_SEARCHING);

    boolean isHaveOperator = pattern.matcher(text).find();
    while (isHaveOperator) {
      Matcher matcher = pattern.matcher(text);
      matcher.find();

      text = text.replace(text.substring(matcher.start(), matcher.end()),
          controller.executeSimpleExpression(text.substring(matcher.start(), matcher.end())));

      isHaveOperator = pattern.matcher(text).find();
    }

    return text;
  }


}
