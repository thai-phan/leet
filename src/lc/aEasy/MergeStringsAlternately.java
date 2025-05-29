package lc.aEasy;

import java.util.ArrayList;
import java.util.List;

public class MergeStringsAlternately {

  public String mergeAlternately(String word1, String word2) {

    int maxLength = Math.max(word1.length(), word2.length());

    StringBuilder sb = new StringBuilder();
    int count = 0;
    while (count < maxLength) {
      if (count < word1.length()) {
        sb.append(word1.charAt(count));
      }
      if (count < word2.length()) {
        sb.append(word2.charAt(count));
      }
      count++;
    }

    return sb.toString();
  }
}
