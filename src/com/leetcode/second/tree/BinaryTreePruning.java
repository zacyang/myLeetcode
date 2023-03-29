package com.leetcode.second.tree;

public class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {

        if (root == null ) {
            return null;
        }



        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);


        if(root.left == null && root.right == null && root.val!=1) {
            return null;
        }



        return root;
    }
}
