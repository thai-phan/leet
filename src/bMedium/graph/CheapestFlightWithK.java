package bMedium.graph;

import java.util.*;

public class CheapestFlightWithK {
  Map<Integer, List<int[]>> map;
  int[] priceTarget;

  public static void main(String[] args) {
    int n = 6;
    int[][] flights = {
        {0, 1, 100},
        {1, 2, 100},
        {0, 2, 500},
        {2, 3, 100},
        {0, 4, 400},
        {4, 3, 200},
    };
    int src = 0;
    int dst = 3;
    int k = 1;

    CheapestFlightWithK cfk = new CheapestFlightWithK();
    int cheapestPrice = cfk.findCheapestPriceBF(n, flights, src, dst, k);
    System.out.println("Cheapest price from " + src + " to " + dst + " with at most " + k + " stops is: " + cheapestPrice);
  }

  public int findCheapestPriceDFS(int n, int[][] flights, int src, int dst, int k) {
    map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      map.put(i, new ArrayList<>());
    }

    for (int[] flight : flights) {
      int from = flight[0];
      int to = flight[1];
      int price = flight[2];
      map.get(from).add(new int[]{to, price});
    }

    priceTarget = new int[n + 1];
    Arrays.fill(priceTarget, Integer.MAX_VALUE);

    dfs(src, 0, 0, k, dst);

    if (priceTarget[dst] == Integer.MAX_VALUE) {
      return -1;
    } else {
      return priceTarget[dst];
    }
  }

  public void dfs(int src, int totalPrice, int step, int k, int dst) {
    if (step > k + 1) {
      return;
    }
    if (totalPrice > priceTarget[dst]) {
      return;
    }
    if (totalPrice < priceTarget[src]) {
      priceTarget[src] = totalPrice;
    }
    for (int[] toCity : map.get(src)) {
      int idTo = toCity[0];
      int priceTo = toCity[1];
      dfs(idTo, totalPrice + priceTo, step + 1, k, dst);
    }
  }

  public int findCheapestPriceDijkstra(int n, int[][] flights, int src, int dst, int k) {
    int[] steps = new int[n];
    Arrays.fill(steps, Integer.MAX_VALUE);
    Map<Integer, List<int[]>> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      map.put(i, new ArrayList<>());
    }
    for (int[] f : flights) {
      int from = f[0];
      int to = f[1];
      int price = f[2];
      map.get(from).add(new int[]{to, price});
    }
    PriorityQueue<int[]> pQueue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    pQueue.offer(new int[]{src, 0, 0});
    while (!pQueue.isEmpty()) {
      int[] cur = pQueue.poll();
      int cityCur = cur[0];
      int priceCur = cur[1];
      int stepCur = cur[2];
      if (stepCur >= steps[cityCur] || stepCur > k + 1) {
        continue;
      }
      steps[cityCur] = stepCur;
      if (cityCur == dst) {
        return priceCur;
      }
      for (int[] next : map.get(cityCur)) {
        pQueue.offer(new int[]{next[0], next[1] + priceCur, stepCur + 1});
      }
    }
    return -1;
  }

  public int findCheapestPriceBF(int n, int[][] flights, int src, int dst, int k) {
    int[] costs = new int[n];
    Arrays.fill(costs, Integer.MAX_VALUE);
    costs[src] = 0;
    for (int i = 0; i <= k; i++) {
      if (!findPath(flights, costs)) {
        break;
      }
    }
    return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];
  }

  private boolean findPath(int[][] flights, int[] costs) {
    int[] tempCost = Arrays.copyOf(costs, costs.length);
    boolean isFound = false;
    for (int[] flight : flights) {
      int from = flight[0];
      int to = flight[1];
      int price = flight[2];
      int fromCost = tempCost[from];
      if (fromCost != Integer.MAX_VALUE && fromCost + price < costs[to]) {
        costs[to] = price + fromCost;
        isFound = true;
      }
    }
    return isFound;
  }
}
