package lc;

import java.util.ArrayList;
import java.util.List;

// 22. Generate Parentheses
public class GenerateParenthesis {
  public static List<String> generateParenthesis(int numberParenthesis) {
    List<String> result = new ArrayList<String>();
    recurse(result, 0, 0, "", numberParenthesis);
    return result;
  }

  public static void recurse(List<String> result, int left, int right, String s, int numberParenthesis) {
    if (s.length() == numberParenthesis * 2) {
      result.add(s);
      return;
    }

    if (left < numberParenthesis) {
      recurse(result, left + 1, right, s + "(", numberParenthesis);
    }

    if (right < left) {
      recurse(result, left, right + 1, s + ")", numberParenthesis);
    }
  }
  // See above tree diagram with parameters (left, right, s) for better understanding

  public List<String> myGenerateParenthesis(int n) {
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

    var bbb = generateParenthesis(3);
    System.out.println(bbb);


  }
}
