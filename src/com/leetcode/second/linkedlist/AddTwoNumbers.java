package com.leetcode.second.linkedlist;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean carry = false;
        ListNode  currentL = l1;
        ListNode currentR = l2;
        ListNode dumpHead=  new ListNode();
        ListNode currentH = dumpHead;
        while(currentL!=null || currentR!=null){
            int leftV = currentL== null? 0: currentL.val;
            int rightV = currentR == null ? 0: currentR.val;


            int sum = leftV + rightV;
            if(carry) {
                sum+=1;
            }
            carry = sum>= 10;

            int newNodeval = sum %10;
            currentH.next = new ListNode(newNodeval);
            currentH = currentH.next;

            currentL = currentL==null? null: currentL.next;
            currentR =currentR==null?null: currentR.next;
        }
        if(carry) {
            currentH.next = new ListNode(1);
        }
        return dumpHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new AddTwoNumbers().addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(3))), new ListNode(5, new ListNode(6, new ListNode(4))));

    }
}
