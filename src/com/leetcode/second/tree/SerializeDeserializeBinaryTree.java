package com.leetcode.second.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SerializeDeserializeBinaryTree {
    // Encodes a tree to a single string.
    int currentIdx = 0;
    public String serialize(TreeNode root) {
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        this.dfsToStr(root, treeNodes);
        List<String> collect = treeNodes.stream().map(tn -> tn==null? "null" : String.valueOf(tn.val)).collect(Collectors.toList());
        return String.join(",", collect);

    }

    private void dfsToStr(TreeNode root, LinkedList<TreeNode> treeNodes) {
        treeNodes.add(root);
        if(root == null) {
            return;
        }

        dfsToStr(root.left, treeNodes);
        dfsToStr(root.right, treeNodes);
    }

    // Decodes your encoded data to tree.
    public TreeNode rdeserialize(List<String> l) {
        // Recursive deserialization.
        if (l.get(0).equals("null")) {
            l.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = rdeserialize(l);
        root.right = rdeserialize(l);

        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<>(Arrays.asList(data_array));
        return rdeserialize(data_list);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
//        TreeNode right = new TreeNode(2);

        SerializeDeserializeBinaryTree serializeDeserializeBinaryTree = new SerializeDeserializeBinaryTree();
        System.out.println(serializeDeserializeBinaryTree.serialize(treeNode));
        TreeNode deserialize = serializeDeserializeBinaryTree.deserialize(serializeDeserializeBinaryTree.serialize(treeNode));
        System.out.println(deserialize);

    }
}
