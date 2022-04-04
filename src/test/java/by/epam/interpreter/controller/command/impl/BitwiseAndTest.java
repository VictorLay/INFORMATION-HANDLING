package by.epam.interpreter.controller.command.impl;

import static org.junit.jupiter.api.Assertions.*;

import by.epam.interpreter.Context;
import org.junit.jupiter.api.Test;

class BitwiseAndTest {

  @Test
  void calculate() {
    BitwiseAnd andOperation = new BitwiseAnd();
    String actual = andOperation.calculate(new Context("-16", "18"));
    String expected = String.valueOf(-16&18);

    assertEquals(expected, actual);
  }
}