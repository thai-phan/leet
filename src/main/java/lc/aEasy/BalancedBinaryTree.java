package lc.aEasy;

import common.TreeNode;

public class BalancedBinaryTree {

  public static boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }
    int maxLeft = maxDepth(root.left);
    int maxRight = maxDepth(root.right);
    return Math.max(maxLeft, maxRight) + 1;
  }

  public static int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int maxLeft = maxDepth(root.left);
    int maxRight = maxDepth(root.right);
    return Math.max(maxLeft, maxRight) + 1;
  }
}
