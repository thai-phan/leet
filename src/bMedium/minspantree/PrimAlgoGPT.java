package bMedium.minspantree;

public class PrimAlgoGPT {


  public int minCostConnectPoints(int[][] points) {
    int n = points.length;
    boolean[] visited = new boolean[n];
    int[] minDist = new int[n];
    Arrays.fill(minDist, Integer.MAX_VALUE);
    minDist[0] = 0;

    int totalCost = 0;

    for (int i = 0; i < n; i++) {
      int u = -1;
      int min = Integer.MAX_VALUE;

      // 1️⃣ pick unvisited node with smallest edge
      for (int j = 0; j < n; j++) {
        if (!visited[j] && minDist[j] < min) {
          min = minDist[j];
          u = j;
        }
      }

      visited[u] = true;
      totalCost += min;

      // 2️⃣ update distances for unvisited nodes
      for (int v = 0; v < n; v++) {
        if (!visited[v]) {
          int dist = Math.abs(points[u][0] - points[v][0]) +
              Math.abs(points[u][1] - points[v][1]);
          minDist[v] = Math.min(minDist[v], dist);
        }
      }
    }

    return totalCost;
  }

}
