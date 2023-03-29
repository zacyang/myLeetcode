package com.leetcode.second.tree;

public class InorderSuccessorBST {
    TreeNode pred;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {


        traverse(root, p.val);
        return pred;
    }

    private void traverse(TreeNode root, int val) {

        if (root == null) {
            return;
        }

        if (root.val >= val) {
            pred = root;
            traverse(root.left,  val);
        } else {
            traverse(root.right, val);
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
//        TreeNode left = new TreeNode(1);
//        root.left = left;
        root.right = new TreeNode(3);
        TreeNode traverse = new InorderSuccessorBST().inorderSuccessor(root, new TreeNode(2));
    }
}
