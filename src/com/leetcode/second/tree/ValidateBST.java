package com.leetcode.second.tree;

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return valid(root, null, null);


    }

    public boolean valid(TreeNode root, Integer low, Integer high) {
        if(root == null) {
            return true;
        }

        if(low!=null && root.val < low || high!=null && root.val > high) {
            return false;
        }

        return valid(root.left, low, root.val ) && valid(root.right, root.val, high);
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(4);
//        TreeNode right = new TreeNode(6);
//        root.right = right;
//
//        right.left = new TreeNode(3);
//        right.right = new TreeNode(7);
//

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        boolean validBST = new ValidateBST().isValidBST(root);
        System.out.println(validBST);


    }
}
