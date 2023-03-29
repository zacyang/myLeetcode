package com.leetcode.second.linkedlist;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode prev;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
