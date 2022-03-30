package by.epam.composite.entities;

public class Letter extends BaseTextStructure{
  private char letter;

  public Letter(char letterData) {
    letter = letterData;
  }

  public void setInstance(String letter) {
    this.letter = letter.toCharArray()[0];
  }

  public String getInstance() {
    return String.valueOf(letter);
  }
}
