package cHard.grahp;

import java.util.*;

public class AlienOrder {
  public static void main(String[] args) {
    String[] words = {"wrt", "wrf", "wf", "er", "ett", "efe", "eff", "rftt"};
    String order = alienOrder(words);
    System.out.println(order);
  }

  public static String alienOrder(String[] words) {
    // Step 0: Create data structures and find all unique letters.
    Map<Character, List<Character>> adjacencyList = new HashMap<>();
    Map<Character, Integer> counts = new HashMap<>();
    for (String word : words) {
      for (char c : word.toCharArray()) {
        counts.put(c, 0);
        adjacencyList.put(c, new ArrayList<>());
      }
    }

    // Step 1: Find all edges.
    for (int i = 0; i < words.length - 1; i++) {
      String word1 = words[i];
      String word2 = words[i + 1];
      // Check that word2 is not a prefix of word1.
      if (word1.length() > word2.length() && word1.startsWith(word2)) {
        return "";
      }
      // Find the first non match and insert the corresponding relation.
      for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
        if (word1.charAt(j) != word2.charAt(j)) {
          adjacencyList.get(word1.charAt(j)).add(word2.charAt(j));
          counts.put(word2.charAt(j), counts.get(word2.charAt(j)) + 1);
          break;
        }
      }
    }

    // Step 2: Breadth-first search.
    StringBuilder sb = new StringBuilder();
    Queue<Character> queue = new LinkedList<>();
    for (Character c : counts.keySet()) {
      if (counts.get(c).equals(0)) {
        queue.add(c);
      }
    }
    while (!queue.isEmpty()) {
      Character c = queue.remove();
      sb.append(c);
      for (Character next : adjacencyList.get(c)) {
        counts.put(next, counts.get(next) - 1);
        if (counts.get(next).equals(0)) {
          queue.add(next);
        }
      }
    }

    if (sb.length() < counts.size()) {
      return "";
    }
    return sb.toString();
  }

  public static String alienOrderT(String[] words) {
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
