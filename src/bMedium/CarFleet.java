package bMedium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class CarFleet {
  public static void main(String[] args) {
    CarFleet solution = new CarFleet();
    int target = 12;
    int[] position = {10, 8, 0, 5, 3};
    int[] speed = {2, 4, 1, 1, 3};
    int result = solution.carFleet(target, position, speed);
    System.out.println("Number of car fleets: " + result);
  }

  public int carFleet(int t, int[] p, int[] s) {
    int n = p.length;
    double[][] car = new double[n][2];

    for (int i = 0; i < n; i++) {
      car[i][0] = p[i];
      car[i][1] = (double) (t - p[i]) / s[i];
    }

    Arrays.sort(car, (a, b) -> Double.compare(b[0], a[0]));

    Deque<Double> stk = new ArrayDeque<>();

    for (int i = 0; i < n; i++) {
      if (stk.isEmpty() || car[i][1] > stk.peek()) {
        stk.push(car[i][1]);
      }
    }
    return stk.size();
  }
}
