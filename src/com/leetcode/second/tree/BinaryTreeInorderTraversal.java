package com.leetcode.second.tree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        traverse(root, result);
        return result;
    }

    private void traverse(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        traverse(root.left, result);

        result.add(root.val);

        traverse(root.right, result);
    }
}
