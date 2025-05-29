package medium.hack;


import java.util.NoSuchElementException;
import java.util.TreeSet;

public class TreeSetGetFirst {
  public static void main(String[] args) {
    TreeSet<Integer> numbers = new TreeSet<>();
    numbers.add(5);
    numbers.add(2);
    numbers.add(8);
    numbers.add(1);

    try {
      int firstElement = numbers.pollLast();

      int aaa = numbers.pollLast();

      System.out.println("The first element is: " + firstElement); // Output: The first element is: 1
      System.out.println("The 2 element is: " + aaa); // Output: The first element is: 1

    } catch (NoSuchElementException e) {
      System.out.println("The TreeSet is empty.");
    }

    TreeSet<String> emptySet = new TreeSet<>();
    try {
      String firstElement = emptySet.first();
    } catch (NoSuchElementException e) {
      System.out.println("The TreeSet is empty."); // Output: The TreeSet is empty.
    }
  }
}