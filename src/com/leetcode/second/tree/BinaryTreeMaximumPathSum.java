package com.leetcode.second.tree;

public class BinaryTreeMaximumPathSum {
    int currentMax = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);

        return this.currentMax;

    }

    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

//        possible gain for sum involved current node as root
        int possibleGainIncludesCurrentNode = leftGain + rightGain + node.val;


        this.currentMax  =Math.max(this.currentMax, possibleGainIncludesCurrentNode);


        return node.val + Math.max(leftGain, rightGain);
    }


}
