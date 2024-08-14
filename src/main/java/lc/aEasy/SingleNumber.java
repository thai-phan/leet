package lc.aEasy;

import java.util.HashMap;
import java.util.Map;

// 136. Single Number
public class SingleNumber {

  public int singleNumber(int[] nums) {
    Map<Integer, Integer> aaa = new HashMap();
    for (int num : nums) {
      if (aaa.containsKey(num)) {
        aaa.put(num, aaa.get(num) + 1);
      } else {
        aaa.put(num, 1);
      }
    }
    for (Map.Entry<Integer, Integer> entry : aaa.entrySet()) {
      if (entry.getValue() == 1) return entry.getKey();
    }
    return nums[0];
  }

}
