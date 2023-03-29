package com.leetcode.second.tree;

public class ConstructBSTPreorderInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return constructNode(0, 0, inorder.length - 1, preorder, inorder);
    }

    private TreeNode constructNode(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {

//        termination condi

        if(inStart> inorder.length-1 || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int inxOfRootInorder = 0;
        for (int i = inStart; i <= inEnd; i++) {

            if(root.val == inorder[i]) {
                inxOfRootInorder = i;
            }
        }

        root.left = constructNode(preStart+1, inStart, inxOfRootInorder -1, preorder, inorder);
        root.right = constructNode(preStart+ 1 + inxOfRootInorder - inStart, inxOfRootInorder+1, inEnd, preorder, inorder );
        return root;
    }


}
