package com.leetcode.second.tree;

import java.util.LinkedList;
import java.util.List;

public class FindBottomLeftTreeValue {

    public int findBottomLeftValue(TreeNode root) {
//traverse the tree, get the last row's first one
        LinkedList<LinkedList<Integer>> result = new LinkedList<>();
        traverse(root, 0, result);
        return result.getLast().getFirst();
    }

    private void traverse(TreeNode root, int level, LinkedList<LinkedList<Integer>> result) {

        if (root == null) {
            return;
        }

        if (result.size() == level) {
            result.add(new LinkedList<>());
        }

        result.get(level).add(root.val);


        traverse(root.left, level + 1, result);
        traverse(root.right, level + 1, result);
    }
}
