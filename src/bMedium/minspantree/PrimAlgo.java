package bMedium.minspantree;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PrimAlgo {
    public static void main(String[] args) {
      PrimAlgo primAlgo = new PrimAlgo();
      int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
      int result = primAlgo.minCostConnectPoints(points);
      System.out.println("result = " + result);
    }

  record Pair<K, V>(K cost, V target) {
  }

  public int minCostConnectPoints(int[][] points) {
    int totalPoint = points.length;

    // Min-heap to store minimum cost edge at top.
    PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<>(Comparator.comparingInt(Pair::cost));

    // Track nodes which are included in MST.
    boolean[] visitedArr = new boolean[totalPoint];

    heap.add(new Pair<>(0, 0));

    int mstCost = 0;
    int edgesUsed = 0;

    while (edgesUsed < totalPoint) {
      Pair<Integer, Integer> topElement = heap.poll();

      int curCost = topElement.cost();
      int curPoint = topElement.target();

      // If node was already included in MST we will discard this edge.
      if (visitedArr[curPoint]) {
        continue;
      }

      visitedArr[curPoint] = true;
      mstCost += curCost;
      edgesUsed++;

      for (int nextNode = 0; nextNode < totalPoint; ++nextNode) {
        // If next node is not in MST, then edge from curr node
        // to next node can be pushed in the priority queue.
        if (!visitedArr[nextNode]) {
          int nextWeight = Math.abs(points[curPoint][0] - points[nextNode][0]) + Math.abs(points[curPoint][1] - points[nextNode][1]);
          heap.add(new Pair<>(nextWeight, nextNode));
        }
      }
    }

    return mstCost;
  }
}
