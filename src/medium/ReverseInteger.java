package medium;



class ReverseInteger {
  public static int reverse(int x) {
    int clone = x;
    int sign = 1;
    if (x == Integer.MIN_VALUE) {
      return 0;
    }
    if (x < 0 ) {
      sign = -1;
      clone = -clone;
    }
    if (x == 0) {
      return 0;
    }
    int reverse = clone % 10;
    clone = clone / 10;
    while (clone != 0) {
      int lastDigit = clone  % 10;
      System.out.println(lastDigit);
      long aa = reverse * 10L + lastDigit;
      if (aa <= Integer.MAX_VALUE ) {
        reverse = (int) aa;
      } else
        reverse = 0;

      clone = clone / 10;
    }


    return sign * reverse;
  }

  public static void main(String[] args) {

    int aaa = reverse(1534236469);
    System.out.println(aaa);
  }
}