package com.leetcode.second.tree;

public class ConvertSortedArraytoBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        TreeNode node = createNode(nums, start, end);

        return node;
    }

    private TreeNode createNode(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int middle = (start + end) / 2;
        int rootVal = nums[middle];
        TreeNode treeNode = new TreeNode(rootVal);
        treeNode.left = createNode(nums, start, middle - 1);
        treeNode.right = createNode(nums, middle + 1, end);
        return treeNode;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new ConvertSortedArraytoBST().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }
}
