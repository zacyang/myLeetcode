package com.leetcode.second.linkedlist;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;

        deleteIfMatch(dummyNode, head, val);
        return dummyNode.next;

    }

    private void deleteIfMatch(ListNode prev, ListNode current, int val) {
        if (current == null) {
            return;
        }
        if (current.val == val) {

            prev.next = current.next;

            deleteIfMatch(prev, current.next, val);
        } else {
            deleteIfMatch( current, current.next, val);
        }
    }
}
