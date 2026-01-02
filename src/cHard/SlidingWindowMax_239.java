package cHard;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMax_239 {
  public static void main(String[] args) {

    int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
    int k = 3;
    int[] result = maxSlidingWindow(nums, k);
    for (int i : result) {
      System.out.print(i + " ");
    }

  }

  public static int[] maxSlidingWindow(int[] nums, int k) {

    int[] out = new int[nums.length - k + 1];

    Deque<Integer> queue = new LinkedList<>();

    for (int i = 0; i < k-1; i++) {
      if (nums[i] >= nums[i+1]) {
        queue.offer(nums[i]);
      }
    }

    out[0] = queue.peekFirst();

    for (int i = k; i < nums.length; i++) {
      while (!queue.isEmpty() && queue.getLast() < nums[i]) {
          queue.pollLast();
      }
      queue.offer(nums[i]);
      out[i-k+1] = queue.getFirst();
    }


    return out;
  }
}
