package lc.aEasy;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

// 257. Binary Tree Paths
public class BinaryTreePath {
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
}
