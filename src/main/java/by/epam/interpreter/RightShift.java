package by.epam.interpreter;

public class RightShift implements Expression {

  private Expression leftOperator;
  private Expression rightOperator;

  public RightShift(Expression leftOperator, Expression rightOperator) {
    this.leftOperator = leftOperator;
    this.rightOperator = rightOperator;
  }

  @Override
  public String interpret() {
    return String.valueOf(
        Integer.parseInt(leftOperator.interpret()) >> Integer.parseInt(rightOperator.interpret()));
  }
}
