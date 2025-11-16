package bMedium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Decode1Recur {

  public static void main(String[] args) {
    String s = "12021";
    int result = numDecoding(s);
    System.out.println("result = " + result);
  }

  static Map<Integer, Integer> memo = new HashMap<>();

  public static int numDecoding(String s) {
    int[] coins = new int[]{1, 2, 5};
    Arrays.sort(coins);

    return recursiveWithMemo(s, 0);
  }

  private static int recursiveWithMemo(String str, int index) {
    System.out.println("index: " + index + " start");
    if (memo.containsKey(index)) {
      System.out.println("index: " + index + " from memo ");
      return memo.get(index);
    }
    if (index == str.length()) {
      System.out.println("index: " + index + " equal length ");
      return 1;
    }
    if (str.charAt(index) == '0') {
      System.out.println("index: " + index + " char 0 ");
      return 0;
    }
    if (index == str.length() - 1) {
      System.out.println("index: " + index + " equal length -1 ");
      return 1;
    }
    int ans = recursiveWithMemo(str, index + 1);
    if (str.charAt(index) == '1' || str.charAt(index) == '2' && str.charAt(index + 1) <= '6') {
      ans += recursiveWithMemo(str, index + 2);
    }
    System.out.println("index: " + index + " ans: " + ans);
    memo.put(index, ans);
    return ans;
  }
}
