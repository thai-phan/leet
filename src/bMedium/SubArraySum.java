package bMedium;

public class SubArraySum {
  public static void main(String[] args) {
    SubArraySum sas = new SubArraySum();
//    int[] nums = {1, 1, 1};
//    int k = 2;
//    String a = "a/b/c/d//";
//    String[] b = a.split("/", -1);

    int[] nums2 = {3, 4, 5, 2, -1, 6, 1};
    int k2 = 6;
    int result = sas.subarraySumN3(nums2, k2);
    System.out.println("Number of subarrays: " + result);
  }

  public int subarraySumN3(int[] nums, int target) {
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j <= nums.length; j++) {
        int sum = 0;
        for (int k = i; k < j; k++)
          sum += nums[k];
        if (sum == target)
          count++;
      }
    }
    return count;
  }
}
