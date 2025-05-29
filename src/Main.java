import common.ListNode;

import java.util.*;


public class Main {
  public static int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[]{i, j};
        }
      }
    }
    return null;
  }

  public static boolean isPalindrome(String s) {
    if (s.isEmpty()) {
      return true;
    }
    s = s.toLowerCase();
    int head = 0;
    int tail = s.length() - 1;
    while (head < tail) {
      if (!Character.isLetterOrDigit(s.charAt(head))) {
        head++;
      } else if (!Character.isLetterOrDigit(s.charAt(tail))) {
        tail--;
      } else {
        if (s.charAt(head) != s.charAt(tail)) {
          return false;
        }
        head++;
        tail--;
      }
    }
    return true;
  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    ListNode sumList = null;
    ListNode currentNode = null;
    int carry = 0;

    while (l1 != null || l2 != null) {
      int sum = carry;
      if (l1 != null) {
        sum += l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        sum += l2.val;
        l2 = l2.next;
      }

      if (sum > 9) {
        carry = 1;
        sum = sum % 10;
      } else {
        carry = 0;
      }

      ListNode node = new ListNode(sum);

      if (sumList == null) {
        currentNode = sumList = node;
      } else {
        currentNode.next = node;
        currentNode = currentNode.next;
      }
    }

    if (carry != 0) {
      currentNode.next = new ListNode(carry);
    }

    return sumList;
  }

  public int maxProfit(int[] prices) {
    int profit = 0;
    int minPrice = prices[0];
    for (int price : prices) {
      minPrice = Math.min(price, minPrice);
      profit = Math.max(profit, price - minPrice);
    }
    return profit;
  }

  public static int winningCard(int[][] cards) {
    List<TreeMap<Integer, Integer>> myListTree = new ArrayList<>();

    for (int[] card : cards) {
      TreeMap<Integer, Integer> map = new TreeMap<>();
      for (int el : card) {
        map.put(el, map.getOrDefault(el, 0) + 1);
      }
      TreeMap<Integer, Integer> newMap = new TreeMap<>();
      for (var entry : map.entrySet()) {
        if (entry.getValue() == 1) {
          newMap.put(entry.getKey(), entry.getValue());
        }
      }
      myListTree.add(newMap);

    }
    int res = -1;
    for (var map : myListTree) {
      if (map.size() != 0 && map.lastEntry().getKey() > res) {
        res = map.lastEntry().getKey();
      }
    }
    return res;
  }

  public static ListNode reverseList(ListNode head) {
    ListNode newHead = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = newHead;
      newHead = head;
      head = next;
    }
    return newHead;
  }

  public static int removeDuplicates(int[] nums) {
    int index = 0;
    for (int num : nums) {
      if (index == 0 || num > nums[index - 1]) {
        nums[index++] = num;
      }
    }
    return index;
  }

  public static int mySqrt(int x) {
    int left = 0;
    int right = x;
    int mid = 0;
    while (left <= right) {
      mid = (right + left) / 2;

      if (x / mid == mid) {
        return mid;
      } else if (x / mid > mid) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return right;
  }

  public int climbStairs(int n) {
    if (n == 1) {
      return 1;
    }

    int total = 0;
    int oneStep = 1;
    int twoStep = 2;
    for (int i = 2; i < n; i++) {
      total = oneStep + twoStep;
      twoStep = oneStep;
      oneStep = total;
    }

    return total;
  }

  public static String addBinary(String a, String b) {
    StringBuilder res = new StringBuilder();
    int i = a.length() - 1;
    int j = b.length() - 1;
    int carry = 0;
    while (i >= 0 || j >= 0) {
      int sum = carry;
      if (i >= 0) sum += a.charAt(i--) - '0';
      if (j >= 0) sum += b.charAt(j--) - '0';
      carry = sum > 1 ? 1 : 0;
      res.append(sum % 2);
    }
    if (carry != 0) res.append(carry);
    return res.reverse().toString();
  }


  public static boolean isPrime(int num) {
    if (num < 2) {
      return false;
    }
    int mid = num / 2 + 1;
    for (int i = 2; i < mid; i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }


  public static void main(String[] args) {
//    System.out.println(isPrime(1));
//    System.out.println(isPrime(2));
    System.out.println(isPrime(3));
//    System.out.println(isPrime(4));
//    System.out.println(isPrime(5));

  }
}






