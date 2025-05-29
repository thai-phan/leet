package aEasy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

class SinglyLinkedListNode {
  public int data;
  public SinglyLinkedListNode next;

  public SinglyLinkedListNode(int nodeData) {
    this.data = nodeData;
    this.next = null;
  }
}

class SinglyLinkedList {
  public SinglyLinkedListNode head;
  public SinglyLinkedListNode tail;

  public SinglyLinkedList() {
    this.head = null;
    this.tail = null;
  }

  public void insertNode(int nodeData) {
    SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

    if (this.head == null) {
      this.head = node;
    } else {
      this.tail.next = node;
    }

    this.tail = node;
  }
}

class SinglyLinkedListPrintHelper {
  public static void printList(SinglyLinkedListNode node, String sep) throws IOException {
    while (node != null) {
      System.out.println(node.data);
//      bufferedWriter.write(String.valueOf(node.data));

      node = node.next;

      if (node != null) {
        System.out.println(sep);

//        bufferedWriter.write(sep);
      }
    }
  }
}

class Result {

  /*
   * Complete the 'reverse' function below.
   *
   * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
   * The function accepts INTEGER_SINGLY_LINKED_LIST llist as parameter.
   */

  /*
   * For your reference:
   *
   * SinglyLinkedListNode {
   *     int data;
   *     SinglyLinkedListNode next;
   * }
   *
   */

  public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
    // Write your code here
    SinglyLinkedListNode node = llist;
    if (node == null) {
      return null;
    }

    SinglyLinkedListNode preNode = null;

    while (node.next != null) {
      SinglyLinkedListNode tempNode = preNode;
      preNode = node;
      node = node.next;
      preNode.next = tempNode;
    }

    node.next = preNode;

    return node;
  }

}

public class ReverseLL {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int tests = Integer.parseInt(bufferedReader.readLine().trim());

    IntStream.range(0, tests).forEach(testsItr -> {
      try {
        SinglyLinkedList llist = new SinglyLinkedList();

        int llistCount = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, llistCount).forEach(i -> {
          try {
            int llistItem = Integer.parseInt(bufferedReader.readLine().trim());

            llist.insertNode(llistItem);
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        });

        SinglyLinkedListNode llist1 = Result.reverse(llist.head);

        SinglyLinkedListPrintHelper.printList(llist1, " ");
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    bufferedReader.close();
  }
}
