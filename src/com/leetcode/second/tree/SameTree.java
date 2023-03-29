package com.leetcode.second.tree;

public class SameTree {
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        if (p == null && q == null) {
//            return true;
//        }
//        boolean sameNode = false;
//        if (p != null && q != null) {
//            sameNode = p.val == q.val;
//        }
//
//
//        return sameNode ? isSameTree(p.left, q.left) && isSameTree(p.right, q.right) : false;
//    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q == null) {
            return true;
        }
        boolean sameNode = false;
        if(p.val == q.val) {
            sameNode = true;
        }

        return sameNode? isSameTree(p.left, q.left) && isSameTree(p.right, q.right) :false;
    }
}
