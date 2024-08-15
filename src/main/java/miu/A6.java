package miu;

public class A6 {
  static int a6(int[] a)
  {
    if (a.length < 3) return -1;
    int i = 0;
    int j = a.length - 1;
    int idx = 1;
    int leftSum = a[i];
    int rightSum = a[j];
    for (int k = 1; k < a.length - 2; k++)
    {
      if (leftSum < rightSum)
      {
        i++;
        leftSum += a[i];
        idx = i + 1;
      }
      else
      {
        j--;
        rightSum += a[j];
        idx = j - 1;
      }
    }
    if (leftSum == rightSum)
      return idx;
    else
      return -1;
  }
}
