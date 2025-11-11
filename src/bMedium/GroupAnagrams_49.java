package bMedium;

import java.util.*;

public class GroupAnagrams_49 {
  public static void main(String[] args) {
    String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};

    groupAnagrams(strs);

  }

  public static List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<String, List<String>>();

    for (String s : strs) {
      char[] ca = s.toCharArray();
      Arrays.sort(ca);
      String key = String.valueOf(ca);

      map.putIfAbsent(key, new ArrayList<>());
      map.get(key).add(s);
    }
    return new ArrayList<List<String>>(map.values());
  }
}