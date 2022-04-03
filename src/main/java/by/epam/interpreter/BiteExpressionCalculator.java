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

    //todo the next step it is switch refactoring

    Pattern pattern = Pattern.compile("\\D+");
    Matcher matcher = pattern.matcher(str);
    matcher.find();
    String operator = str.substring(matcher.start(), matcher.end());
    Context context;

    switch (operator){
      case "<<":
        context = new Context(str.split("<<")[0], str.split("<<")[1]);
        Expression leftShiftExpr = (cont) -> String.valueOf(
            Integer.parseInt(cont.getLeftOperand()) << Integer.parseInt(cont.getRightOperand()));
        return leftShiftExpr.interpret(context);
      case ">>":
        context = new Context(str.split(">>")[0], str.split(">>")[1]);
        Expression rightShiftExpr = (cont) -> String.valueOf(
            Integer.parseInt(cont.getLeftOperand()) >> Integer.parseInt(cont.getRightOperand()));
        return rightShiftExpr.interpret(context);
    }


    return "";
  }

}
