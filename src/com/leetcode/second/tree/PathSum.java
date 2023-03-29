package com.leetcode.second.tree;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {

        boolean solutionFound = bfs(root, targetSum);

        return solutionFound;
    }

    private boolean bfs(TreeNode root, int targetSum) {

        if(root ==null){
            return false;
        }
//        if leaf
        int reminder = targetSum - root.val;
        if(root.left ==null && root.right ==null) {
            return targetSum == 0;
        }

        return bfs(root.left, reminder) || bfs(root.right, reminder);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        TreeNode right = new TreeNode(6);
//        root.right = right;

        boolean b = new PathSum().hasPathSum(root, 1);
        System.out.println(b);
    }
}
