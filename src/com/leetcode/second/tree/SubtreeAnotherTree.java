package com.leetcode.second.tree;

public class SubtreeAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root == null) {
            return false;
        }

        if (isSameTree(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);


    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        boolean sameNode = false;
        if (p != null && q != null) {
            sameNode = p.val == q.val;
        }


        return sameNode ? isSameTree(p.left, q.left) && isSameTree(p.right, q.right) : false;
    }

}
