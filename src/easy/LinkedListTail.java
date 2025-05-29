package easy;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class LinkedListTail {

  static class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
      this.data = nodeData;
      this.next = null;
    }
  }

  static class SinglyLinkedList {
    public SinglyLinkedListNode head;

    public SinglyLinkedList() {
      this.head = null;
    }


  }

  public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep) {
    while (node != null) {
      System.out.println(node.data);
//      bufferedWriter.write(String.valueOf(node.data));

      node = node.next;

//      if (node != null) {
//        System.out.println(sep);

//        bufferedWriter.write(sep);
//      }
    }
  }

  // Complete the insertNodeAtTail function below.

  /*
   * For your reference:
   *
   * SinglyLinkedListNode {
   *     int data;
   *     SinglyLinkedListNode next;
   * }
   *
   */

  static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
    SinglyLinkedListNode node = new SinglyLinkedListNode(data);
    // SinglyLinkedListNode newHead = new SinglyLinkedListNode(head.data);
    if (head == null) {
      head = node;
      return head;
    }
    SinglyLinkedListNode temp = head.next;
    if (temp == null) {
      head.next = node;
      return head;
    }
    while (temp != null && temp.next != null) {
      temp = temp.next;
    }
    temp.next = node;
    return head;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
//    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    SinglyLinkedList llist = new SinglyLinkedList();

//    int llistCount = scanner.nextInt();
//    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    var list = List.of(141, 302, 164, 530, 474);


    for (int llistItem : list) {
//      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      SinglyLinkedListNode llist_head = insertNodeAtTail(llist.head, llistItem);

      llist.head = llist_head;
    }


    printSinglyLinkedList(llist.head, "\n");
//    bufferedWriter.newLine();

//    bufferedWriter.close();

    scanner.close();
  }
}
