package com.leetcode.second.linkedlist;

import java.util.HashSet;

public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        HashSet<Integer> seen = new HashSet<>();
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (head != null) {

            if (seen.contains(head.val)) {
                prev.next = head.next;
                head = head.next;
            } else {
                seen.add(head.val);
                prev= head;
                head = head.next;
            }

        }
        return dummyHead.next;
    }
}
