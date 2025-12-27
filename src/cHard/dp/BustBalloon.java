package cHard.dp;

import java.util.Arrays;

public class BustBalloon {
  public static void main(String[] args) {


    int[] nums = {3, 2, 5, 8, 7};
//    int result = maxCoinsRecur(nums);
//    System.out.println("result = " + result); // Expected output: 167
//    int result2 = maxCoinsLoop(nums);
//    System.out.println("result2 = " + result2); // Expected output: 167
    int result3 = new BustBalloon().maxCoins2(nums);
    System.out.println("result3 = " + result3); // Expected output: 167
  }

  public static int maxCoinsRecur(int[] nums) {
    // add 1 before and after nums
    int n = nums.length + 2;
    int[] newNums = new int[n];

    System.arraycopy(nums, 0, newNums, 1, n - 2);

    newNums[0] = 1;
    newNums[n - 1] = 1;

    // cache the results of dp
    int[][] memo = new int[n][n];

    // we can not burst the first one and the last one
    // since they are both fake balloons added by ourselves
    int out = dp(memo, newNums, 1, n - 2);
    return out;
  }

  public static int dp(int[][] memo, int[] nums, int left, int right) {
    // return maximum if we burst all nums[left]...nums[right], inclusive
    System.out.println(left + " " + right);
    if (left > right) {
      return 0;
    }

    // we've already seen this, return from cache
    if (memo[left][right] > 0) {
      return memo[left][right];
    }

    // find the last burst one in nums[left]...nums[right]
    int result = 0;
    for (int i = left; i <= right; i++) {
      // nums[i] is the last burst one
      int gain = nums[left - 1] * nums[i] * nums[right + 1];
      // nums[i] is fixed, recursively call left side and right side
      int remainLeft = dp(memo, nums, left, i - 1);
      int remainRight = dp(memo, nums, i + 1, right);
      result = Math.max(result, remainLeft + remainRight + gain);
    }
    // add to the cache
    memo[left][right] = result;
    return result;
  }

  public static int maxCoinsLoop(int[] nums) {
    // add 1 before and after nums
    int len = nums.length + 2;
    int[] newNums = new int[len];
    System.arraycopy(nums, 0, newNums, 1, len - 2);
    newNums[0] = 1;
    newNums[len - 1] = 1;
    // dp[i][j] represents
    // maximum if we burst all nums[left]...nums[right], inclusive
    int[][] dp = new int[len][len];
    // do not include the first one and the last one
    // since they are both fake balloons added by ourselves, and we can not burst them
    for (int left = len - 2; left >= 1; left--) {
      System.out.println("start left = " + left);
      for (int right = left; right <= len - 2; right++) {
        for (int last = left; last <= right; last++) {
          int gain = newNums[left - 1] * newNums[last] * newNums[right + 1];
          System.out.println("newNums[left - 1] = newNums[" + (left - 1) + "] = " + newNums[left - 1]);
          System.out.println("newNums[i] = newNums[" + last + "] = " + newNums[last]);
          System.out.println("newNums[right + 1] = newNums[" + (right + 1) + "] = " + newNums[right + 1]);
          int dpLeft = dp[left][last - 1];
          System.out.println("dpLeft = dp[" + left + "][" + (last - 1) + "] = " + dpLeft);
          int dpRight = dp[last + 1][right];
          System.out.println("dpRight = dp[" + (last + 1) + "][" + right + "] = " + dpRight);
          int remaining = dpLeft + dpRight;
          if (remaining + gain > dp[left][right]) {
            System.out.println("updating dp[" + left + "][" + right + "] from " + dp[left][right] +
                " to " + (remaining + gain) + " with i = " + last);
            dp[left][right] = remaining + gain;
          }


        }
        System.out.println("end dp[" + left + "][" + right + "] = " + dp[left][right]);
      }
      System.out.println("end left = " + left);
      System.out.println("-----");
    }
    // burst newNums[1]...newNums[n-2], excluding the first one and the last one
    return dp[1][len - 2];
  }

  public int maxCoins2(int[] nums) {
    int n = nums.length;
    int[] arr = new int[n + 2];
    arr[0] = 1;
    arr[n + 1] = 1;
    for (int i = 0; i < n; i++){
      arr[i + 1] = nums[i];
    }

    int[][] dp = new int[n + 2][n + 2];

    for (int len = 2; len < n + 2; len++) {
      for (int left = 0; left + len < n + 2; left++) {
        int right = left + len;
        for (int k = left + 1; k < right; k++) {
          int coins = arr[left] * arr[k] * arr[right];
          coins += dp[left][k] + dp[k][right];

          dp[left][right] = Math.max(dp[left][right], coins);
        }
      }
    }

    return dp[0][n + 1];
  }
}
