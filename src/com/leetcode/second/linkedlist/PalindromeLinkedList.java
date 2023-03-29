package com.leetcode.second.linkedlist;

public class PalindromeLinkedList {
    ListNode front;
    public boolean isPalindrome(ListNode head) {
//        if current node == last node & isPalindrom(head.next)
        front = head;

        boolean result =  this.seachForInbalance(head);
        return result;
    }

    private boolean seachForInbalance(ListNode head) {
        if(head!=null) {

            if(!seachForInbalance(head.next)) {
                return false;
            }

            if(head.val != front.val) {
                return false;
            } else {
                front = front.next;
            }

        }
        return true;
    }
}
