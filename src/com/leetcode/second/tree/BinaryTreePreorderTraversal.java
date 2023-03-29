package com.leetcode.second.tree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();

        traverseTree(root, result);


        return result;
    }

    private void traverseTree(TreeNode root, LinkedList<Integer> result) {
        if(root!=null) {
            result.add(root.val);
            traverseTree(root.left, result);
            traverseTree(root.right, result);
        }


    }
}
