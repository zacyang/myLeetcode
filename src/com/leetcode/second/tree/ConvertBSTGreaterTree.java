package com.leetcode.second.tree;

import java.util.ArrayList;
import java.util.List;

public class ConvertBSTGreaterTree {
//    public TreeNode convertBST(TreeNode root) {
//        TreeNode originalRoot = root;
//
////        flatten BST
//        List<TreeNode> inorderResult = new ArrayList<>();
//        inorderTraverse(root, inorderResult);
//
////        update the result val where from the last -> first, val += result[i+1] + currentVal;
//        for (int i = inorderResult.size() - 2; i >= 0; i--) {
//
//            inorderResult.get(i).val += inorderResult.get(i + 1).val;
//        }
//
//        return originalRoot;
//    }
//
//    private void inorderTraverse(TreeNode root, List<TreeNode> inorderResult) {
//        if(root == null) {
//            return;
//        }
//
//        inorderTraverse(root.left, inorderResult);
//        inorderResult.add(root);
//        inorderTraverse(root.right, inorderResult);
//    }

    private int currentSum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        currentSum += root.val;
        root.val = currentSum;
        convertBST(root.left);
        return root;

    }

}
