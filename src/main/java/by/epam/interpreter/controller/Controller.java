package by.epam.interpreter.controller;


import by.epam.interpreter.controller.command.Command;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Controller {

  private final CommandProvider provider = new CommandProvider();

  public String executeSimpleExpression(String simpleBinaryExpression) {
    Command operationAction;

    Pattern pattern = Pattern.compile("\\D+");
    Matcher operatorFinder = pattern.matcher(simpleBinaryExpression);
    operatorFinder.find();

    operationAction = provider.getOperationActionByOperator(
        simpleBinaryExpression.substring(operatorFinder.start(), operatorFinder.end()));


    return operationAction.calculate(simpleBinaryExpression);
  }

}
