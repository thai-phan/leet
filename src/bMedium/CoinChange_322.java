package bMedium;

import java.util.Arrays;

public class CoinChange_322 {

  public static void main(String[] args) {
    int[] coins = {1, 12};
    int amount = 11;
    int result = coinChange(coins, amount);
    System.out.println("result = " + result);
  }

  public static int coinChange(int[] coins, int amount) {
    int max = amount + 1;
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, max);
    dp[0] = 0;
    for (int i = 1; i <= amount; i++) {
      for (int coin : coins) {
        if (i >= coin) {
          dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        }
      }
    }
    return dp[amount] > amount ? -1 : dp[amount];
  }
}
