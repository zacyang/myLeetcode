package com.leetcode.second.tree;

public class DiameterBinaryTree {
    int currentMax = 0;
    public int diameterOfBinaryTree(TreeNode root) {

        diameter(root);
        return currentMax;
    }


    public int diameter(TreeNode root) {
        if(root == null) {
            return 0;
        } else {
            int left = diameter(root.left);
            int right = diameter(root.right);

            currentMax = Math.max(currentMax, left+ right);

            return Math.max(left, right) +1;
        }
    }

}
