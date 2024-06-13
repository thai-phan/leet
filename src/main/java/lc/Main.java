package lc;

import lc.data.TreeNode;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


public class Main {
    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
//        int[][] cards = {{5, 7, 3, 9, 4, 9, 8, 3, 1}, {1, 2, 2, 4, 4, 1}, {1, 2, 3}};
//        isPalindrome(s);

        ListNode a1 = new ListNode(6);
        ListNode a2 = new ListNode(5, a1);
        ListNode a3 = new ListNode(4, a2);
        ListNode b1 = new ListNode(3, a3);
        ListNode b2 = new ListNode(2, b1);
        ListNode b3 = new ListNode(1, b2);
//
//        reverseList( b3);

        int[] fruits = {1, 1, 2};
//        totalFruit(fruits);

//        removeDuplicates(fruits);

//        mySqrt(2147395600);

        addBinary("1111", "11");
    }

    public static boolean isValid(String s) {
        boolean result = false;
        Map<Character, Character> myMap = new HashMap<>();
        myMap.put('{', '}');
        myMap.put('[', ']');
        myMap.put('(', ')');
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 && !myMap.containsKey(arr[i])) {
                return false;
            }
            if (myMap.containsKey(arr[i])) {
                stack.push(arr[i]);
            } else if (stack.size() != 0 && !myMap.containsKey(arr[i]) && myMap.get(stack.peek()) == arr[i]) {
                stack.pop();
            } else {
                return false;
            }

        }
        return stack.isEmpty();
    }

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

    public static int lengthOfLongestSubstring(String s) {
        int strLen = 0;
        char[] chars = s.toCharArray();
        if (chars.length == 1) {
            return 1;
        }
        for (int i = 0; i < chars.length; i++) {
            Set<Character> tempSet = new HashSet<>();
            int count = i;
            while (count < chars.length && !tempSet.contains(chars[count])) {
                tempSet.add(chars[count]);
                count = count + 1;
            }
            if (tempSet.size() > strLen) {
                strLen = tempSet.size();
            }
        }
        return strLen;
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int sum = 0;
        int count = 0;
        char[] chars = s.toCharArray();
        while (count < chars.length) {
            if (count < chars.length - 1) {
                if (chars[count] == 'I' && chars[count + 1] == 'V') {
                    sum += 4;
                    count += 2;
                    continue;
                } else if (chars[count] == 'I' && chars[count + 1] == 'X') {
                    sum += 9;
                    count += 2;
                    continue;
                } else if (chars[count] == 'X' && chars[count + 1] == 'L') {
                    sum += 40;
                    count += 2;
                    continue;
                } else if (chars[count] == 'X' && chars[count + 1] == 'C') {
                    sum += 90;
                    count += 2;
                    continue;
                } else if (chars[count] == 'C' && chars[count + 1] == 'D') {
                    sum += 400;
                    count += 2;
                    continue;
                } else if (chars[count] == 'C' && chars[count + 1] == 'M') {
                    sum += 900;
                    count += 2;
                    continue;
                }
            }
            sum += map.get(chars[count]);
        }
        return sum;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        double median;
        for (Integer t : nums1) {
            // Add each element into the list
            list.add(t);
        }
        for (Integer t : nums2) {
            // Add each element into the list
            list.add(t);
        }
        Collections.sort(list);
        if (list.size() % 2 == 1) {
            int mid = (list.size() / 2);
            median = (double) list.get(mid);
        } else {
            int mid = (list.size() / 2);
            median = ((double) list.get(mid) + (double) list.get(mid - 1)) / 2;
        }
        return median;
    }

    public double _findMedianSortedArrays(int[] nums1, int[] nums2) {
        return 0.0;
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root.left == null && root.right == null) {
            list.add(String.valueOf(root.val));
            return list;
        }
        if (root.left != null) {
            StringBuilder thisVal = new StringBuilder(String.valueOf(root.val));
            thisVal.append("->");
            binaryTreePaths(root.left).forEach(el -> {
                StringBuilder str = new StringBuilder(thisVal);
                str.append(el);
                list.add(str.toString());
            });
        }
        if (root.right != null) {
            StringBuilder thisVal = new StringBuilder(String.valueOf(root.val));
            thisVal.append("->");
            binaryTreePaths(root.right).forEach(el -> {
                StringBuilder str = new StringBuilder(thisVal);
                str.append(el);
                list.add(str.toString());
            });
        }

        return list;
    }

    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (target == nums[middle]) {
                return middle;
            }
            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            }
        }
        return -1;
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

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public static int _totalFruit(int[] fruits) {
        int maxFruit = 0;
        AtomicInteger atomicInteger = new AtomicInteger();

        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int fruit : fruits) {
            if (queue.size() < 2 && !queue.contains(fruit)) {
                queue.add(fruit);
                map.put(fruit, 1);
            } else {
                if (!queue.contains(fruit)) {
                    queue.add(fruit);
                    int temp = queue.remove();
                    map.remove(temp);
                    map.put(fruit, 1);
                } else {
                    map.replace(fruit, map.get(fruit) + 1);
                }
            }
            atomicInteger.set(0);
            queue.forEach(num -> atomicInteger.set(atomicInteger.get() + map.get(num)));
            if (atomicInteger.get() > maxFruit) {
                maxFruit = atomicInteger.get();
            }
        }

        return maxFruit;
    }

    public static int __totalFruit(int[] fruits) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        int res = 0, i = 0;
        for (int j = 0; j < fruits.length; ++j) {
            count.put(fruits[j], count.getOrDefault(fruits[j], 0) + 1);
            while (count.size() > 2) {
                count.put(fruits[i], count.get(fruits[i]) - 1);
                if (count.get(fruits[i]) == 0) count.remove(fruits[i]);
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }

    public static int totalFruit(int[] fruits) {
        if (fruits.length == 1) {
            return 1;
        }
        int left = 0;
        int res = 0;
        int[] currFr = new int[]{fruits[0], -1};
        for (int right = 1; right < fruits.length; ++right) {
            int fr = fruits[right];
            if (fr != currFr[0] && fr != currFr[1]) {
                if (currFr[1] == -1) {
                    currFr[1] = fr;
                    continue;
                }
                res = Math.max(res, right - left);
                int prevFr = fruits[right - 1];
                left = right - 1;
                while (fruits[left - 1] == prevFr) {
                    left--;
                }
                currFr[0] = prevFr;
                currFr[1] = fr;
            }
        }
        return Math.max(fruits.length - left, res);
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
        while(i >= 0 || j >= 0){
            int sum = carry;
            if(i >= 0) sum += a.charAt(i--) - '0';
            if(j >= 0) sum += b.charAt(j--) - '0';
            carry = sum > 1 ? 1 : 0;
            res.append(sum % 2);
        }
        if(carry != 0) res.append(carry);
        return res.reverse().toString();
    }
}


class Foo {
    private Object lock;
    private AtomicInteger counter;

    public Foo() {
        this.lock = new Object();
        this.counter = new AtomicInteger(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        synchronized (lock) {
            printFirst.run();
            this.counter.incrementAndGet();
            this.lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // printSecond.run() outputs "second". Do not change or remove this line.
        synchronized (lock) {
            while (this.counter.get() != 1) {
                this.lock.wait();
            }
            printSecond.run();
            this.counter.incrementAndGet();
            this.lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        // printThird.run() outputs "third". Do not change or remove this line.
        synchronized (lock) {
            while (this.counter.get() != 2) {
                this.lock.wait();
            }
            printThird.run();
        }
    }
}


class ListNode {
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
