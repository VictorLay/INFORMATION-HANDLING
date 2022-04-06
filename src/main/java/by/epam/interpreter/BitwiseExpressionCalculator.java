package by.epam.interpreter;

import by.epam.interpreter.controller.Controller;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;

public class BitwiseExpressionCalculator {

  public static final String REGEXP_OF_NOT_OPERATOR = "~[-+]?\\d+";
  public static final String REGEXP_OF_AND_OPERATOR = "[+-]?\\d+&[+-]?\\d+";
  public static final String REGEXP_OF_OR_OPERATOR = "[+-]?\\d+\\|[+-]?\\d+";
  public static final String REGEXP_OF_XOR_OPERATOR = "[+-]?\\d+\\^[+-]?\\d+";
  public static final String REGEXP_OF_RIGHT_SHIFT_OPERATOR = "([+-]?\\d+[>]{2}[+-]?\\d+)";
  public static final String REGEXP_OF_LEFT_SHIFT_OPERATOR = "([+-]?\\d+[<]{2}[+-]?\\d+)";
  private static final String BRACKETS_WITH_SIGNED_NUMBER_INSIDE = "[(][+-]?\\d+[)]";

  public static final String REGEXP_OF_OPERATORS_FOR_SEARCHING =
      REGEXP_OF_LEFT_SHIFT_OPERATOR + "|" + REGEXP_OF_RIGHT_SHIFT_OPERATOR + "|"
          + REGEXP_OF_NOT_OPERATOR + "|" + REGEXP_OF_AND_OPERATOR + "|" + REGEXP_OF_XOR_OPERATOR
          + "|" + REGEXP_OF_OR_OPERATOR;


  public String calculate(String text) {
    Pattern operatorsPattern = Pattern.compile(REGEXP_OF_OPERATORS_FOR_SEARCHING);

    boolean isHaveOperator = operatorsPattern.matcher(text).find();
    while (isHaveOperator) {
      Matcher matcher = operatorsPattern.matcher(text);
      matcher.find();
      text = calculateBitwiseExpressions(text, matcher);
      isHaveOperator = operatorsPattern.matcher(text).find();
    }

    if (text.equals(expandBrackets(text))) {
      return text;
    } else {
      return calculate(expandBrackets(text));
    }
  }

  public String expandBrackets(String text) {
    Pattern bracketsPattern = Pattern.compile(BRACKETS_WITH_SIGNED_NUMBER_INSIDE);
    boolean isHaveABrackets = bracketsPattern.matcher(text).find();
    while (isHaveABrackets) {
      Matcher matcher = bracketsPattern.matcher(text);
      matcher.find();
      text = expendTheBrackets(text, matcher);
      isHaveABrackets = bracketsPattern.matcher(text).find();
    }
    return text;
  }

  @NotNull
  private String expendTheBrackets(String text, Matcher matcher) {
    text = text.replace(text.substring(matcher.start(), matcher.end()),
        text.substring(matcher.start() + 1, matcher.end() - 1));
    return text;
  }

  @NotNull
  private String calculateBitwiseExpressions(String text, Matcher matcher) {
    Controller controller = new Controller();
    text = text.replace(text.substring(matcher.start(), matcher.end()),
        controller.executeSimpleExpression(text.substring(matcher.start(), matcher.end())));
    return text;
  }

}
