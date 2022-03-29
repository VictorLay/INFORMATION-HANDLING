package by.epam.composite.entities;

public class Letter {
  private char letter;

  public Letter(char letterData) {
    letter = letterData;
  }

  public String getInstance() {
    return String.valueOf(letter);
  }
}
