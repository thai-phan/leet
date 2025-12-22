package cHard;

public class DistinctSubsequence {

  public static void main(String[] args) {
    DistinctSubsequence ds = new DistinctSubsequence();
    String s = "rabbbbbit";
    String t = "rabbit";
    int result = ds.numDistinct(s, t);
    System.out.println("Number of distinct subsequences: " + result);
  }

  public int numDistinct(String s, String t) {
    int m = s.length();
    int n = t.length();
    int[][] dp = new int[m + 1][n + 1];

    for (int i = 0; i <= m; i++) {
      dp[i][0] = 1; // An empty t can be formed from any prefix of s
    }

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (s.charAt(i - 1) == t.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    return dp[m][n];
  }

}
