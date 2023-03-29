package com.leetcode.second.tree;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

public class BinaryTreeLevelOrderTraversal {

    private List<List<Integer>> result;

    public List<List<Integer>> levelOrder(TreeNode root) {

        result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        traverse(root, 0);

        return result;
    }

    private void traverse(TreeNode node, int level) {
        if (result.size() == level) {
//            result needed exapand to house more level
            result.add(new LinkedList<>());
        }

        result.get(level).add(node.val);


        if (node.left != null) {
            traverse(node.left, level + 1);
        }

        if (node.right != null) {
            traverse(node.right, level + 1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(new BinaryTreeLevelOrderTraversal().levelOrder(root));
    }
}
