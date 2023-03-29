package com.leetcode.second.tree;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {

        return isMirrorTree(root.left, root.right);

    }

    private boolean isMirrorTree(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        else if (left.val == right.val) {
            return isMirrorTree(left.left, right.right) && isMirrorTree(left.right, right.left);
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        left.left = new TreeNode(3);
        left.right = new TreeNode(4);
        root.left = left;

        TreeNode right = new TreeNode(2);
        right.right = new TreeNode(3);
        right.left = new TreeNode(4);
        root.right = right;
        boolean symmetric = new SymmetricTree().isSymmetric(root);
        System.out.println(symmetric);
    }
}
