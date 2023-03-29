package com.leetcode.second.tree;

public class ConstructStringFromBST {
    public String tree2str(TreeNode root) {
        StringBuilder result = new StringBuilder();
        preOrderTraver(root, result);
        return result.toString();
    }

    private void preOrderTraver(TreeNode root, StringBuilder result) {
        if (root == null) {
            return;
        }

        result.append(root.val);

        if (root.left != null || root.right != null) {
            result.append("(");
            preOrderTraver(root.left, result);
            result.append(")");
        }


        if (root.right != null) {
            result.append("(");
            preOrderTraver(root.right, result);
            result.append(")");
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        left.right = new TreeNode(4);
        root.left = left;
        root.right = right;

        String s = new ConstructStringFromBST().tree2str(root);
        System.out.println(s);

    }
}
