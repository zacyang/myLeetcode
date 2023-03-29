package com.leetcode.second.tree;

public class LowestCommonAncestorBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int high = Math.max(p.val, q.val);
        int low = Math.min(p.val, q.val);

        if(root.val <= high && root.val >= low) {
            return root;
        }

        if(root.val > high) {
            return  lowestCommonAncestor(root.left, p, q);
        } else if(root.val < low) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return null;
    }
}
