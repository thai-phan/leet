package bMedium;

public class StockWithCooldown {
  public static void main(String[] args) {
    int[] prices = {1, 2, 3, 0, 2};
//    int result = maxProfitStateMachine(prices);
    int result = maxProfitDP(prices);
    System.out.println("result = " + result);
  }

  public static int maxProfitStateMachine(int[] prices) {
    int sold = 0;
    int rest = 0;
    int hold = Integer.MIN_VALUE;
    for (int price : prices) {
      int prev_sold = sold;
      sold = hold + price;
      hold = Math.max(hold, rest - price);
      rest = Math.max(rest, prev_sold);
    }
    return Math.max(rest, sold);
  }


  public static int maxProfitDP(int[] prices) {
    int[] dp = new int[prices.length + 2];

    for (int i = prices.length - 1; i >= 0; i--) {
      int C1 = 0;
      // Case 1). buy and sell the stock
      for (int sell = i + 1; sell < prices.length; sell++) {
        int profit = (prices[sell] - prices[i]) + dp[sell + 2];
        C1 = Math.max(profit, C1);
      }

      // Case 2). do no transaction with the stock p[i]
      int C2 = dp[i + 1];

      // wrap up the two cases
      dp[i] = Math.max(C1, C2);
    }
    return dp[0];
  }
}
