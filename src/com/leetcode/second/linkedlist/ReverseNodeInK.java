package com.leetcode.second.linkedlist;

import java.util.LinkedList;

public class ReverseNodeInK {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode pt = head;


        int count = 0;
//        check if there's enough element
        while (pt != null && count < k) {
            pt = pt.next;
            count++;
        }

        if (count == k) {
//            enough elements
            ListNode newHead = reverse(head, k);

            head.next = reverseKGroup(pt, k);
            return newHead;

        }
//        reverset the first k


        return head;

    }

    //    public ListNode reverse(ListNode head, int k) {
//        ListNode prev = null;
//
//        ListNode current = head;
//
//        while(k > 0){
//
//            ListNode tmp = current.next;
//
//            current.next = prev;
//
//            prev = current;
//            current = tmp;
//
//            k --;
//        }
//
//        return prev;
//
//    }
    public ListNode reverse(ListNode head, int k) {
        k--;
        if (head == null || head.next == null || k==0) {
            return head;
        }
        ListNode p = reverse(head.next, k);
        head.next.next = head;
        head.next = null;
        return p;
    }


    public static void main(String[] args) {
        ListNode dummy = new ListNode(-1);
        ListNode x = new ReverseNodeInK().reverseKGroup(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2);
        System.out.println(x);
    }
}


