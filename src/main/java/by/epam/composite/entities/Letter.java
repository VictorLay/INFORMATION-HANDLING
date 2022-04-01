package by.epam.composite.entities;

public class Letter extends BaseTextStructure{
  private char letter;

  public Letter(char letterData) {
    letter = letterData;
  }

  @Override
  public String toString() {
    return String.valueOf(letter);
  }
}
