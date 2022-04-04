package by.epam.interpreter.controller.command.impl;

import static org.junit.jupiter.api.Assertions.*;

import by.epam.interpreter.Context;
import org.junit.jupiter.api.Test;

class BitwiseNotTest {

  @Test
  void calculate() {
    BitwiseNot bitwiseNot = new BitwiseNot();

    String actual = bitwiseNot.calculate(new Context("","16"));
    String expected = String.valueOf(~16);
    assertEquals(expected, actual);

  }
}