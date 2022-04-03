package by.epam.interpreter;

public class TerminalExpression implements Expression {

  private String data;

  public TerminalExpression(String data) {
    this.data = data;
  }

  @Override
  public String interpret() {
    return this.data;
  }
}