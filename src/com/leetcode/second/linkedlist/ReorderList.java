package com.leetcode.second.linkedlist;

public class ReorderList {
    public void reorderList(ListNode head) {

        while (head!=null) {
            ListNode tmp = head.next;

            ListNode lastNode = removeLastNode(head);
//it's the last one already

            head.next = lastNode;


            if(!lastNode.equals(tmp)) {
                lastNode.next = tmp;
            }
                head = tmp;


        }


    }

    private ListNode removeLastNode(ListNode head) {
        ListNode prev = head;
        while(head.next !=null){
            prev = head;
            head = head.next;
        }
        prev.next =null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
//        ListNode head = new ListNode(1, new ListNode(2, null));
        new ReorderList().reorderList(head);
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }

    }
}
