package com.leetcode.second.dailyc;

import com.leetcode.second.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MinimumDistanceBetweenBSTNodes {

    public int minDiffInBST(TreeNode root) {



        List<Integer> result = new ArrayList<>();
        traverse(result, root);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < result.size()-1; i++) {
            int difft = result.get(i+1) - result.get(i);
            minDiff = Math.min(difft, minDiff);
        }
        return minDiff;
    }

    private void traverse(List<Integer> integers, TreeNode root) {

        if(root==null) {
            return;
        }

        traverse(integers, root.left);
        integers.add(root.val);
        traverse(integers, root.right);
    }




}
