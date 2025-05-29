package test;

public class PerfectSquareCheck {
  // Function to check if a number is a perfect square
  // using binary search
  static boolean isPerfectSquare(int number)
  {
    // Base case: 0 and 1 are perfect squares
    if (number <= 1) {
      return true;
    }

    // Initialize boundaries for binary search
    long left = 1, right = number;

    while (left <= right) {
      // Calculate middle value
      long mid = left + (right - left) / 2;

      // Calculate square of the middle value
      long square = mid * mid;

      // If the square matches number, number is a perfect
      // square
      if (square == number) {
        return true;
      }
      // If the square is smaller than number, search the
      // right half
      else if (square < number) {
        left = mid + 1;
      }
      // If the square is larger than number, search the
      // left half
      else {
        right = mid - 1;
      }
    }

    // If the loop completes without finding a perfect
    // square, number is not a perfect square
    return false;
  }

  public static void main(String[] args)
  {
    int n = 2500;

    if (isPerfectSquare(n)) {
      System.out.println(n + " is a perfect square.");
    }
    else {
      System.out.println(
        n + " is not a perfect square.");
    }
  }
}
