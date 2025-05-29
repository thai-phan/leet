package miu;

public class A5 {

  static int[] a5(int[] first, int[] second) {
    if (first == null || second == null)
      return null;
    if (first.length == 0 || second.length == 0)
      return new int[0];

    int min = Math.min(first.length, second.length);
    int[] tempA, tempB;

    if (min == first.length) {
      tempA = first;
      tempB = second;
    } else {
      tempA = second;
      tempB = first;
    }
    int[] tempC = new int[min];
    int finalArraySize = 0;
    for (int i = 0; i < tempA.length; i++)
      for (int j = 0; j < tempB.length; j++)
        if (tempA[i] == tempB[j]) {
          tempC[finalArraySize] = tempA[i];
          finalArraySize++;
        }
    int[] finalArray = new int[finalArraySize];
    for (int t = 0; t < finalArray.length; t++)
      finalArray[t] = tempC[t];
    return finalArray;
  }

  public static void main(String[] args) {

    int[] first = {1, 2, 3, 9, 4};
    int[] second = {1, 2, 3, 4, 5, 6};

    int aa = second[10];
    var out = a5(first, second);
    System.out.println(out);
  }
}
