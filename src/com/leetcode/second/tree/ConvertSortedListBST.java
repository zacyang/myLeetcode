package com.leetcode.second.tree;

import com.leetcode.second.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListBST {
    public TreeNode sortedListToBST(ListNode head) {
//        step 1, convert linked list to array list
        List<Integer> list = new ArrayList<Integer>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

//        step 2, find the middle of the array list put convert into BST recussively

        int left = 0;
        int right = list.size() - 1;


        TreeNode root = toBST(list, left, right);

        return root;

    }

    private TreeNode toBST(List<Integer> list, int left, int right) {
        if (left > right) {
            return null;
        }
        int middle = left + (right - left) / 2;
        TreeNode treeNode = new TreeNode(list.get(middle));
        treeNode.left = toBST(list, left, middle - 1);
        treeNode.right = toBST(list, middle + 1, right);

        return treeNode;
    }
}
