package cHard.grahp.topology;

import java.util.*;

public class BFSThai {

  public static void main(String[] args) {
    String[] words = {"wrt", "wrf", "wf", "er", "ett", "efe", "eff", "rftt"};
    String[] words2 = {"ac","ab","b"};
    String order = alienOrder(words2);
    System.out.println(order);
  }

  public static String alienOrder(String[] words) {
    Map<Character, List<Character>> adjList = new HashMap<>();
    Map<Character, Integer> desCount = new HashMap<>();

    for (String word : words) {
      for (char c : word.toCharArray()) {
        adjList.putIfAbsent(c, new ArrayList<>());
        desCount.putIfAbsent(c, 0);
      }
    }

    for (int i = 0; i < words.length - 1; i++) {
      String word1 = words[i];
      String word2 = words[i + 1];

      if (word1.length() > word2.length() && word1.startsWith(word2)) {
        return "";
      }

      int index = 0;
      int minL = Math.min(word1.length(), word2.length());
      while (index < minL) {
        char wC1 = word1.charAt(index);
        char wC2 = word2.charAt(index);
        if (wC1 != wC2) {
          adjList.get(wC1).add(wC2);
          desCount.put(wC2, desCount.getOrDefault(wC2, 0) + 1);
          break;
        }
        index++;
      }
    }

    Queue<Character> queue = new LinkedList<>();
    StringBuilder sb = new StringBuilder();

    for (char des : desCount.keySet()) {
      if (desCount.get(des) == 0) {
        sb.append(des);
        queue.offer(des);
      }
    }

    while (!queue.isEmpty()) {
      char curChar = queue.poll();

      List<Character> cList = adjList.get(curChar);
      for (char c : cList) {
        desCount.put(c, desCount.get(c) - 1);
        if (desCount.get(c) == 0) {
          sb.append(c);
        }
        queue.add(c);
      }

    }
    if (sb.length() != desCount.size()) {
      return "";
    }
    return sb.toString();


  }
}
