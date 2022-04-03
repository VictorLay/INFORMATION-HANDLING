package by.epam.interpreter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BiteExpressionCalculatorTest {

  @Test
  void calculateLeftShiftExpression() {
    BiteExpressionCalculator calculator = new BiteExpressionCalculator();
    String originalText = "word1 65<<2 word2";
    String expectedText = "word1 " + (65<<2) + " word2";
    String actualText = calculator.calculate(originalText);

    assertEquals(expectedText, actualText);
  }

  @Test
  void calculateRightShiftExpression() {
    BiteExpressionCalculator calculator = new BiteExpressionCalculator();
    String originalText = "word1 365>>2 word2";
    String expectedText = "word1 " + (365>>2) + " word2";
    String actualText = calculator.calculate(originalText);

    assertEquals(expectedText, actualText);
  }

  @Test
  void calculateRightShiftExpressionWithFewOperatorsInRow() {
    BiteExpressionCalculator calculator = new BiteExpressionCalculator();
    String originalText = "word1 365>>2>>1 word2";
    String expectedText = "word1 " + (365>>2>>1) + " word2";
    String actualText = calculator.calculate(originalText);

    assertEquals(expectedText, actualText);
  }

  @Test
  void calculateLeftShiftExpressionWithFewOperatorsInRow() {
    BiteExpressionCalculator calculator = new BiteExpressionCalculator();
    String originalText = "word1 365<<2<<1 word2";
    String expectedText = "word1 " + (365<<2<<1) + " word2";
    String actualText = calculator.calculate(originalText);

    assertEquals(expectedText, actualText);
  }

  @Test
  void calculateLeftShiftExpressionWithFewOperators() {
    BiteExpressionCalculator calculator = new BiteExpressionCalculator();
    String originalText = "word1 365<<2<<1 word2 170<<2";
    String expectedText = "word1 " + (365<<2<<1) + " word2 " + (170<<2);
    String actualText = calculator.calculate(originalText);

    assertEquals(expectedText, actualText);
  }

  @Test
  void calculateRightShiftExpressionWithFewOperators() {
    BiteExpressionCalculator calculator = new BiteExpressionCalculator();
    String originalText = "word1 365>>2>>1 word2 170>>2";
    String expectedText = "word1 " + (365>>2>>1) + " word2 " + (170>>2);
    String actualText = calculator.calculate(originalText);

    assertEquals(expectedText, actualText);
  }

  @Test
  void calculateCombinedExpressionWithFewOperators() {
    BiteExpressionCalculator calculator = new BiteExpressionCalculator();
    String originalText = "word1 365>>2<<4 word2";
    String expectedText = "word1 " + (365>>2<<4) + " word2";
    String actualText = calculator.calculate(originalText);

    assertEquals(expectedText, actualText);
  }

  @Test
  void calculateExpandBracketsTest() {
    BiteExpressionCalculator calculator = new BiteExpressionCalculator();
    String originalText = "word1 (36524) word2";
    String expectedText = "word1 36524 word2";
    String actualText = calculator.expandBrackets(originalText);

    assertEquals(expectedText, actualText);
  }

  @Test
  void calculateTryToExpandBracketsOfExpressionExpectedNoAction() {
    BiteExpressionCalculator calculator = new BiteExpressionCalculator();
    String originalText = "word1 (365>>24) word2";
    String expectedText = "word1 (365>>24) word2";
    String actualText = calculator.expandBrackets(originalText);

    assertEquals(expectedText, actualText);
  }

  @Test
  void calculateCombinedExpressionWithFewOperatorsAndBrace() {
    BiteExpressionCalculator calculator = new BiteExpressionCalculator();
    String originalText = "word1 365>>(2<<4) word2";
    String expectedText = "word1 " + (365>>(2<<4)) + " word2";
    String actualText = calculator.calculate(originalText);

    assertEquals(expectedText, actualText);
  }


}