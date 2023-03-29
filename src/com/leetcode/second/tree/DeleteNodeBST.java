package com.leetcode.second.tree;

public class DeleteNodeBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val == key) {
            if (root.left == null && root.right == null) {
//                delete root;
                return null;
            } else if (root.left == null ^ root.right == null) {
                return root.left == null ? root.right : root.left;

            } else {
//                most comlex case need to put the left node into the leftmost of the original right node. and return the right nodes' head

                TreeNode orignLeft = root.left;
                TreeNode leftMost = traverseLeft(root.right);
                leftMost.left = orignLeft;
                return root.right;
            }
        }

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }

        return root;

    }

    private TreeNode traverseLeft(TreeNode node) {
        TreeNode lastNode = node;
        while (node != null) {
            lastNode=node;
            node = node.left;

        }
        return lastNode;
    }
}
