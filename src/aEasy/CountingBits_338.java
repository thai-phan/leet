package aEasy;

public class CountingBits_338 {
  public static int[] countBits(int n) {
    int[] ans = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      int aaa = (i & 1);
      int bbb = ans[i >> 1];
      ans[i] = aaa + bbb;
    }
    return ans;
  }

  public static void main(String[] args) {
    var bit = countBits(5);
    for (int i = 0; i < bit.length; i++) {
      System.out.println("i = " + i + ", bits = " + bit[i]);
    }
  }

}
