package by.epam.tools;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomTextTools {

  private CustomTextTools() {
  }

  public static String[] customSplit(String text, String regex) {
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(text);
    int indexOfStringStart = 0;
    ArrayList<String> arrayOfSplitString = new ArrayList<>();
    while (matcher.find()) {
      arrayOfSplitString.add(text.substring(indexOfStringStart, matcher.end()));
      indexOfStringStart = matcher.end();
    }

    if (indexOfStringStart != text.length()) {
      arrayOfSplitString.add(text.substring(indexOfStringStart));
    }
    arrayOfSplitString.remove(regex);
    String[] response = new String[arrayOfSplitString.size()];
    for (int i = 0; i < arrayOfSplitString.size(); i++) {
      response[i] = arrayOfSplitString.get(i).trim();
    }

    return response;
  }

  public static String clearTheChars(String text, String[] removingStrings) {
    for (String removingString : removingStrings) {
      text = text.replace(removingString, "");
    }
    return text;
  }

}
