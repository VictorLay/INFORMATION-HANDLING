import static org.junit.jupiter.api.Assertions.*;

import by.epam.tools.CustomTools;
import org.junit.jupiter.api.Test;

class CustomSplitTest {

  @Test
  void customSplitTestWithDelimiterEnds() {
    CustomTools customTools = new CustomTools();
    String[] expected = {"abcdifg!","abcdifk?","ddd?","adfafds..."};
    StringBuilder txt = new StringBuilder();
    for(String sentence: expected){
      txt.append(sentence);
    }
    String[] actual = customTools.customSplit(txt.toString(), "[.?!]([.]{2})?" );

    for (int i=0; actual.length > i;i++){
      assertEquals(expected[i],actual[i]);
    }
  }

  @Test
  void customSplitTestWithNoDelimiterEnds() {
    CustomTools customTools = new CustomTools();
    String[] expected = {"abcdifg!","abcdifk?","ddd?","adfafds...","sfadd"};
    StringBuilder txt = new StringBuilder();
    for(String sentence: expected){
      txt.append(sentence);
    }
    String[] actual = customTools.customSplit(txt.toString(), "[.?!]([.]{2})?" );

    for (int i=0; actual.length > i;i++){
      assertEquals(expected[i],actual[i]);
    }
  }

  @Test
  void customSplitTestWithDelimiterStarts() {
    CustomTools customTools = new CustomTools();
    String[] expected = {".","abcdifg!","abcdifk?","ddd?","adfafds..."};
    StringBuilder txt = new StringBuilder();
    for(String sentence: expected){
      txt.append(sentence);
    }
    String[] actual = customTools.customSplit(txt.toString(), "[.?!]([.]{2})?" );

    for (int i=0; actual.length > i;i++){
      assertEquals(expected[i],actual[i]);
    }
  }

  @Test
  void customSplitTestWithTabulationStarts() {
    CustomTools customTools = new CustomTools();
    String[] enterText = {"\tabcdifg!abcdifk?","\tddd?dfafds..."};
    StringBuilder txt = new StringBuilder();
    for(String sentence: enterText){
      txt.append(sentence);
    }
    String[] actual = customTools.customSplit(txt.toString(), "\t" );
    String[] expected = {"abcdifg!abcdifk?","ddd?dfafds..."};

    for (int i=0; actual.length > i;i++){
      assertEquals(expected[i],actual[i]);
    }
  }
}