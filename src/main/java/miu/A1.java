package miu;

public class A1 {

  static int a1(int[] a) {
    if (a == null || a.length % 2 == 0) return 0;
    int midIndex = a.length / 2;
    int middleItem = a[midIndex];
    for (int i = 0; i < a.length; i++) {
      if (i != midIndex && middleItem >= a[i]) return 0;
    }
    return 1;
  }
}
