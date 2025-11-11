package bMedium;

import java.util.ArrayList;
import java.util.List;

// 22. Generate Parentheses
public class GenerateParenthesis_22 {
  public static List<String> generateParenthesis(int numberParenthesis) {
    List<String> result = new ArrayList<String>();
    generateRecursive(result, 0, 0, "", numberParenthesis);
    return result;
  }

  public static void generateRecursive(List<String> result, int left, int right, String curString, int numberParenthesis) {
    if (curString.length() == numberParenthesis * 2) {
//      System.out.println("( " + curString);
      result.add(curString);
      return;
    }

    if (left < numberParenthesis) {
//      System.out.println("( " + curString);
      generateRecursive(result, left + 1, right, curString + "(", numberParenthesis);
    }

    if (right < left) {
//      System.out.println(") " + curString);
      generateRecursive(result, left, right + 1, curString + ")", numberParenthesis);
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

    var bbb = generateParenthesis(4);
    System.out.println(bbb);


  }
}
