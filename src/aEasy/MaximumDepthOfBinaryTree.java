package aEasy;

import dStructure.TreeNode;

public class MaximumDepthOfBinaryTree {

  public static int maxDepth(TreeNode root) {

    if (root == null) {
      return 0;
    }
    int maxLeft = maxDepth(root.left);
    int maxRight = maxDepth(root.right);
    return Math.max(maxLeft, maxRight) + 1;
  }


  public static void main(String[] args) {
    TreeNode node2 = new TreeNode(2);

    TreeNode node1 = new TreeNode(1, node2, null);

    int aaa = maxDepth(node1);

    System.out.println(aaa);

  }

}
