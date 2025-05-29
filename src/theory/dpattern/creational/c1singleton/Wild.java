package theory.dpattern.creational.c1singleton;

public class Wild {
  public static class Sum {
    public int sum(int a, int b) {
      return a + b;
    }
  }

  public static class sumAll {
    public int sum(int a, int b) {
      final int result = a + b;
      final SumStorage sumStorage = new SumStorage();
      sumStorage.store(result);
      return result;
    }
  }

  public static class SumStorage {
    public void store(int sumResult) {}
  }

  public static void main(String[] args) {
    final Sum sum = new Sum();
    final SumStorage sumStorage = new SumStorage();
    sumStorage.store(sum.sum(1, 2));

    final sumAll sumAll = new sumAll();
    sumAll.sum(1, 2);
  }
}


