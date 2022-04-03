package by.epam.interpreter;

@FunctionalInterface
public interface Expression {
  String interpret(Context expression);
}
