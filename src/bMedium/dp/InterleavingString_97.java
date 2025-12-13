package bMedium.dp;

public class InterleavingString_97 {
  public static void main(String[] args) {
    String s1 = "aabcc";
    String s2 = "dbbca";
    String s3 = "aadbbcbcac";

//    boolean resultBF = isInterleaveBF(s1, s2, s3);
//    System.out.println("Is s3 an interleaving of s1 and s2? " + resultBF);
//
//    boolean resultRecur = isInterleaveRecur(s1, s2, s3);
//    System.out.println("Is s3 an interleaving of s1 and s2? " + resultRecur);

    boolean resultDP = isInterleaveDP(s1, s2, s3);
    System.out.println("Is s3 an interleaving of s1 and s2? " + resultDP);

  }

  public static boolean isInterleaveBF(String s1, String s2, String s3) {
    if (s1.length() + s2.length() != s3.length()) {
      return false;
    }
    return isInterleaveBFAccum(s1, s2, s3, 0, 0, "");
  }

  public static boolean isInterleaveBFAccum(String s1, String s2, String s3, int i, int j, String res) {
    if (res.equals(s3) && i == s1.length() && j == s2.length()) {
      return true;
    }
    boolean ans = false;
    if (i < s1.length()) {
      ans |= isInterleaveBFAccum(s1, s2, s3, i + 1, j, res + s1.charAt(i));
    }
    if (j < s2.length()) {
      ans |= isInterleaveBFAccum(s1, s2, s3, i, j + 1, res + s2.charAt(j));
    }
    return ans;
  }


  public static boolean isInterleaveRecur(String s1, String s2, String s3) {
    if (s1.length() + s2.length() != s3.length()) {
      return false;
    }
    int[][] memo = new int[s1.length()][s2.length()];
    for (int i = 0; i < s1.length(); i++) {
      for (int j = 0; j < s2.length(); j++) {
        memo[i][j] = -1;
      }
    }
    return isInterleaveRecurMemo(s1, s2, s3, 0, 0, 0, memo);
  }

  public static boolean isInterleaveRecurMemo(String s1, String s2, String s3, int i1, int i2, int i3, int[][] memo) {
    if (i1 == s1.length()) {
      return s2.substring(i2).equals(s3.substring(i3));
    }
    if (i2 == s2.length()) {
      return s1.substring(i1).equals(s3.substring(i3));
    }
    if (memo[i1][i2] >= 0) {
      return memo[i1][i2] == 1;
    }
    boolean ans = false;
    if ((s3.charAt(i3) == s1.charAt(i1) && isInterleaveRecurMemo(s1, s2, s3, i1 + 1, i2, i3 + 1, memo)) ||
        (s3.charAt(i3) == s2.charAt(i2) && isInterleaveRecurMemo(s1, s2, s3, i1, i2 + 1, i3 + 1, memo))) {
      ans = true;
    }
    memo[i1][i2] = ans ? 1 : 0;
    return ans;
  }


  public static boolean isInterleaveDP(String s1, String s2, String s3) {
    if (s3.length() != s1.length() + s2.length()) {
      return false;
    }
    boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
    for (int i = 0; i <= s1.length(); i++) {
      for (int j = 0; j <= s2.length(); j++) {
        if (i == 0 && j == 0) {
          dp[i][j] = true;
        } else if (i == 0) {
          dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
        } else if (j == 0) {
          dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
        } else {
          dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
              (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
        }
      }
    }
    return dp[s1.length()][s2.length()];
  }

  String s1, s2, s3;


  public boolean isInterleave(String s1, String s2, String s3) {
    if (s1.length() + s2.length() != s3.length()) {
      return false;
    }

    Boolean[][] memo = new Boolean[s1.length() + 1][s2.length() + 1];

    this.s1 = s1;
    this.s2 = s2;
    this.s3 = s3;

    return traverse(0, 0, memo);
  }


  public boolean traverse(int s1Index, int s2Index, Boolean[][] memo) {
    if (s1Index + s2Index == s3.length()) {
      return true;
    }

    if (memo[s1Index][s2Index] == null) {
      memo[s1Index][s2Index] =
          (
              s1Index < s1.length()
                  && s3.charAt(s1Index + s2Index) == s1.charAt(s1Index)
                  && traverse(s1Index + 1, s2Index, memo)
          ) || (
              s2Index < s2.length()
                  && s3.charAt(s1Index + s2Index) == s2.charAt(s2Index)
                  && traverse(s1Index, s2Index + 1, memo)
          );
    }

    return memo[s1Index][s2Index];
  }
}
