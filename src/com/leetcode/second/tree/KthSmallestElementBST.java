package com.leetcode.second.tree;

import java.util.LinkedList;
import java.util.List;

public class KthSmallestElementBST {
    public int kthSmallest(TreeNode root, int k) {
        return 0;
    }
//        LinkedList<Integer> register = new LinkedList<>();
//        traverse(root, k, register);
//        return register.getLast();
//    }
//
//    private int traverse(TreeNode root, int k, LinkedList<Integer> register) {
//
//        traverse(root.left, k, register);
//        register.add(root.val);
//        traverse(root.right, k, register);
//    }
//
//    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3);
//        TreeNode left = new TreeNode(1);
//        left.right = new TreeNode(2);
//        root.left = left;
//        TreeNode right = new TreeNode(4);
//        root.right = right;
////        right.left = new TreeNode(5);
////        right.right = new TreeNode(8);
////        root.right = right;
//
//        int i = new KthSmallestElementBST().kthSmallest(root, 1);
//        System.out.println(i);
//    }
}
