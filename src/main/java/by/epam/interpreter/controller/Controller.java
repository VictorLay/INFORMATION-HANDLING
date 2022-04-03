package by.epam.interpreter.controller;


import by.epam.interpreter.Context;
import by.epam.interpreter.controller.command.Command;
import by.epam.interpreter.controller.command.Operators;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Controller {

  private final CommandProvider provider = new CommandProvider();

  public String executeSimpleExpression(String simpleBinaryExpression) {

    Pattern pattern = Pattern.compile("\\D+");
    Matcher operatorFinder = pattern.matcher(simpleBinaryExpression);
    operatorFinder.find();
    String operator = simpleBinaryExpression.substring(operatorFinder.start(),
        operatorFinder.end());

    Command operationAction = provider.getOperationActionByOperator(operator);
    Context context = new Context(simpleBinaryExpression.split(operator)[0],
        simpleBinaryExpression.split(operator)[1]);

    return operationAction.calculate(context);
  }

}
