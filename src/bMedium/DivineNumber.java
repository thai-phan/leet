package bMedium;

public class DivineNumber {
  public static void main(String[] args) {

    DivineNumber solution = new DivineNumber();
    int result = solution.divide(-1010369383, -2147483648);
    long aaa = (long) Math.pow(2, 31);
    int bbb = (int) Math.pow(2, 31);

    System.out.println("result = " + result);

  }
  public int divide(int dividend, int divisor) {

    boolean isSame = Math.signum(dividend) == Math.signum(divisor);

    long out = 0;
    long dd = dividend;
    long dividendL = Math.abs(dd);
    long dvs = divisor;
    long divisorL = Math.abs(dvs);

    while (dividendL >= divisorL) {

      long subSum = divisorL;
      long subCount = 1;

      while (subSum + subSum <= dividendL) {
        subSum = subSum + subSum;
        subCount = subCount + subCount;
      }

      dividendL = dividendL - subSum;
      out += subCount;
    }
    out = isSame ? out : -out;
    if (out > Math.pow(2, 31) - 1) {
      return (int) (Math.pow(2, 31) - 1);
    }
    if (out < -Math.pow(2, 31)) {
      return (int) -Math.pow(2, 31);
    }

    return (int) out;
  }
}
