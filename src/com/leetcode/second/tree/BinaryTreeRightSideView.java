package com.leetcode.second.tree;

import java.util.*;
import java.util.stream.Collectors;

public class BinaryTreeRightSideView {
//    List<List<Integer>> levelView = new ArrayList<>();
//
//    public List<Integer> rightSideView(TreeNode root) {
//
//        getLevelView(root, 0);
//
//        List<Integer> lastNodePerLevel = levelView.stream().map(lv -> lv.get(lv.size() - 1)).collect(Collectors.toList());
//
//        return lastNodePerLevel;
//    }
////looping instead, only peak the last elm in the level
//    private void getLevelView(TreeNode root, int i) {
//
//        if (root == null) {
//            return;
//        }
//        if (levelView.size() == i) {
//            levelView.add(new LinkedList<>());
//        }
//
//        levelView.get(i).add(root.val);
//
//        if (root.left != null) {
//            getLevelView(root.left, i + 1);
//        }
//
//        if (root.right != null) {
//            getLevelView(root.right, i + 1);
//        }
//    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> level = new LinkedList<>();

        LinkedList<Integer> rightSideView = new LinkedList<>();
        level.add(root);
        while (!level.isEmpty()) {
//            get all out for pre next lv
            TreeNode last = level.getLast();

            rightSideView.add(last.val);

            List<TreeNode> allNextLevel = level.stream().map(n -> Arrays.asList(n.left, n.right)).flatMap(i -> i.stream()).filter(Objects::nonNull).collect(Collectors.toList());

            level.clear();
            level.addAll(allNextLevel);
        }

        return rightSideView;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        List<Integer> integers = new BinaryTreeRightSideView().rightSideView(root);
        System.out.println(integers);
    }
}
