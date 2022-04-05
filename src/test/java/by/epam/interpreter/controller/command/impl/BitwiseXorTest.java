package by.epam.interpreter.controller.command.impl;

import static org.junit.jupiter.api.Assertions.*;

import by.epam.interpreter.Context;
import org.junit.jupiter.api.Test;

class BitwiseXorTest {

  @Test
  void calculate() {
    BitwiseXor xorOperator = new BitwiseXor();
    String actual = xorOperator.calculate(new Context("23", "-15"));
    String expected = String.valueOf(23^- 15);

    assertEquals(expected, actual);
  }
}