package com.leetcode.second.tree;

import java.util.HashMap;
import java.util.Map;

//TODO: finish it
public class ConstructBinaryTreePreorderandInorderTraversal {
    int preorderIndex;
    Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        // build a hashmap to store value -> its index relations
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        if(left> right) {
            return null;
        }


        int rootValue = preorder[preorderIndex++];
        TreeNode currentRoot = new TreeNode(rootValue);


        currentRoot.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue)-1);
        currentRoot.right = arrayToTree(preorder, inorderIndexMap.get(rootValue)+1, right);

        return currentRoot;

    }
}
