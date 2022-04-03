package by.epam.interpreter;

public class Context {

  private String leftOperand;
  private String rightOperand;


  public Context(String leftOperand, String rightOperand) {
    this.leftOperand = leftOperand;
    this.rightOperand = rightOperand;
  }

  public String getLeftOperand() {
    return leftOperand;
  }

  public String getRightOperand() {
    return rightOperand;
  }
}