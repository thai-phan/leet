package bMedium;

public class CowGirl {


  public static void main(String[] args) {
    int[] arr1 = {0, 0, 0, 1, 1};
    int[] arr2 = {0, 0, 1, 1, 1};
//    int result = check(arr1, arr2);
//    System.out.println("result = " + result);
  }

//  public static int count() {

//  }

  public static int func(int[] arr1, int[] arr2) {
    int count = 0;
    for (int i = 0; i < arr1.length-1; i++) {
      if ((arr1[i] ^ arr2[i] ^ arr1[i + 1] ^ arr2[i + 1]) == 0) {
        count++;
      }
    }
    return count;
  }

//  public static boolean check(int i, int j) {
//  }

}
