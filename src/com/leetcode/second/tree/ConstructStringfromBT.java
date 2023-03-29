package com.leetcode.second.tree;

public class ConstructStringfromBT {
    public String tree2str(TreeNode root) {
        return traverse(root);
    }


    private String traverse(TreeNode node) {
        if(node == null) {
            return "";
        }
        return "" + node.val + "(" +traverse(node.left) + traverse(node.right) + ")";
    }
}
