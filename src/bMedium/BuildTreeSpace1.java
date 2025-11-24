package bMedium;

public class BuildTreeSpace1 {

  int[] preorder;
  int[] inorder;

  public static void main(String[] args) {
    BuildTreeSpace1 solution = new BuildTreeSpace1();
    int[] preorder = {3, 9, 1, 2, 20, 15, 7};
    int[] inorder = {1, 9, 2, 3, 15, 20, 7};
    TreeNode root = solution.buildTree(preorder, inorder);
    System.out.println("Tree built successfully.");
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  TreeNode buildTree(int[] preorder, int[] inorder) {
    this.preorder = preorder;
    this.inorder = inorder;
    return build(Integer.MIN_VALUE);
  }

  int i = 0;
  int p = 0;

  TreeNode build(int stop) {
    if (p >= preorder.length) {
      return null;
    }
    int pVal = preorder[p];
    int iVal = inorder[i];
    System.out.println(pVal + "|" + iVal + "|" + stop);

    if (iVal == stop) {
      i++;
      return null;
    }

    TreeNode node = new TreeNode(pVal);
    p++;
    node.left = build(node.val);
    node.right = build(stop);
    return node;
  }
}
