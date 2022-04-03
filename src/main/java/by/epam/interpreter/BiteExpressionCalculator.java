package by.epam.interpreter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BiteExpressionCalculator {

  public static final String REGEXP_OF_OPERATORS_FOR_SEARCHING = "(\\d+[>]{2}\\d+)|(\\d+[<]{2}\\d+)";
  public static final String LEFT_SHIFT_OPERATOR = "<<";
  public static final String RIGHT_SHIFT_OPERATOR = ">>";

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

  private static String solve(String simpleBinaryExpression) {

    //todo the next step it is switch refactoring

    Pattern pattern = Pattern.compile("\\D+");
    Matcher matcher = pattern.matcher(simpleBinaryExpression);

    if (matcher.find()){
      //todo throw some exception or error log
      return simpleBinaryExpression;
    }

    String operator = simpleBinaryExpression.substring(matcher.start(), matcher.end());
    Context context;

    switch (operator) {
      case LEFT_SHIFT_OPERATOR:
        context = new Context(simpleBinaryExpression.split(LEFT_SHIFT_OPERATOR)[0],
            simpleBinaryExpression.split(LEFT_SHIFT_OPERATOR)[1]);
        Expression leftShiftExpr = (cont) -> String.valueOf(
            Integer.parseInt(cont.getLeftOperand()) << Integer.parseInt(cont.getRightOperand()));
        return leftShiftExpr.interpret(context);
      case RIGHT_SHIFT_OPERATOR:
        context = new Context(simpleBinaryExpression.split(RIGHT_SHIFT_OPERATOR)[0],
            simpleBinaryExpression.split(RIGHT_SHIFT_OPERATOR)[1]);
        Expression rightShiftExpr = (cont) -> String.valueOf(
            Integer.parseInt(cont.getLeftOperand()) >> Integer.parseInt(cont.getRightOperand()));
        return rightShiftExpr.interpret(context);
    }

    return "";
  }

}
