package bMedium;

public class SubsetSumPartition {
  public static void main(String[] args) {
    SubsetSumPartition solution = new SubsetSumPartition();
    int[] nums = {1, 5, 5, 11};
    boolean result = solution.canPartition(nums);
    System.out.println("Can partition: " + result);
  }

  public boolean canPartition(int[] nums) {
    int totalSum = 0;
    for (int num : nums) {
      totalSum += num;
    }
    if (totalSum % 2 != 0) return false;
    int subSetSum = totalSum / 2;
    int n = nums.length;
    boolean[][] dp = new boolean[n + 1][subSetSum + 1];
    dp[0][0] = true;
    for (int i = 1; i <= n; i++) {
      int curr = nums[i - 1];
      for (int j = 0; j <= subSetSum; j++) {
        if (j < curr)
          dp[i][j] = dp[i - 1][j];
        else
          dp[i][j] = dp[i - 1][j] || (dp[i - 1][j - curr]);
      }
    }
    return dp[n][subSetSum];
  }
}
