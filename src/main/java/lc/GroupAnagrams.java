package lc;

import java.util.ArrayList;
import java.util.List;


// TODO:
class GroupAnagrams {
  public static void main(String[] args) {
    String[] strs = new String[] {"eat","tea","tan","ate","nat","bat"};

    groupAnagrams(strs);

  }

  public static List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> result = new ArrayList<>();

    if (strs.length == 0) {
      ArrayList<String> list = new ArrayList<>();
      list.add("");
      result.add(list);
      return result;
    }

    return result;
  }
}