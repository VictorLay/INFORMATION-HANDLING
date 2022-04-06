package by.epam.interpreter.controller;


import by.epam.interpreter.controller.command.Command;
import by.epam.interpreter.controller.command.Operators;
import by.epam.interpreter.controller.command.impl.BitwiseAnd;
import by.epam.interpreter.controller.command.impl.BitwiseNot;
import by.epam.interpreter.controller.command.impl.BitwiseOr;
import by.epam.interpreter.controller.command.impl.BitwiseXor;
import by.epam.interpreter.controller.command.impl.LeftShift;
import by.epam.interpreter.controller.command.impl.RightShift;
import java.util.HashMap;
import java.util.Map;


public final class CommandProvider {

  private final Map<String, Command> repository = new HashMap<>();

  CommandProvider() {
    repository.put(Operators.LEFT_SHIFT, new LeftShift());
    repository.put(Operators.RIGHT_SHIFT, new RightShift());
    repository.put(Operators.BITWISE_NOT, new BitwiseNot());
    repository.put(Operators.BITWISE_AND, new BitwiseAnd());
    repository.put(Operators.BITWISE_OR, new BitwiseOr());
    repository.put(Operators.BITWISE_XOR, new BitwiseXor());
  }

  Command getOperationActionByOperator(String operator) {
    return repository.get(operator);
  }

}
