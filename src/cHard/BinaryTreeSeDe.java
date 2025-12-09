package cHard;

import java.util.Arrays;

public class BinaryTreeSeDe {
  public static void main(String[] args) {
    TreeNode node11 = new TreeNode(11);
    TreeNode node10 = new TreeNode(10);
    TreeNode node9 = new TreeNode(9);
    TreeNode node8 = new TreeNode(8, node11, null);
    TreeNode node7 = new TreeNode(7, null, node10);
    TreeNode node6 = new TreeNode(6, null, node9);
    TreeNode node5 = new TreeNode(5, null, node8);
    TreeNode node4 = new TreeNode(4, node6, node7);
    TreeNode node3 = new TreeNode(3, node4, node5);
    TreeNode node2 = new TreeNode(2);
    TreeNode node1 = new TreeNode(1, node2, node3);


    BinaryTreeSeDe ser = new BinaryTreeSeDe();
    BinaryTreeSeDe deser = new BinaryTreeSeDe();
    TreeNode ans = deser.deserialize(ser.serialize(node1));
    System.out.println("Root value: " + ans.val); // Output the root value to verify
  }

  int max = 0;

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    int[] arr = new int[10000];
    Arrays.fill(arr, Integer.MAX_VALUE);
    loop(root, 1, arr);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i <= max; i++) {
      if (arr[i] == Integer.MIN_VALUE) {
        sb.append("null");
        sb.append(',');
      }
      if (arr[i] >= -1000 && arr[i] <= 1000) {
        sb.append(arr[i]);
        sb.append(',');
      }

    }

    return sb.toString();
  }

  public void loop(TreeNode node, int id, int[] arr) {
    if (node == null) {
      arr[id] = Integer.MIN_VALUE;
      return;
    }
    arr[id] = node.val;
    max = Math.max(max, id);
    loop(node.left, id * 2, arr);
    loop(node.right, id * 2 + 1, arr);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    System.out.println(data);
    data = "4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2";
    String[] strArr = data.split(",");

    String[] full = new String[10000];

    for (int i = 0; i < strArr.length; i++) {
      if (strArr[i].isEmpty()) {
        full[i] = "null";
      } else {
        full[i] = strArr[i];
      }
    }
    int idx = 0;

    while (full[idx] != null) {
      if (full[idx].equals("null")) {
        String left = full[idx * 2 + 1];
        if (left != null && !left.equals("null")) {
          shipOne(full, idx * 2 + 1, left);
          full[idx * 2 + 1] = "null";
        }
        String right = full[idx * 2 + 2];
        if (right != null && !right.equals("null")) {
          shipOne(full, idx * 2 + 2, right);
          full[idx * 2 + 2] = "null";
        }
      }
      idx++;
    }

    return deLoop(0, full, idx);
  }

  public void shipOne(String[] arr, int id, String val) {
    String temp = "";
    while (arr[id] != null) {
      temp = arr[id + 1];
      arr[id + 1] = val;
      val = temp;
      id++;
    }
  }


  int minus = 0;

  public TreeNode deLoop(int id, String[] strArr, int max) {
    if (id >= max) {
      System.out.println("id " + id);
      return null;
    }
    if (strArr[id].equals("null")) {
      minus += 2;
      return null;
    }
    int val = Integer.parseInt(strArr[id]);
    TreeNode node = new TreeNode(val);
    node.left = deLoop(id * 2 + 1, strArr, max);
    node.right = deLoop(id * 2 + 2, strArr, max);
    return node;

  }

}