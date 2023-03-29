package com.leetcode.second.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelTraverse(root, result, 0);

        for (int i = 0; i < result.size(); i++) {
            if (i % 2 != 0) {
                List<Integer> integers = result.get(i);
                Collections.reverse(integers);


            }
        }
        return result;

    }

    private void levelTraverse(TreeNode root, List<List<Integer>> result, int level) {
        if (root == null) {
            return;
        }

        if (result.size() > level) {

            List<Integer> integers = result.get(level);

            integers.add(root.val);
        } else {
            List<Integer> newLevel = new ArrayList<>();
            newLevel.add(root.val);
            result.add(newLevel);
        }

        levelTraverse(root.left, result, level + 1);
        levelTraverse(root.right, result, level + 1);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        List<List<Integer>> lists = new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(root);
    }
}
