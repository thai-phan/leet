package lc.aEasy;

import java.util.HashMap;
import java.util.Map;


public class RomanToInteger {
  public int romanToInt(String s) {
    Map<Character, Integer> map = new HashMap<>();
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);
    int sum = 0;
    int count = 0;
    char[] chars = s.toCharArray();
    while (count < chars.length) {
      if (count < chars.length - 1) {
        if (chars[count] == 'I' && chars[count + 1] == 'V') {
          sum += 4;
          count += 2;
          continue;
        } else if (chars[count] == 'I' && chars[count + 1] == 'X') {
          sum += 9;
          count += 2;
          continue;
        } else if (chars[count] == 'X' && chars[count + 1] == 'L') {
          sum += 40;
          count += 2;
          continue;
        } else if (chars[count] == 'X' && chars[count + 1] == 'C') {
          sum += 90;
          count += 2;
          continue;
        } else if (chars[count] == 'C' && chars[count + 1] == 'D') {
          sum += 400;
          count += 2;
          continue;
        } else if (chars[count] == 'C' && chars[count + 1] == 'M') {
          sum += 900;
          count += 2;
          continue;
        }
      }
      sum += map.get(chars[count]);
      count ++;
    }
    return sum;
  }
}
