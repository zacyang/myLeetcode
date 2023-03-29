package com.leetcode.second.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumDepthBinaryTree {
    //    normal way
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

//       not leaf
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }

        if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        int rightMin = minDepth(root.right);
        int leftMin = minDepth(root.left);

        return Math.min(rightMin, leftMin) + 1;
    }


}

//    BFS

class MinimumDepthBinaryTree2 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> treeNodes = new LinkedList<>();
        int level = 0;
        treeNodes.add(root);

        while (!treeNodes.isEmpty()) {
            level++;
            List<TreeNode> allTheNodes = treeNodes.stream().toList();

            boolean anyLeaf = allTheNodes.stream().anyMatch(n -> n.left == null && n.right == null);
            if (anyLeaf) {
                return level;
            }

            treeNodes.clear();
            allTheNodes.stream().forEach(n -> {
                if (n.left != null) treeNodes.add(n.left);
                if (n.right != null) treeNodes.add(n.right);
            });

        }
        return level;

    }
}
