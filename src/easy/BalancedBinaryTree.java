package easy;

import common.TreeNode;

class IsBalanceClass {

  private boolean isBalance = true;

  public boolean isBalanced(TreeNode root) {
    maxDepth(root);
    return isBalance;
  }

  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int maxLeft = maxDepth(root.left);
    int maxRight = maxDepth(root.right);
    if (Math.abs(maxLeft - maxRight) > 1) {
      isBalance = false;
    }
    return Math.max(maxLeft, maxRight) + 1;
  }
}

public class BalancedBinaryTree {
  public static void main(String[] args) {
    IsBalanceClass isBalanceClass = new IsBalanceClass();
    TreeNode node2 = new TreeNode(2);

//    TreeNode node1 = new TreeNode(1, node2, null);


    var aaa = isBalanceClass.isBalanced(null);

    System.out.println(aaa);

  }
}