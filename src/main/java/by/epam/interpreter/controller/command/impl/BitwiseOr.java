package by.epam.interpreter.controller.command.impl;

import by.epam.interpreter.Context;
import by.epam.interpreter.Expression;
import by.epam.interpreter.controller.command.Command;

public class BitwiseOr implements Command {

  @Override
  public String calculate(Context context) {
    Expression leftShiftExpr = cont -> String.valueOf(
        Integer.parseInt(cont.getLeftOperand()) | Integer.parseInt(cont.getRightOperand()));
    return leftShiftExpr.interpret(context);
  }
}
