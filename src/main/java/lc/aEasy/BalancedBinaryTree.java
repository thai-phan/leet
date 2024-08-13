package lc.aEasy;

import common.TreeNode;

public class BalancedBinaryTree {

  public static boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }
    int maxLeft = maxDepth(root.left);
    int maxRight = maxDepth(root.right);
    return Math.(maxLeft, maxRight) + 1;
  }
}
