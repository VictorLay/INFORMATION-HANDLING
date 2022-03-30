package by.epam.tools;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ToolTestWrapperTest {


  @Test
  void customSplitTestWithDelimiterEnds() {
    ToolTestWrapper customTextTools = new ToolTestWrapper();
    String[] expected = {"abcdifg!", "abcdifk?", "ddd?", "adfafds..."};
    StringBuilder txt = new StringBuilder();
    for (String sentence : expected) {
      txt.append(sentence);
    }
    String[] actual = customTextTools.customSplit(txt.toString(), "[.?!]([.]{2})?");

    for (int i = 0; actual.length > i; i++) {
      assertEquals(expected[i], actual[i]);
    }
  }

  @Test
  void customSplitTestWithNoDelimiterEnds() {
    ToolTestWrapper customTextTools = new ToolTestWrapper();
    String[] expected = {"abcdifg!", "abcdifk?", "ddd?", "adfafds...", "sfadd"};
    StringBuilder txt = new StringBuilder();
    for (String sentence : expected) {
      txt.append(sentence);
    }
    String[] actual = customTextTools.customSplit(txt.toString(), "[.?!]([.]{2})?");

    for (int i = 0; actual.length > i; i++) {
      assertEquals(expected[i], actual[i]);
    }
  }

  @Test
  void customSplitTestWithDelimiterStarts() {
    ToolTestWrapper customTextTools = new ToolTestWrapper();
    String[] expected = {".", "abcdifg!", "abcdifk?", "ddd?", "adfafds..."};
    StringBuilder txt = new StringBuilder();
    for (String sentence : expected) {
      txt.append(sentence);
    }
    String[] actual = customTextTools.customSplit(txt.toString(), "[.?!]([.]{2})?");

    for (int i = 0; actual.length > i; i++) {
      assertEquals(expected[i], actual[i]);
    }
  }

  @Test
  void customSplitTestWithTabulationStarts() {
    ToolTestWrapper customTextTools = new ToolTestWrapper();
    String[] enterText = {"\tabcdifg!abcdifk?", "\tddd?dfafds..."};
    StringBuilder txt = new StringBuilder();
    for (String sentence : enterText) {
      txt.append(sentence);
    }
    String[] actual = customTextTools.customSplit(txt.toString(), "\t");
    String[] expected = {"abcdifg!abcdifk?", "ddd?dfafds..."};

    for (int i = 0; actual.length > i; i++) {
      assertEquals(expected[i], actual[i]);
    }
  }

}