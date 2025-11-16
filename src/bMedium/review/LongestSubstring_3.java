package bMedium.review;

import java.util.HashSet;
import java.util.Set;

// 3. Longest Substring Without Repeating Characters
public class LongestSubstring_3 {
  public int lengthOfLongestSubstring(String s) {
    int strLen = 0;
    char[] chars = s.toCharArray();
    if (chars.length == 1) {
      return 1;
    }
    for (int i = 0; i < chars.length; i++) {
      Set<Character> tempSet = new HashSet<>();
      int count = i;
      while (count < chars.length && !tempSet.contains(chars[count])) {
        tempSet.add(chars[count]);
        count = count + 1;
      }
      if (tempSet.size() > strLen) {
        strLen = tempSet.size();
      }
    }
    return strLen;
  }
}
