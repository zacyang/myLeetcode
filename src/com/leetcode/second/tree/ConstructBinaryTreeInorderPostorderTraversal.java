package com.leetcode.second.tree;

import java.util.HashMap;
import java.util.Stack;

public class ConstructBinaryTreeInorderPostorderTraversal {
//    public TreeNode buildTree(int[] inorder, int[] postorder) {
//
//
//        return buildTreeFromArray(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
//    }
//
//    private TreeNode buildTreeFromArray(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
//
//        if (inStart > inEnd || postStart > postEnd) {
//
//            return null;
//        }
//
//        int rootVal = postorder[postEnd];
////        TODO: check end condition
//
//
//        TreeNode treeNode = new TreeNode(rootVal);
//
//        int rootIdxInOrder = locateIdxOf(rootVal, inorder, inStart, inEnd);
//        int postEndForLeft = -1;
//        if(rootIdxInOrder > 0) {
//            postEndForLeft = locateIdxOf(inorder[rootIdxInOrder - 1], postorder, postStart, postEnd);
//
//
//            treeNode.left = buildTreeFromArray(inorder, inStart, rootIdxInOrder - 1, postorder, postStart, postEndForLeft);
//        }
//
//
//
//        treeNode.right = buildTreeFromArray(inorder, rootIdxInOrder + 1, inEnd, postorder, postEndForLeft + 1, postEnd - 1);
//        return treeNode;
//    }
//
//    private int locateIdxOf(int val, int[] arrayPresentation, int start, int end) {
//
//        for (int i = start; i <= end; i++) {
//            if (arrayPresentation[i] == val) {
//                return i;
//            }
//        }
//        return -1;
//    }


    HashMap<Integer, Integer> idxRegi = new HashMap<>();

    public TreeNode helper(int in_left, int in_right, Stack<Integer> stack) {
        // if there is no elements to construct subtrees
        if (in_left > in_right)
            return null;

        // pick up post_idx element as a root
        int root_val = stack.pop();
        TreeNode root = new TreeNode(root_val);

        // root splits inorder list
        // into left and right subtrees
        int index = idxRegi.get(root_val);

        // build right subtree
        root.right = helper(index + 1, in_right, stack);
        // build left subtree
        root.left = helper(in_left, index - 1, stack);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {


        Stack<Integer> stack = new Stack<>();
        for (int val : postorder) {
            stack.add(val);
        }


        // build a hashmap value -> its index
        int idx = 0;
        for (Integer val : inorder)
            idxRegi.put(val, idx++);
        return helper(0, inorder.length - 1, stack);
    }
    public static void main(String[] args) {
//        TreeNode treeNode = new ConstructBinaryTreeInorderPostorderTraversal().buildTree(new int[]{9, 3, 15, 20, 7},
//                new int[]{9, 15, 7, 20, 3});

        TreeNode treeNode = new ConstructBinaryTreeInorderPostorderTraversal().buildTree(new int[]{2,1},
                new int[]{2,1});

//        TreeNode treeNode = new ConstructBinaryTreeInorderPostorderTraversal().buildTree(new int[]{1,2  },
//                new int[]{2,1});


        System.out.println(treeNode);
    }
}
