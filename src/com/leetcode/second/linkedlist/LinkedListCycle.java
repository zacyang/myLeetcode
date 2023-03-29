package com.leetcode.second.linkedlist;

import java.util.HashSet;

public class LinkedListCycle {
//    public boolean hasCycle(ListNode head) {
//        HashSet<ListNode> visited = new HashSet<>();
//        while(head!=null){
//            if(visited.contains(head)) {
//                return true;
//            }
//            visited.add(head);
//            head = head.next;
//        }
//        return false;
//    }

    //    fast slow
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }

            fast = fast.next.next;
            slow = slow.next;

        }

        return true;
    }

}
