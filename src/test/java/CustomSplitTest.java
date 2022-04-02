//import static org.junit.jupiter.api.Assertions.*;
//
//import by.epam.tools.CustomTextTools;
//import org.junit.jupiter.api.Test;
//
//class CustomSplitTest {
//
//  @Test
//  void customSplitTestWithDelimiterEnds() {
//    CustomTextTools customTextTools = new CustomTextTools();
//    String[] expected = {"abcdifg!","abcdifk?","ddd?","adfafds..."};
//    StringBuilder txt = new StringBuilder();
//    for(String sentence: expected){
//      txt.append(sentence);
//    }
//    String[] actual = customTextTools.customSplit(txt.toString(), "[.?!]([.]{2})?" );
//
//    for (int i=0; actual.length > i;i++){
//      assertEquals(expected[i],actual[i]);
//    }
//  }
//
//  @Test
//  void customSplitTestWithNoDelimiterEnds() {
//    CustomTextTools customTextTools = new CustomTextTools();
//    String[] expected = {"abcdifg!","abcdifk?","ddd?","adfafds...","sfadd"};
//    StringBuilder txt = new StringBuilder();
//    for(String sentence: expected){
//      txt.append(sentence);
//    }
//    String[] actual = customTextTools.customSplit(txt.toString(), "[.?!]([.]{2})?" );
//
//    for (int i=0; actual.length > i;i++){
//      assertEquals(expected[i],actual[i]);
//    }
//  }
//
//  @Test
//  void customSplitTestWithDelimiterStarts() {
//    CustomTextTools customTextTools = new CustomTextTools();
//    String[] expected = {".","abcdifg!","abcdifk?","ddd?","adfafds..."};
//    StringBuilder txt = new StringBuilder();
//    for(String sentence: expected){
//      txt.append(sentence);
//    }
//    String[] actual = customTextTools.customSplit(txt.toString(), "[.?!]([.]{2})?" );
//
//    for (int i=0; actual.length > i;i++){
//      assertEquals(expected[i],actual[i]);
//    }
//  }
//
//  @Test
//  void customSplitTestWithTabulationStarts() {
//    CustomTextTools customTextTools = new CustomTextTools();
//    String[] enterText = {"\tabcdifg!abcdifk?","\tddd?dfafds..."};
//    StringBuilder txt = new StringBuilder();
//    for(String sentence: enterText){
//      txt.append(sentence);
//    }
//    String[] actual = customTextTools.customSplit(txt.toString(), "\t" );
//    String[] expected = {"abcdifg!abcdifk?","ddd?dfafds..."};
//
//    for (int i=0; actual.length > i;i++){
//      assertEquals(expected[i],actual[i]);
//    }
//  }
//}