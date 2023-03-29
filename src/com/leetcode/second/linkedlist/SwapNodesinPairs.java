package com.leetcode.second.linkedlist;

import java.time.temporal.ChronoUnit;


public class SwapNodesinPairs {
//    public ListNode swapPairs(ListNode head) {
//        ListNode dummyHead = new ListNode(-1);
//        dummyHead.next = head;
//
//        ListNode prevNode = dummyHead;
////        dummy head to hold the lead as the list is changing
//        while(head!=null && head.next!=null){
//            ListNode firstNode = head;
//            ListNode secondNode = head.next;
//
////            swap
//            prevNode.next = secondNode;
//            firstNode.next = secondNode.next;
//            secondNode.next = firstNode;
//
////   reinit vars
//            prevNode = firstNode;
//            head = firstNode.next;
//        }
//
//        return dummyHead.next;
//
//    }

//recursive
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode first = head;
        ListNode second = head.next;


        second.next = first;
        first.next = swapPairs(second.next);


        return second;
    }

    public static void main(String[] args) {

        System.out.println(new SwapNodesinPairs().swapPairs((new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null)))))));
    }
}
