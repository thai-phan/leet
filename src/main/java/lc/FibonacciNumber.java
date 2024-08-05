package lc;


public class FibonacciNumber {

  public static int fib(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    int count = 1;
    int fbacktwo = 0;
    int fbackone = 1;
    int fsum = 0;
    while (count < n) {
      fsum = fbacktwo + fbackone;
      fbacktwo = fbackone;
      fbackone = fsum;
      count++;
    }
    return fsum;
  }

  public static  void main(String[] args) {
    var aa = fib(2);
    System.out.println(aa);
  }
}
