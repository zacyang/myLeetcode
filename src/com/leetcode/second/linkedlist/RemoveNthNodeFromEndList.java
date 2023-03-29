package com.leetcode.second.linkedlist;

public class RemoveNthNodeFromEndList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;


        ListNode nthNodePrev = findNthNode(dummy, n+1);
        if(nthNodePrev ==null) {
            return null;
        }
        ListNode nthNode = nthNodePrev.next;
        nthNodePrev.next = nthNode.next;
        nthNode.next = null;
        return dummy.next;
    }


    private ListNode findNthNode(ListNode head, int n) {
        ListNode fastPoint = head;
        ListNode slowPoint = head;

        while (fastPoint.next != null) {
            fastPoint = fastPoint.next;
            n--;
            if (n <= 0) {
                slowPoint = slowPoint.next;
            }
        }



        return slowPoint;
    }

    public static void main(String[] args) {
//        ListNode listNode = new RemoveNthNodeFromEndList().removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null))))), 2);
        ListNode listNode = new RemoveNthNodeFromEndList().removeNthFromEnd(new ListNode(1, null), 1);
        System.out.println(listNode);
    }

}
