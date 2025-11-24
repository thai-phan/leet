package bMedium;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncrease {

  public static void main(String[] args) {

    LongestIncrease solution = new LongestIncrease();
    int[] nums = {0, 1, 0, 3, 2, 3};
    int result = solution.lengthOfLIS(nums);
    System.out.println("Length of Longest Increasing Subsequence: " + result);
  }

  public int lengthOfLIS(int[] nums) {
    int[] dp = new int[nums.length];
    Arrays.fill(dp, 1);

    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
//          dp[i] = Math.max(dp[i], dp[j] + 1);
          dp[i] = dp[j] + 1;

        }
      }
    }
    System.out.println("dp = ");
    for (int j : dp) {
      System.out.print(j + ", ");
    }
    System.out.println();
    int max = Integer.MIN_VALUE;
    for (int j : dp) {
      if (j > max) {
        max = j;
      }
    }
    return max;
  }

  public int lengthOfLISSubsequence(int[] nums) {
    ArrayList<Integer> sub = new ArrayList<>();
    sub.add(nums[0]);

    for (int i = 1; i < nums.length; i++) {
      int num = nums[i];
      if (num > sub.getLast()) {
        sub.add(num);
      } else {
        int j = 0;
        while (num > sub.get(j)) {
          j += 1;
        }

        sub.set(j, num);
      }
    }

    return sub.size();
  }

  public int lengthOfLISBinary(int[] nums) {
    ArrayList<Integer> sub = new ArrayList<>();
    sub.add(nums[0]);

    for (int i = 1; i < nums.length; i++) {
      int num = nums[i];
      if (num > sub.getLast()) {
        sub.add(num);
      } else {
        int j = binarySearch(sub, num);
        sub.set(j, num);
      }
    }

    return sub.size();
  }

  private int binarySearch(ArrayList<Integer> sub, int num) {
    int left = 0;
    int right = sub.size() - 1;
    int mid;

    while (left < right) {
      mid = (left + right) / 2;
      if (sub.get(mid) == num) {
        return mid;
      }

      if (sub.get(mid) < num) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }

    return left;
  }
}
