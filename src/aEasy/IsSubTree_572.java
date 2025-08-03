package aEasy;

// 572. Subtree of Another Tree
public class IsSubTree_572 {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  static boolean compare(TreeNode root, TreeNode node) {
    if (root == null && node == null) {
      return true;
    }
    if ((root == null && node != null) || (root != null && node == null)) {
      return false;
    }
    if (root.val != node.val) return false;

    boolean left = compare(root.left, node.left);
    boolean right = compare(root.right, node.right);

    return left && right;
  }

  static int getSum(TreeNode root, boolean[] matched, TreeNode subRoot, int sum) {
    if (root == null) {
      return 0;
    }
    int left = getSum(root.left, matched, subRoot, sum);
    int right = getSum(root.right, matched, subRoot, sum);
    int curr_sum = root.val + left + right;
    if (curr_sum == sum) {
      matched[0] = matched[0] || compare(root, subRoot);
    }
    return curr_sum;
  }

  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    boolean[] matched = new boolean[1];
    int sum = getSum(subRoot, matched, subRoot, -1);
    matched[0] = false;
    getSum(root, matched, subRoot, sum);
    return matched[0];
  }
}
