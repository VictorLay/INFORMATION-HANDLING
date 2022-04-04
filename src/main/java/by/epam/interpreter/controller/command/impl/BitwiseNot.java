package by.epam.interpreter.controller.command.impl;

import by.epam.interpreter.Context;
import by.epam.interpreter.Expression;
import by.epam.interpreter.controller.command.Command;

public class BitwiseNot implements Command {

  @Override
  public String calculate(Context context) {
    Expression bitwiseNotExpr = (cont) -> String.valueOf(~Integer.parseInt(cont.getRightOperand()));
    return bitwiseNotExpr.interpret(context);
  }
}
