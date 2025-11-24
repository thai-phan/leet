package bMedium;

import java.util.HashMap;
import java.util.Map;

public class BuildTreeMap {

  public static void main(String[] args) {

    int[] preorder = {3, 9, 20, 1, 2, 15, 7};
    int[] inorder = {1, 9, 2, 3, 15, 20, 7};
    BuildTreeMap solution = new BuildTreeMap();
    TreeNode root = solution.buildTree(preorder, inorder);
    System.out.println("Root value: " + root.val); // Output the root value to verify
  }

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

  int preorderIndex;
  Map<Integer, Integer> inorderIndexMap;

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    preorderIndex = 0;
    // build a hashmap to store value -> its index relations
    inorderIndexMap = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      inorderIndexMap.put(inorder[i], i);
    }
    TreeNode root = arrayToTree(preorder, 0, preorder.length - 1);
    return root;
  }

  private TreeNode arrayToTree(int[] preorder, int left, int right) {
    // if there are no elements to construct the tree
    if (left > right) return null;

    // select the preorder_index element as the root and increment it
    int rootValue = preorder[preorderIndex];
    preorderIndex = preorderIndex + 1;

    TreeNode root = new TreeNode(rootValue);

    root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue) - 1);
    root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue) + 1, right);
    return root;
  }
}
