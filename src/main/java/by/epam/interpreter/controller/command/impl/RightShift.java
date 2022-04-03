package by.epam.interpreter.controller.command.impl;

import by.epam.interpreter.Context;
import by.epam.interpreter.Expression;
import by.epam.interpreter.controller.command.Command;
import by.epam.interpreter.controller.command.Operators;

public class RightShift implements Command {

  @Override
  public String calculate(String simpleBinaryExpression) {
    Context context = new Context(simpleBinaryExpression.split(Operators.RIGHT_SHIFT)[0],
        simpleBinaryExpression.split(Operators.RIGHT_SHIFT)[1]);
    Expression leftShiftExpr = (cont) -> String.valueOf(
        Integer.parseInt(cont.getLeftOperand()) >> Integer.parseInt(cont.getRightOperand()));
    return leftShiftExpr.interpret(context);
  }
}
