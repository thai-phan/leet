package bMedium;

import java.util.*;

public class SumOfThree_15 {
  public static void main(String[] args) {
    int[] arr = new int[]{1, 2, -4, 5, 5, -10, 3, 3, 7, 7, 8};
    var aaa = threeSumUseSet(arr);
    System.out.println("jjjj");
  }

  public static List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < nums.length && nums[i] <= 0; ++i)
      if (i == 0 || nums[i - 1] != nums[i]) {
        twoSumII(nums, i, res);
      }
    return res;
  }

  static void twoSumII(int[] nums, int i, List<List<Integer>> res) {
    int lo = i + 1, hi = nums.length - 1;
    while (lo < hi) {
      int sum = nums[i] + nums[lo] + nums[hi];
      if (sum < 0) {
        ++lo;
      } else if (sum > 0) {
        --hi;
      } else {
        int n1 = nums[i];
        int n2 = nums[lo];
        int n3 = nums[hi];
        res.add(Arrays.asList(n1, n2, n3));
        while (lo < hi && nums[lo] == nums[lo + 1]) {
          ++lo;
        }
        lo++;
        hi--;
      }
    }
  }

  public static List<List<Integer>> threeSumUseSet(int[] nums) {
    Set<List<Integer>> outSet = new HashSet<>();
    Set<Integer> dupSet = new HashSet<>();
    Map<Integer, Integer> seen = new HashMap<>();

    for (int i = 0; i < nums.length; ++i)
      if (dupSet.add(nums[i])) {
        for (int j = i + 1; j < nums.length; ++j) {
          int complement = -(nums[i] + nums[j]);
          if (seen.containsKey(complement) && seen.get(complement) == i) {
            List<Integer> triplet = Arrays.asList(
                nums[i],
                nums[j],
                complement
            );
            Collections.sort(triplet);
            outSet.add(triplet);
          }
          seen.put(nums[j], i);
        }
      } else {
        System.out.println("not add");
      }
    return new ArrayList<>(outSet);
  }
}


