
import java.util.List;


public class MainBinary {
  public static void main(String[] args) {
//    int[] arr = {1, 2, 4, 5, 6, 6, 8, 8, 9};
//    int target = 3;
//
//    System.out.println(findClosest(arr, target));
    my();
  }

  static void my() {
    List<Integer> l = List.of(0, 2, 4, 6, 7, 10, 20, 25);

    int target = 8;
    int left = 0;
    int right = l.size();
    System.out.println("left: " + left);
    System.out.println("right: " + right);

    while (left < right) {
      int mid = (left + right) / 2;
      System.out.println("mid: " + mid);

      if (target > l.get(mid)) {
        left = mid + 1;
      } else {
        right = mid;
      }
      System.out.println("left: " + left);
      System.out.println("right: " + right);
    }

    System.out.println(l.get(right));
  }

  // Java program to find closest number in a sorted array

  static int findClosest(int[] arr, int target) {
    int res = arr[0];
    int lo = 0, hi = arr.length - 1;

    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;

      // Update res if mid is closer to target
      if (Math.abs(arr[mid] - target) < Math.abs(res - target)) {
        res = arr[mid];

        // In case of a tie, prefer larger value
      } else if (Math.abs(arr[mid] - target) == Math.abs(res - target)) {
        res = Math.max(res, arr[mid]);
      }

      if (arr[mid] == target) {
        return arr[mid];
      } else if (arr[mid] < target) {
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }

    return res;
  }

}






