package bMedium.leet;


public class LongestCommonSub_1143 {
  public static void main(String[] args) {
    String text1 = "abcde";
    String text2 = "ace";
    var aaa = longestCommonSubsequence(text1, text2);
    System.out.println("hihi");
  }

  public static int longestCommonSubsequence(String text1, String text2) {
    int left = 0;
    int right = 1;
    String common = "";
    String text;
    if (text1.length() > text2.length()) {
      text = text2;
    } else {
      text = text1;
    }

    for (int i = 0; i < text.length(); i++) {

    }

//    while (right <= text.length()  && left <= text.length() - 1) {
//      if (common.length() < text.substring(left, right).length()) {
//        String temp = text.substring(left, right);
//      } else {
//        left++;
//        right++;
//      }
//      if (text1.contains(temp)) {
//        right++;
//        common = temp;
//      } else {
//
//      }
//    }
    return common.length();
  }
}
