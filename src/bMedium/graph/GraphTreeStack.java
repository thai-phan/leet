package bMedium.graph;

import java.util.*;

public class GraphTreeStack {
  public static void main(String[] args) {
    int n = 5;
    int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};

    boolean result = validTree(n, edges);
    System.out.println("result = " + result);
  }

  public static boolean validTree(int n, int[][] edges) {
    List<List<Integer>> adjacencyList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adjacencyList.add(new ArrayList<>());
    }
    for (int[] edge : edges) {
      adjacencyList.get(edge[0]).add(edge[1]);
      adjacencyList.get(edge[1]).add(edge[0]);
    }

    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);
    Stack<Integer> stack = new Stack<>();
    stack.push(0);
    while (!stack.isEmpty()) {
      int targetNode = stack.pop();
      for (int startNode : adjacencyList.get(targetNode)) {
        if (map.get(targetNode) == startNode) {
          continue;
        }
        if (map.containsKey(startNode)) {
          return false;
        }
        stack.push(startNode);
        map.put(startNode, targetNode);
      }
    }

    return map.size() == n;
  }
}
