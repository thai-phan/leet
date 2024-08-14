package lc.aEasy;

import java.util.HashMap;
import java.util.Map;

// 136. Single Number
public class SingleNumber {

  public static int singleNumber(int[] nums) {
    int result = 0;
    for (int num : nums) {
      result = result ^ num;
      System.out.println(result);
    }
    return result;
  }

  public static void main(String[] args) {

    var aaa = singleNumber(new int[]{2,2,3,3,4,4,1,5});
//    System.out.println(aaa);
  }

}
