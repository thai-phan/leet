package cHard;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubString_76 {
  public static void main(String[] args) {

//    String result = minWindow("ADOBECODEBANC", "ABC");
    String result = minWindowV1("aaaaaaaaaaaabbbbbcdd", "abcdd");

    System.out.println("Result: " + result); // Expected output: "BANC"
  }

  public static String minWindowT1(String s, String t) {
    if (t.length() > s.length()) {
      return "";
    }
    HashMap<Character, Integer> tMap = new HashMap<>();
    for (char c : t.toCharArray()) {
      tMap.put(c, tMap.getOrDefault(c, 0) + 1);
    }
    int left = 0, right = t.length();
    HashMap<Character, Integer> sMap = new HashMap<>();
    for (int i = left; i < right; i++) {
      sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
    }
    if (checkMap(sMap, tMap)) {
      return s.substring(0, right);
    }
    String out = "";
    while (right < s.length()) {

      sMap.put(s.charAt(right), sMap.getOrDefault(s.charAt(right), 0) + 1);
      right++;
      if (right == s.length()) {
        System.out.println("right " + right);
      }
      System.out.println("right " + right);

      while (left < right && (!tMap.containsKey(s.charAt(left)) || sMap.get(s.charAt(left)) > tMap.get(s.charAt(left)))) {
        sMap.put(s.charAt(left), sMap.get(s.charAt(left)) - 1);
        left++;
        System.out.println("while left " + left);
      }
      if (checkMap(sMap, tMap)) {
        if (out.isEmpty() || out.length() > s.substring(left, right).length()) {
          out = s.substring(left, right);
        }
        sMap.put(s.charAt(left), sMap.get(s.charAt(left)) - 1);
        left++;
        System.out.println("left " + left);
      }
    }
    return out;
  }

  public static boolean checkMap(HashMap<Character, Integer> sMap, HashMap<Character, Integer> tMap) {
    for (char c : tMap.keySet()) {
      int sCount = sMap.getOrDefault(c, 0);
      int tCount = tMap.get(c);
      if (sCount < tCount) {
        return false;
      }
    }
    return true;
  }


  public static String minWindowPro(String s, String t) {
    int[] tCount = new int[26];
    char[] sChars = s.toCharArray();
    int start = 0;
    int tLen = t.length(), sLen = s.length();
    int minStart = 0;
    int minEnd = Integer.MAX_VALUE;
    int count = tLen;

    for (char i : t.toCharArray()) {
      tCount[i - 'a']++;
    }

    for (int i = 0; i < sLen; i++) {
      char cc = sChars[i];
      int c = cc - 'a';
      if (tCount[c]-- > 0) {
//        tCount[c]--;
        count--;
      }

      while (count == 0) {
        if (i - start < minEnd - minStart) {
          minStart = start;
          minEnd = i;
        }

        if (tCount[sChars[start++] - 'a']++ >= 0) {
          count++;
        }
      }
    }

    return minEnd == Integer.MAX_VALUE ? "" : s.substring(minStart, minEnd + 1);
  }

  public static String minWindowV1(String s, String t) {
    if (s.isEmpty() || t.isEmpty()) {
      return "";
    }
    Map<Character, Integer> targetMap = new HashMap<Character, Integer>();
    for (int i = 0; i < t.length(); i++) {
      targetMap.put(t.charAt(i), targetMap.getOrDefault(t.charAt(i), 0) + 1);
    }
    int required = targetMap.size();
    int left = 0, right = 0;

    // formed is used to keep track of how many unique characters in t
    // are present in the current window in its desired frequency.
    // e.g. if t is "AABC" then the window must have two A's, one B and one C.
    // Thus formed would be = 3 when all these conditions are met.
    int formed = 0;

    // Dictionary which keeps a count of all the unique characters in the current window.
    Map<Character, Integer> windowMap = new HashMap<>();

    // ans list of the form (window length, left, right)
    int[] ans = {-1, 0, 0};

    while (right < s.length()) {
      // Add one character from the right to the window
      char c = s.charAt(right);
      windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

      // If the frequency of the current character added equals to the
      // desired count in t then increment the formed count by 1.
      if (targetMap.containsKey(c) && windowMap.get(c).intValue() == targetMap.get(c).intValue()) {
        formed++;
      }

      // Try and contract the window till the point where it ceases to be 'desirable'.
      while (left <= right && formed == required) {
        c = s.charAt(left);
        // Save the smallest window until now.
        if (ans[0] == -1 || right - left + 1 < ans[0]) {
          ans[0] = right - left + 1;
          ans[1] = left;
          ans[2] = right;
        }

        // The character at the position pointed by the
        // `Left` pointer is no longer a part of the window.
        windowMap.put(c, windowMap.get(c) - 1);
        if (targetMap.containsKey(c) && windowMap.get(c) < targetMap.get(c)) {
          formed--;
        }

        // Move the left pointer ahead, this would help to look for a new window.
        left++;
      }

      // Keep expanding the window once we are done contracting.
      right++;
    }

    return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
  }
}
