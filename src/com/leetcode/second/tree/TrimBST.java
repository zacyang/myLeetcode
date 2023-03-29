package com.leetcode.second.tree;

public class TrimBST {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) {
            return null;
        }
        if(root.val < low ){
//            ditch left sub tree
            return trimBST(root.right, low, high);
        }

        if(root.val > high) {
            return trimBST(root.left, low, high);
        }

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
