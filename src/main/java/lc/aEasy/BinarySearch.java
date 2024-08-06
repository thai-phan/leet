package lc.aEasy;


// Leetcode 704. Binary Search
public class BinarySearch {
  public int binarySearch(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int middle = left + (right - left) / 2;

      if (target == nums[middle]) {
        return middle;
      }
      if (nums[middle] < target) {
        left = middle + 1;
      } else if (nums[middle] > target) {
        right = middle - 1;
      }
    }
    return -1;
  }
}
