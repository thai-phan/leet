package cHard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedianOfTwoSortedArrays_4 {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    List<Integer> list = new ArrayList<>();
    double median;
    for (Integer t : nums1) {
      list.add(t);
    }
    for (Integer t : nums2) {
      list.add(t);
    }
    Collections.sort(list);
    int mid = (list.size() / 2);
    if (list.size() % 2 ==1) {
      median = (double) list.get(mid);
    } else {
      median = ((double) list.get(mid) + (double) list.get(mid-1)) / 2;
    }
    return median;
  }
}
