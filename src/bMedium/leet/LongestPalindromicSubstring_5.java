package bMedium.leet;

// 5. Longest Palindromic Substring
public class LongestPalindromicSubstring_5 {
  public static String longestPalindromeSubstring(String s) {
    String finalArr = "";
    for (int i = 0; i < s.length(); i++) {
      for (int j = i + 1; j < s.length(); j++) {
        var curString = s.substring(i, j + 1);
        var isCheck = true;
        var curLength = curString.length();
        var midLength = curLength / 2;
        for (int k = 0; k < midLength; k++) {
          var left = curString.charAt(k);
          var right = curString.charAt(curLength - k - 1);
          if (left != right) {
            isCheck = false;
            break;
          }
        }

        if (isCheck && curString.length() > finalArr.length()) {
          finalArr = curString;
        }
      }
    }

    return finalArr;

  }

  public static void main(String[] args) {
    var a = longestPalindromeSubstring("babad");
    System.out.println(a);

  }
}
