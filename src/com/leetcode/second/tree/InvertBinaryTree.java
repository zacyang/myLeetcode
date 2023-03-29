package com.leetcode.second.tree;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    //    public TreeNode invertTree(TreeNode root) {
//            if(root ==null){
//                return null;
//            }
//        TreeNode originalRight = invertTree(root.right);
//        TreeNode originalLeft = invertTree(root.left);
//        root.left = originalRight;
//        root.right = originalLeft;
//        return root;
//    }
    public TreeNode invertTree(TreeNode root) {

        if(root == null) {
            return null;
        }

        TreeNode newLeft = invertTree(root.right);
        TreeNode newRight = invertTree(root.left);
//        left become right, visversa
        root.left = newLeft;
        root.right = newRight;
        return root;
    }
//    public TreeNode invertTree(TreeNode root) {
//        if (root == null) return root;
//        Queue<TreeNode> front = new LinkedList<>();
//        front.add(root);
//
//        while(!front.isEmpty()){
//            TreeNode candidate = front.poll();
//
////            top down
//            TreeNode tmp = candidate.right;
//            candidate.right = candidate.left;
//            candidate.left = tmp;
//
//            if(candidate.left!=null) {
//                front.add(candidate.left);
//            }
//
//            if(candidate.right!=null) {
//                front.add(candidate.right);
//            }
//
//        }
//
//        return root;
//
//
//    }


}
