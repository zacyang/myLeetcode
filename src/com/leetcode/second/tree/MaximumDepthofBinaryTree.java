package com.leetcode.second.tree;

import static java.lang.Math.max;

public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        return traverse(root, 0);
    }

    private int traverse(TreeNode node, int i) {
        if(node==null) {
            return i;
        }
        int depthLeft = traverse(node.left, i + 1);
        int depthRight = traverse(node.right, i+1);

        return max(depthRight, depthLeft);
    }
}
