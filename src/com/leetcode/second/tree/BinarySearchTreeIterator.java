package com.leetcode.second.tree;

import java.util.*;

public class BinarySearchTreeIterator {
    private Stack<TreeNode> stack;

    public BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<>();
        this.topLeftElment(root);
    }

    private void topLeftElment(TreeNode root) {
        while(root!=null) {
            stack.add(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode smallerNode = stack.pop();
        if(smallerNode.right !=null) {
            topLeftElment(smallerNode.right);
        }
        return smallerNode.val;
    }

    public boolean hasNext() {
        return !this.stack.isEmpty();
    }

}
