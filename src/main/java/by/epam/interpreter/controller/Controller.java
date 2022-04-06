package by.epam.interpreter.controller;


import by.epam.interpreter.Context;
import by.epam.interpreter.controller.command.Command;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Controller {

  private static final int ONE_OPERAND = 1;
  private static final int TWO_OPERANDS = 2;
  private static final String EXPECT_SIGN_NUMBERS = "[^-+0-9]+";
  private final CommandProvider provider = new CommandProvider();

  public String executeSimpleExpression(String simpleBinaryExpression) {

    Pattern pattern = Pattern.compile(EXPECT_SIGN_NUMBERS);
    Matcher operatorFinder = pattern.matcher(simpleBinaryExpression);
    operatorFinder.find();
    String operator = simpleBinaryExpression.substring(operatorFinder.start(),
        operatorFinder.end());

    Command operationAction = provider.getOperationActionByOperator(operator);
    Context context;
    switch (StringUtils.split(simpleBinaryExpression, operator).length) {
      case TWO_OPERANDS:
        context = new Context(StringUtils.split(simpleBinaryExpression, operator)[0],
            StringUtils.split(simpleBinaryExpression, operator)[1]);
        break;
      case ONE_OPERAND:
        context = new Context("", StringUtils.split(simpleBinaryExpression, operator)[0]);
        break;
      default:
        context = new Context("", "");
        Logger log = LogManager.getLogger();
        log.error("Quantity of operands in bitwise expression is illegal value.");
    }

    return operationAction.calculate(context);
  }

}
