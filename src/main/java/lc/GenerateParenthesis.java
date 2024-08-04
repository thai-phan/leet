package lc;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
  public List<String> generateParenthesis(int n) {
    List<String> finalList = new ArrayList<>();
    if (n == 1) {
      finalList.add("()");
      return finalList;
    }

    finalList.add("()".repeat(Math.max(0, n)));

    int pointer = 1;
    while (pointer < n) {

    }



    return finalList;
  }

  public static String insertMiddle(String origin, String middleStr) {
    int middle = origin.length() / 2;
    return origin.substring(0, middle) + middleStr + origin.substring(middle);
  }

  public static void main(String[] args) {
    var aa = insertMiddle("aaabbb", "ccc");
    System.out.println(aa);


  }
}
