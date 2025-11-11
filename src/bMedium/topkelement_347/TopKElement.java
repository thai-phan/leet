package bMedium.topkelement_347;

import java.util.*;

// 347. Top K Frequent Elements
public class TopKElement {

  public static int[] topKFrequentSolution1(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();

    for (Integer num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    Queue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(map::get));

    for (int n : map.keySet()) {
      heap.add(n);
      if (heap.size() > k) heap.poll();
    }

    int[] top = new int[k];
    for (int i = k - 1; i >= 0; --i) {
      top[i] = heap.poll();
    }
    return top;
  }

  public static void main(String[] args) {
    var nums = new int[]{1,1,1,2,2,3,4,4,4,5,5,5,6,6,6,6,6,2,2};
    int k = 3;
    var r = topKFrequentSolution1(nums, k);
    System.out.println("aaa");
  }

}

