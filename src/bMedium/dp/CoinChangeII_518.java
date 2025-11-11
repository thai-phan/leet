package bMedium.dp;


public class CoinChangeII_518 {
  int c = 0;

  public int change(int amount, int[] coins) {
    int[] dp = new int[amount + 1];

    dp[0] = 1;
    for (int coin : coins) {
      for (int i = coin; i <= amount; i++) {
        dp[i] += dp[i - coin];
      }
    }
    return dp[amount];
  }

  public static void main(String[] args) {
    CoinChangeII_518 cc = new CoinChangeII_518();
    int[] coins = {1, 2, 5};
    int amount = 5;
    int result = cc.change(amount, coins);
    System.out.println("Number of ways to make change for " + amount + " using coins: " + result);
  }
}