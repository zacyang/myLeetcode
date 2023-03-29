package com.leetcode.second.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AllPossibleFullBST {
    TreeNode currentNode = new TreeNode(-1);
    List<TreeNode> allPossibles = new LinkedList<>();

    //        base case
//        one node
    TreeNode oneNode = new TreeNode(-1);
    //        2 impossible
//        3
    TreeNode threeNode = new TreeNode(-1);

    {
        threeNode.left = new TreeNode(0);
        threeNode.right = new TreeNode(0);
    }

    HashMap<Integer, List<TreeNode>> register = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
//        one of two choice, termination on when all n node placed, return the root
        if (!register.containsKey(n)) {
            List<TreeNode> result = new LinkedList<>();
            if (n == 1) {
                result.add(new TreeNode(0));
            } else if (n % 2 == 1) {
                for (int i = 0; i < n; i++) {
                    List<TreeNode> leftPossible = allPossibleFBT(i);
                    for (TreeNode left : leftPossible) {

                        List<TreeNode> rightPossible = allPossibleFBT(n -1- i);
                        for (TreeNode rightTree : rightPossible) {
                            TreeNode root = new TreeNode(0);
                            root.left = left;
                            root.right = rightTree;
                            result.add(root);

                        }
                    }
                }

            }
            register.put(n, result);
        }


        return register.get(n);
    }


    private TreeNode cloneTree(TreeNode treeNode) {
        return null;
    }


}
