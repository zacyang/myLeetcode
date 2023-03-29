package com.leetcode.second.tree;

public class CountCompleteTreeNodes {
    //    public int countNodes(TreeNode root) {
////        O(n) solution
//        if(root == null) {
//            return 0;
//        }
//
//        return countNodes(root.left) + countNodes(root.right) + 1;
//    }
    public int countNodes(TreeNode root) {

        TreeNode leftMost = root;
        int treeDepthOnLeft = 0;
        while (leftMost != null) {
            leftMost = leftMost.left;
            treeDepthOnLeft++;
        }


        int inbanalancedDepth = findInbalancedNodeDepth(root, 0);

        int complteTreeNodes = 1 << treeDepthOnLeft;

        int missingNodes = 1 << (treeDepthOnLeft - inbanalancedDepth);


        return complteTreeNodes- missingNodes;
    }

    private int findInbalancedNodeDepth(TreeNode root, int currentDepth) {
//        BFS
        if (root == null) {
            return currentDepth;
        }

        currentDepth ++;
        if (root.left == null ^ root.right == null) {
            return currentDepth;
        }

        int rightDepth = findInbalancedNodeDepth(root.right, currentDepth );
        int leftDepth = findInbalancedNodeDepth(root.left, currentDepth) ;

        return Math.min(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        left.left = new TreeNode(4);
//        left.right = new TreeNode(5);
        root.left = left;
        TreeNode right = new TreeNode(3);
//        right.left = new TreeNode(6);
        root.right = right;

        System.out.println( new CountCompleteTreeNodes().countNodes(root));
    }
}
