


public class Main {

  public static boolean isPrime(int num) {
    if (num < 2) {
      return false;
    }
    int mid = num / 2 + 1;
    for (int i = 2; i < mid; i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }


  public static void main(String[] args) {
//    System.out.println(isPrime(1));
//    System.out.println(isPrime(2));
    System.out.println(isPrime(3));
//    System.out.println(isPrime(4));
//    System.out.println(isPrime(5));

  }
}