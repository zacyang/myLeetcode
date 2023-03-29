package com.leetcode.second.linkedlist;


public class ReverseLinkedList {
    //    public ListNode reverseList(ListNode head) {
//        ListNode pre = null;
//        ListNode current = head;
//        while (current != null) {
//            ListNode tmp = current.next;
//
//            current.next = pre;
//
////            for next loop
//            pre = current;
//            current = tmp;
//
//        }
//
//        return pre;
//
//    }
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode result = reverseList(head.next);


        head.next.next = head;
        head.next = null;

        return result;


    }


    public static void main(String[] args) {
        System.out.println(new ReverseLinkedList().reverseList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))));
    }
}
