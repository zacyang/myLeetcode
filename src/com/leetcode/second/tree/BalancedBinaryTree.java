package com.leetcode.second.tree;

import java.util.HashMap;
import java.util.Map;

class TreeMeta {
    int treeDepth;
    boolean balanced;

    public TreeMeta(int treeDepth, boolean balanced) {
        this.treeDepth = treeDepth;
        this.balanced = balanced;
    }
}

public class BalancedBinaryTree {
    Map<TreeNode, Integer> register = new HashMap<>();
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;

        }

        boolean isBalanced = Math.abs(height(root.left) - height(root.right)) <= 1;

        return isBalanced && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root) {

        if(root == null){
            return 0;
        }
        int height = Math.max(height(root.left), height(root.right));
        return height+1;
    }


//    TreeMeta treeCheck(TreeNode node) {
//        if(node == null) {
//            return new TreeMeta(-1, true);
//        }
//        TreeMeta left = treeCheck(node.left);
//        if (!left.balanced) {
//            return new TreeMeta(-1, false);
//        }
//
//        TreeMeta right = treeCheck(node.right);
//        if (!right.balanced) {
//            return new TreeMeta(-1, false);
//        }
//
//
//        if (Math.abs(left.treeDepth - right.treeDepth) < 2) {
//            return new TreeMeta(Math.max(left.treeDepth, right.treeDepth) + 1, true);
//        }
//
//        return new TreeMeta(-1, false);
//    }
//
//    public boolean isBalanced(TreeNode root) {
//        TreeMeta treeMeta = treeCheck(root);
//        return treeMeta.balanced;
//    }

}
