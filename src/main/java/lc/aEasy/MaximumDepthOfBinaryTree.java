package lc.aEasy;

import common.TreeNode;

public class MaximumDepthOfBinaryTree {

  public static int maxDepth(TreeNode root) {

    TreeNode node = root;
    int depth = 1;

    if (root == null) {
      return 0;
    }

    if (node.left == null && node.right == null) {
      return depth;
    }

    while (node.left != null ) {
      node = node.left;
      depth++;
    }

    return depth;

  }

  public static void main(String[] args) {
    TreeNode node2 = new TreeNode(2);

    TreeNode node1 = new TreeNode(1, node2, null);

    int aaa = maxDepth(node1);

    System.out.println(aaa);

  }

}
