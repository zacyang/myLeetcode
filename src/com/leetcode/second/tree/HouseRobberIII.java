package com.leetcode.second.tree;

public class HouseRobberIII {
//    public int rob(TreeNode root) {
////        return Math.max(rob(root, true, root.val), rob(root, false, 0));
//        return rob(root, false, 0);
//    }

    public int rob(TreeNode root) {
//        return Math.max(rob(root, true, root.val), rob(root, false, 0));
        int[] result = robSubTree(root);
        return Math.max(result[0],  result[1] ) ;
    }

    public int[] robSubTree(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] robLeft = robSubTree(root.left);
        int[] robRight = robSubTree(root.right);


        int robThisNode = root.val + robLeft[1] + robRight[1];

        int notRobThisNode = Math.max(robLeft[0], robLeft[1]) + Math.max(robRight[0], robRight[1]);


        return new int[]{robThisNode, notRobThisNode};

    }

    public int rob(TreeNode root, boolean predecessorRobbed, int currentSum) {

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return predecessorRobbed ? currentSum : currentSum + root.val;
        }

        int leftSumNoRobCurrent = rob(root.left, false, currentSum);
        int rightSumNoRobCurrent = rob(root.right, false, currentSum);
        int withOutCurrent = leftSumNoRobCurrent + rightSumNoRobCurrent;

        if (!predecessorRobbed) {
            int leftSum = rob(root.left, true, currentSum);
            int rightSum = rob(root.right, true, currentSum);
            int sumOfrobCurrent = leftSum + rightSum + root.val;

            return Math.max(sumOfrobCurrent, withOutCurrent);
        } else {
            return withOutCurrent;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(2);
        left.right = new TreeNode(3);
        root.left = left;
        TreeNode right = new TreeNode(3);
        right.right = new TreeNode(1);
        root.right = right;
        int rob = new HouseRobberIII().rob(root);
        System.out.println(rob);

    }
}
