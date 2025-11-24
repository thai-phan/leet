package bMedium;

public class LListManipulate {

  public static void main(String[] args) {
    LListManipulate solution = new LListManipulate();

    ListNode l6 = new ListNode(6);
    ListNode l5 = new ListNode(5, l6);
    ListNode l4 = new ListNode(4, l5);
    ListNode l3 = new ListNode(3, l4);
    ListNode l2 = new ListNode(2, l3);
    ListNode head = new ListNode(1, l2);

    solution.reorderList(head);

    ListNode current = head;
    while (current != null) {
      System.out.print(current.val + " ");
      current = current.next;
    }
  }

  static class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public void reorderList(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next!=null) {
      slow = slow.next;
      System.out.println(fast.val);
      fast = fast.next.next;
    }

    ListNode acc = null;
    while(slow != null) {
      ListNode temp = slow.next;
      slow.next = acc;
      acc = slow;
      slow = temp;
    }

    ListNode node = head;
    while (acc.next != null) {
      ListNode temp1 = node.next;
      ListNode temp2 = acc.next;

      node.next = acc;
      acc.next = temp1;

      acc = temp2;
      node = temp1;
    }

//    System.out.println("Midpoint at value: " + slow.val);
  }
}
