package by.epam.interpreter.controller.command.impl;

import static org.junit.jupiter.api.Assertions.*;

import by.epam.interpreter.Context;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

class BitwiseOrTest {

  @Test
  void calculate() {
    BitwiseOr orOperator = new BitwiseOr();
    String actual = orOperator.calculate(new Context("23", "15"));
    String expected = String.valueOf(23 | 15);

    assertEquals(expected, actual);
  }

  @Test
  void test() {
    String originalText = "15^23";
    String delimiter = "^";
    String[] response = StringUtils.split(originalText, delimiter);

    for (String r : response) {
      System.out.println(r);
    }
  }
}