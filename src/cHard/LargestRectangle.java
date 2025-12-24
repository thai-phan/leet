package cHard;

import java.util.Stack;

public class LargestRectangle {

  public static void main(String[] args) {
    int[] heights = {2, 1, 5, 6, 2, 3, 2, 3};
    int result = largestRectangleArea(heights);
    System.out.println("result = " + result);
  }

  public static int largestRectangleArea(int[] heights) {
    int n = heights.length;
    int maxArea = 0;

    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i <= n; i++) {
      int currHeight = (i == n ? 0 : heights[i]);

      // If current height breaks the increasing order
      while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {
        int top = stack.pop();
        int height = heights[top];

        int right = i;
        int left = stack.isEmpty() ? 0 : stack.peek() + 1;

        int width = right - left;
        maxArea = Math.max(maxArea, height * width);
      }

      stack.push(i);
    }

    return maxArea;
  }

}
