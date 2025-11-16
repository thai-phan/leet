package bMedium;

public class Decode2DP {
  public static void main(String[] args) {
    Decode2DP solution = new Decode2DP();
    String s = "01226";
    int result = solution.numDecodings(s);
    System.out.println("Number of ways to decode the string \"" + s + "\": " + result);
  }

  public int numDecodings(String s) {
    int[] dp = new int[s.length() + 1];
    dp[0] = 1;

    dp[1] = s.charAt(0) == '0' ? 0 : 1;

    for (int i = 2; i < dp.length; i++) {
      if (s.charAt(i - 1) != '0') {
        dp[i] = dp[i - 1];
      }
      int twoDigit = Integer.parseInt(s.substring(i - 2, i));
      if (twoDigit >= 10 && twoDigit <= 26) {
        dp[i] += dp[i - 2];
      }
    }

    return dp[s.length()];
  }
}
