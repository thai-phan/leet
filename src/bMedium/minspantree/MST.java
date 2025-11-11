package bMedium.minspantree;

import java.util.*;

public class MST {
  public static void main(String[] args) {
    int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
    int result = minCostConnectPoints(points);
    System.out.println("result = " + result);
  }

  static class Point {
    int x;
    int y;
    Map<Integer, Integer> map = new HashMap<>();
    boolean checked = false;

    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static int minCostConnectPoints(int[][] points) {
    List<Point> l = new ArrayList<>();
    for (int[] point : points) {
      l.add(new Point(point[0], point[1]));
    }

    for (int i = 0; i < points.length; i++) {
      Point pi = l.get(i);
      for (int j = i + 1; j < points.length; j++) {
        Point pj = l.get(j);
        pi.map.put(j, Math.abs(pi.x - pj.x) + Math.abs(pi.y - pj.y));
        pj.map.put(i, Math.abs(pi.x - pj.x) + Math.abs(pi.y - pj.y));
      }
    }

    int sum = 0;

    Queue<Integer> queue = new LinkedList<>();

    queue.offer(0);

    while (!queue.isEmpty()) {
      int idx = queue.poll();
      Point p = l.get(idx);
      p.checked = true;

      int idxTemp = -1;
      int min = Integer.MAX_VALUE;

      for (Integer pId : p.map.keySet()) {
        Point pTemp = l.get(pId);
        if (!pTemp.checked && min > p.map.get(pId)) {
          min = p.map.get(pId);
          idxTemp = pId;
        }
      }

      if (idxTemp != -1) {
        queue.offer(idxTemp);
        sum += min;
      }
    }

    return sum;
  }
}


