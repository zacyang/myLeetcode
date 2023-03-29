package com.leetcode.second.tree;

public class MergeTwoBinaryTrees {
//    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
//        TreeNode result = pickNewNode(root1, root2);
//        return result;
//    }
//
//    private TreeNode pickNewNode(TreeNode root1, TreeNode root2) {
//        int newVal = 0;
//        if (root1 == root2 && root1 == null) {
//            return null;
//        }
//
//        if (root1 != null && root2 != null) {
//            newVal = root1.val + root2.val;
//        } else {
//            newVal = root1 == null ? root2.val : root1.val;
//        }
//
//        TreeNode treeNode = new TreeNode(newVal);
//        treeNode.left = pickNewNode(root1 == null ? null : root1.left, root2 == null ? null : root2.left);
//        treeNode.right = pickNewNode(root1 == null ? null : root1.right, root2 == null ? null : root2.right);
//
//        return treeNode;
//    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode result = pickNewNode(root1, root2);
        return result;
    }

    private TreeNode pickNewNode(TreeNode root1, TreeNode root2) {
        int newVal = 0;
        if (root1 == root2 && root1 == null) {
            return null;
        }

        if(root1 == null) {
            return root2;
        }
        if(root2 == null) {
            return root1;
        }

        root1.val += root2.val;


        root1.left = pickNewNode(root1 == null ? null : root1.left, root2 == null ? null : root2.left);
        root2.right = pickNewNode(root1 == null ? null : root1.right, root2 == null ? null : root2.right);

        return root1;
    }
}
