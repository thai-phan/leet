package cHard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;



public class BinaryTreeSolution_97 {
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


    BinaryTreeSolution_97 ser = new BinaryTreeSolution_97();
    BinaryTreeSolution_97 deser = new BinaryTreeSolution_97();
    TreeNode ans = deser.deserialize(ser.serialize(node1));
    System.out.println("Root value: " + ans.val); // Output the root value to verify
  }



  public String serialize(TreeNode root) {
    return rserialize(root, "");
  }

  // Encodes a tree to a single string.
  // Serialization
  public String rserialize(TreeNode root, String str) {
    // Recursive serialization.
    if (root == null) {
      str += "null,";
    } else {
      str += root.val + ",";
      str = rserialize(root.left, str);
      str = rserialize(root.right, str);
    }
    return str;
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    String[] data_array = data.split(",");
    List<String> data_list = new LinkedList<>(Arrays.asList(data_array));
    return rdeserialize(data_list);
  }


  public TreeNode rdeserialize(List<String> l) {
    // Recursive deserialization.
    if (l.getFirst().equals("null")) {
      l.removeFirst();
      return null;
    }

    TreeNode root = new TreeNode(Integer.parseInt(l.getFirst()));
    l.removeFirst();
    root.left = rdeserialize(l);
    root.right = rdeserialize(l);

    return root;
  }
}
