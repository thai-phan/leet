package lc.aEasy;

import common.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

// 100. Same Tree
public class SameTree_100 {

  public static boolean isSameTree(TreeNode p, TreeNode q, AtomicInteger count) {
    if (p != null) {
      System.out.println(p.val);
    } else {
      System.out.println("p = null");
    }

    if (q != null) {
      System.out.println(q.val);
    } else {
      System.out.println("q = null");
    }
    System.out.println("node checking");
    System.out.println(count);
    count.addAndGet(1);
    if (p == null && q == null) {
      return true;
    }

    // If only one tree is null or the values are different, they are not identical
    if (p == null || q == null || p.val != q.val) {
      return false;
    }
    // Recursively check if the left and right subtrees are identical
    return isSameTree(p.left, q.left, count) && isSameTree(p.right, q.right, count);
  }

  public static void main(String[] args) {
    TreeNode t1 = new TreeNode(1);
    TreeNode t2 = new TreeNode(2);

    TreeNode t3 = new TreeNode(1);
    TreeNode t4 = new TreeNode(2);

    TreeNode t5 = new TreeNode(3, t1, t2);
    TreeNode t6 = new TreeNode(3, t3, t4);
    AtomicInteger count = new AtomicInteger(0);
    var aaa = isSameTree(t6, t5, count);
    System.out.println(count);
    System.out.println(aaa);
  }

}