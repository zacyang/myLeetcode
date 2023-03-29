package com.leetcode.second.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SumRootLeafNumbers {
//    LinkedList<List<Integer>> allResult = new LinkedList<>();
//    int sum = 0;
//    public int sumNumbers(TreeNode root) {
//
//        preOrderTraverse(root,  0);
//
//        return sum;
//    }
//
//    private void preOrderTraverse(TreeNode root, int currentPathSum) {
//
//        if(root ==null){
//
//            return;
//        }
//
//        currentPathSum = currentPathSum * 10 +  root.val ;
//        if(root.left==null && root.right == null){
//            this.sum += currentPathSum;
//            return;
//        }
//
//        preOrderTraverse(root.left, currentPathSum);
//        preOrderTraverse(root.right, currentPathSum);
//    }

    private int listToNumberSum(List<Integer> l) {
        int result = 0;
        for (int i = 0; i < l.size(); i++) {
            result += l.get(i) * Math.pow(10, l.size()-1-i);
        }
        return result;
    }

    public int sumNumbers(TreeNode root) {

        LinkedList<List<Integer>> allResult = new LinkedList<>();
        backTrack(root, new LinkedList<>(), allResult);
        return allResult.stream().map(list -> listToNumberSum(list)).reduce((a, b) -> a + b).get();
    }


    private void backTrack(TreeNode root, LinkedList<TreeNode> currentPathNodes, LinkedList<List<Integer>> allResult) {
        if (root == null) {
            return;
        }

        currentPathNodes.add(root);
        if (root.left == null && root.right == null) {
            List<Integer> currentCombo = currentPathNodes.stream().map(pn -> pn.val).collect(Collectors.toList());
            allResult.add(currentCombo);
            return;
        }

        if(root.left!=null){
            backTrack(root.left, currentPathNodes, allResult);
            currentPathNodes.removeLast();
        }


        if(root.right!=null){
            backTrack(root.right, currentPathNodes, allResult);
            currentPathNodes.removeLast();
        }

    }

    public static void main(String[] args) {

//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);

//        TreeNode root = new TreeNode(1);
////        root.left = new TreeNode(2);
//        root.right = new TreeNode(5);

        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(9);
        left.left = new TreeNode(5);
        left.right = new TreeNode(1);
        root.left = left;
        root.right = new TreeNode(0);
        int i = new SumRootLeafNumbers().sumNumbers(root);
        System.out.println(i);
    }
}
