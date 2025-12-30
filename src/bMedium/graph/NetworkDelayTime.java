package bMedium.graph;

import java.util.*;

public class NetworkDelayTime {

  public static void main(String[] args) {
    int[][] times = {{4, 2, 76}, {1, 3, 79}, {3, 1, 81}, {4, 3, 30}, {2, 1, 47}, {1, 5, 61}, {1, 4, 99}, {3, 4, 68}, {3, 5, 46}, {4, 1, 6}, {5, 4, 7}, {5, 3, 44}, {4, 5, 19}, {2, 3, 13}, {3, 2, 18}, {1, 2, 0}, {5, 1, 25}, {2, 5, 58}, {2, 4, 77}, {5, 2, 74}};
    int n = 5;
    int k = 3;
    int result = networkDelayTime(times, n, k);
    System.out.println("result = " + result);
  }

  public static int networkDelayTime(int[][] times, int n, int k) {

    int[] timeArr = new int[n + 1];

    Arrays.fill(timeArr, Integer.MAX_VALUE);
    timeArr[k] = 0;

    Map<Integer, List<int[]>> map = new HashMap<>();

    for (int i = 1; i <= n; i++) {
      map.put(i, new ArrayList<>());
    }

    for (int[] edge : times) {
      int source = edge[0];
      int target = edge[1];
      int time = edge[2];
      map.get(source).add(new int[]{target, time});
    }

    Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
    queue.offer(new int[]{k, 0});

    while (!queue.isEmpty()) {
      int[] pair = queue.poll();

      int curVal = pair[0];
      int curTime = pair[1];

      if (curTime > timeArr[curVal]) {
        continue;
      }

      for (int[] edge : map.get(curVal)) {
        if (timeArr[curVal] + edge[1] < timeArr[edge[0]]) {
          queue.offer(new int[]{edge[0], curTime + edge[1]});
          timeArr[edge[0]] = curTime + edge[1];
        }
      }
    }

    int max = Integer.MIN_VALUE;
    for (int i = 1; i <= n; i++) {
      max = Math.max(max, timeArr[i]);
    }

    return max == Integer.MAX_VALUE ? -1 : max;
  }
}
