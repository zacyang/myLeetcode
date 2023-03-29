package com.leetcode.second.tree;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessBinaryTree {
    public boolean isCompleteTree(TreeNode root) {

        if (root == null) {
            return true;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        boolean nullFound = false;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node == null) {
                nullFound = true;
            } else {
                if (nullFound) {
                    return false;
                }
                q.offer(node.left);
                q.offer(node.right);
            }

        }
        return true;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        left.left = new TreeNode(4);
        left.right = new TreeNode(5);
//        right.right = new TreeNode(3);
        right.left = new TreeNode(6);
        boolean completeTree = new CheckCompletenessBinaryTree().isCompleteTree(root);
        System.out.println(completeTree);
    }
}
