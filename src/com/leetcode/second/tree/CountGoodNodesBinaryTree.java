package com.leetcode.second.tree;

public class CountGoodNodesBinaryTree {
    private int goodNodeCount;

    public int goodNodes(TreeNode root) {

        countGoodNode(root, root.val);
        return goodNodeCount;

    }

    private void countGoodNode(TreeNode root, int pathMax) {
        if (root == null) {
            return;
        }

        if (root.val <= pathMax) {
            this.goodNodeCount++;
        }
        int max = Math.max(root.val, pathMax);
        countGoodNode(root.left, max);
        countGoodNode(root.right, max);
    }
}
