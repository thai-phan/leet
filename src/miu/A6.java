package miu;

public class A6 {
  static int a6(int[] intArray) {
    if (intArray.length < 3) {
      return -1;
    }
    int leftIndex = 0;
    int rightIndex = intArray.length - 1;
    int currentIndex = 1;
    int leftSum = intArray[leftIndex];
    int rightSum = intArray[rightIndex];
    for (int k = 1; k < intArray.length - 2; k++) {
      if (leftSum < rightSum) {
        leftIndex++;
        leftSum += intArray[leftIndex];
        currentIndex = leftIndex + 1;
      } else {
        rightIndex--;
        rightSum += intArray[rightIndex];
        currentIndex = rightIndex - 1;
      }
    }
    if (leftSum == rightSum) {
      return currentIndex;
    }
    else {
      return -1;
    }
  }
}
