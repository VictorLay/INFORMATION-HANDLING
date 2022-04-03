package by.epam.interpreter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BiteExpressionCalculator {

  public static final String REGEXP_OF_OPERATORS_FOR_SEARCHING = "(\\d+[>]{2}\\d+)|(\\d+[<]{2}\\d+)";

  public String calculate(String text) {

    Pattern pattern = Pattern.compile(REGEXP_OF_OPERATORS_FOR_SEARCHING);

    boolean isHaveOperator = pattern.matcher(text).find();
    while (isHaveOperator) {
      Matcher matcher = pattern.matcher(text);
      matcher.find();

      text = text.replace(text.substring(matcher.start(), matcher.end()),
          solve(text.substring(matcher.start(), matcher.end())));

      isHaveOperator = pattern.matcher(text).find();
    }

    return text;
  }

  private static String solve(String str) {

    //todo to separate operator to String value and refactor if-logic to switch
    // the next step it is switch refactoring

    if (str.contains("<<")) {
      Context context = new Context(str.split("<<")[0], str.split("<<")[1]);
      FuncExpression leftShiftExpr = (cont) -> String.valueOf(
          Integer.parseInt(cont.getLeftOperand()) << Integer.parseInt(cont.getRightOperand()));
      return leftShiftExpr.interpret(context);
    }

    if (str.contains(">>")) {
      Context context = new Context(str.split(">>")[0], str.split(">>")[1]);
      FuncExpression rightShiftExpr = (cont) -> String.valueOf(
          Integer.parseInt(cont.getLeftOperand()) >> Integer.parseInt(cont.getRightOperand()));
      return rightShiftExpr.interpret(context);
    }

    return null;
  }

}
