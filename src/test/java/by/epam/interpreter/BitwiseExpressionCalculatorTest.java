package by.epam.interpreter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BitwiseExpressionCalculatorTest {

  @Test
  void calculateLeftShiftExpression() {
    BitwiseExpressionCalculator calculator = new BitwiseExpressionCalculator();
    String originalText = "word1 65<<2 word2";
    String expectedText = "word1 " + (65 << 2) + " word2";
    String actualText = calculator.calculate(originalText);

    assertEquals(expectedText, actualText);
  }

  @Test
  void calculateLeftShiftExpressionWithNegativeRightOperand() {
    BitwiseExpressionCalculator calculator = new BitwiseExpressionCalculator();
    String originalText = "word1 65<<-2 word2";
    String expectedText = "word1 " + (65 << (-2)) + " word2";
    String actualText = calculator.calculate(originalText);

    assertEquals(expectedText, actualText);
  }

  @Test
  void calculateLeftShiftExpressionWithNegativeLeftOperand() {
    BitwiseExpressionCalculator calculator = new BitwiseExpressionCalculator();
    String originalText = "word1 -65<<2 word2";
    String expectedText = "word1 " + ((-65) << 2) + " word2";
    String actualText = calculator.calculate(originalText);

    assertEquals(expectedText, actualText);
  }

  @Test
  void calculateRightShiftExpression() {
    BitwiseExpressionCalculator calculator = new BitwiseExpressionCalculator();
    String originalText = "word1 365>>2 word2";
    String expectedText = "word1 " + (365 >> 2) + " word2";
    String actualText = calculator.calculate(originalText);

    assertEquals(expectedText, actualText);
  }

  @Test
  void calculateRightShiftExpressionWithNegativeRightOperand() {
    BitwiseExpressionCalculator calculator = new BitwiseExpressionCalculator();
    String originalText = "word1 365>>-2 word2";
    String expectedText = "word1 " + (365 >> -2) + " word2";
    String actualText = calculator.calculate(originalText);

    assertEquals(expectedText, actualText);
  }

  @Test
  void calculateRightShiftExpressionWithNegativeLeftOperand() {
    BitwiseExpressionCalculator calculator = new BitwiseExpressionCalculator();
    String originalText = "word1 -3>>1 word2";
    String expectedText = "word1 " + (-3 >> 1) + " word2";
    String actualText = calculator.calculate(originalText);

    assertEquals(expectedText, actualText);
  }

  @Test
  void calculateRightShiftExpressionWithFewOperatorsInRow() {
    BitwiseExpressionCalculator calculator = new BitwiseExpressionCalculator();
    String originalText = "word1 365>>2>>1 word2";
    String expectedText = "word1 " + (365 >> 2 >> 1) + " word2";
    String actualText = calculator.calculate(originalText);

    assertEquals(expectedText, actualText);
  }

  @Test
  void calculateLeftShiftExpressionWithFewOperatorsInRow() {
    BitwiseExpressionCalculator calculator = new BitwiseExpressionCalculator();
    String originalText = "word1 365<<2<<1 word2";
    String expectedText = "word1 " + (365 << 2 << 1) + " word2";
    String actualText = calculator.calculate(originalText);

    assertEquals(expectedText, actualText);
  }

  @Test
  void calculateLeftShiftExpressionWithFewOperators() {
    BitwiseExpressionCalculator calculator = new BitwiseExpressionCalculator();
    String originalText = "word1 365<<2<<1 word2 170<<2";
    String expectedText = "word1 " + (365 << 2 << 1) + " word2 " + (170 << 2);
    String actualText = calculator.calculate(originalText);

    assertEquals(expectedText, actualText);
  }

  @Test
  void calculateRightShiftExpressionWithFewOperators() {
    BitwiseExpressionCalculator calculator = new BitwiseExpressionCalculator();
    String originalText = "word1 365>>2>>1 word2 170>>2";
    String expectedText = "word1 " + (365 >> 2 >> 1) + " word2 " + (170 >> 2);
    String actualText = calculator.calculate(originalText);

    assertEquals(expectedText, actualText);
  }

  @Test
  void calculateCombinedExpressionWithFewOperators() {
    BitwiseExpressionCalculator calculator = new BitwiseExpressionCalculator();
    String originalText = "word1 365>>2<<4 word2";
    String expectedText = "word1 " + (365 >> 2 << 4) + " word2";
    String actualText = calculator.calculate(originalText);

    assertEquals(expectedText, actualText);
  }

  @Test
  void calculateExpandBracketsTest() {
    BitwiseExpressionCalculator calculator = new BitwiseExpressionCalculator();
    String originalText = "word1 (36524) word2";
    String expectedText = "word1 36524 word2";
    String actualText = calculator.expandBrackets(originalText);

    assertEquals(expectedText, actualText);
  }

  @Test
  void calculateExpandBracketsTestWithNegativeOperand() {
    BitwiseExpressionCalculator calculator = new BitwiseExpressionCalculator();
    String originalText = "word1 (-36524) word2";
    String expectedText = "word1 (-36524) word2";
    String actualText = calculator.expandBrackets(originalText);

    assertEquals(expectedText, actualText);
  }

  @Test
  void calculateTryToExpandBracketsOfExpressionExpectedNoAction() {
    BitwiseExpressionCalculator calculator = new BitwiseExpressionCalculator();
    String originalText = "word1 (365>>24) word2";
    String expectedText = "word1 (365>>24) word2";
    String actualText = calculator.expandBrackets(originalText);

    assertEquals(expectedText, actualText);
  }

  @Test
  void calculateCombinedExpressionWithFewOperatorsAndBrace() {
    BitwiseExpressionCalculator calculator = new BitwiseExpressionCalculator();
    String originalText = "word1 365>>(2<<4) word2";
    String expectedText = "word1 " + (365 >> (2 << 4)) + " word2";
    String actualText = calculator.calculate(originalText);

    assertEquals(expectedText, actualText);
  }

  @Test
  void calculateCombinedExpressionWithFewOperatorsAndBraceInDifferentPartOfText() {
    BitwiseExpressionCalculator calculator = new BitwiseExpressionCalculator();
    String originalText = "word1 365>>(2<<4) word2 1<<(62>>7)";
    String expectedText = "word1 " + (365 >> (2 << 4)) + " word2 " + (1 << (62 >> 7));
    String actualText = calculator.calculate(originalText);

    assertEquals(expectedText, actualText);
  }

  @Test
  void calculateBitwiseNOTExpression() {
    BitwiseExpressionCalculator calculator = new BitwiseExpressionCalculator();
    String originalText = "word1 ~15 word2";
    String expectedText = "word1 " + (~15) + " word2";
    String actualText = calculator.calculate(originalText);

    assertEquals(expectedText, actualText);
  }

  @Test
  void calculateFewBitwiseNOTExpressionWithBrackets() {
    BitwiseExpressionCalculator calculator = new BitwiseExpressionCalculator();
    String originalText = "word1 ~(~-15) word2";
    String expectedText = "word1 " + (~(~-15)) + " word2";
    String actualText = calculator.calculate(originalText);

    assertEquals(expectedText, actualText);
  }

  @Test
  void calculateBitwiseANDExpression() {
    BitwiseExpressionCalculator calculator = new BitwiseExpressionCalculator();
    String originalText = "word1 15&17 word2";
    String expectedText = "word1 " + (15 & 17) + " word2";
    String actualText = calculator.calculate(originalText);

    assertEquals(expectedText, actualText);

  }

  @Test
  void calculateBitwiseANDExpressionWithLeftNegativeOperand() {
    BitwiseExpressionCalculator calculator = new BitwiseExpressionCalculator();
    String originalText = "word1 -15&17 word2";
    String expectedText = "word1 " + (-15 & 17) + " word2";
    String actualText = calculator.calculate(originalText);

    assertEquals(expectedText, actualText);
  }

  @Test
  void calculateBitwiseANDExpressionWithRightNegativeOperand() {
    BitwiseExpressionCalculator calculator = new BitwiseExpressionCalculator();
    String originalText = "word1 15&-17 word2";
    String expectedText = "word1 " + (15 & -17) + " word2";
    String actualText = calculator.calculate(originalText);

    assertEquals(expectedText, actualText);
  }

  @Test
  void calculateBitwiseANDExpressionWithBrackets() {
    BitwiseExpressionCalculator calculator = new BitwiseExpressionCalculator();
    String originalText = "word1 6&(15&-17) word2";
    String expectedText = "word1 " + (6 & (15 & -17)) + " word2";
    String actualText = calculator.calculate(originalText);

    assertEquals(expectedText, actualText);
  }


}