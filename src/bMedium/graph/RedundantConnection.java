package bMedium.graph;

import java.util.ArrayList;
import java.util.List;

public class RedundantConnection {
  public static void main(String[] args) {
    RedundantConnection rc = new RedundantConnection();
    int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
    int[] result = rc.findRedundantConnection(edges);
    System.out.println("Redundant edge: [" + result[0] + ", " + result[1] + "]");
  }

  public int[] findRedundantConnection(int[][] edges) {
    int N = edges.length;
    List<List<Integer>> adjList = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      adjList.add(new ArrayList<>());
    }
    for (int[] edge : edges) {
      boolean[] visited = new boolean[N];
      if (isConnected(edge[0] - 1, edge[1] - 1, visited, adjList)) {
        return new int[]{edge[0], edge[1]};
      }
      adjList.get(edge[0] - 1).add(edge[1] - 1);
      adjList.get(edge[1] - 1).add(edge[0] - 1);
    }
    return new int[]{};
  }

  private boolean isConnected(int src, int target, boolean[] visited, List<List<Integer>> adjList) {
    visited[src] = true;
    if (src == target) {
      return true;
    }
    boolean isFound = false;
    for (int adj : adjList.get(src)) {
      if (!visited[adj]) {
        isFound = isFound || isConnected(adj, target, visited, adjList);
      }
    }
    return isFound;
  }
}
