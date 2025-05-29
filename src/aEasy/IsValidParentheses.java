package aEasy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class IsValidParentheses {


  public static boolean isValid(String s) {
    boolean result = false;
    Map<Character, Character> myMap = new HashMap<>();
    myMap.put('{', '}');
    myMap.put('[', ']');
    myMap.put('(', ')');
    Stack<Character> stack = new Stack<>();
    char[] arr = s.toCharArray();
    for (int i = 0; i < arr.length; i++) {
      if (i == 0 && !myMap.containsKey(arr[i])) {
        return false;
      }
      if (myMap.containsKey(arr[i])) {
        stack.push(arr[i]);
      } else if (!stack.isEmpty() && !myMap.containsKey(arr[i]) && myMap.get(stack.peek()) == arr[i]) {
        stack.pop();
      } else {
        return false;
      }

    }
    return stack.isEmpty();
  }
}
