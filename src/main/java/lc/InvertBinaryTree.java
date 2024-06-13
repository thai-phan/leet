package lc;


import lc.data.TreeNode;

public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(6);
        TreeNode t4 = new TreeNode(9);

        TreeNode t6 = new TreeNode(2, t1, t2);
        TreeNode t7 = new TreeNode(7, t3, t4);

        TreeNode t = new TreeNode(4, t6, t7);

        invertTree(t6);
    }


    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        final TreeNode left = root.left;
        final TreeNode right = root.right;
        root.right = invertTree(left);
        root.left = invertTree(right);
        return root;
    }
}
