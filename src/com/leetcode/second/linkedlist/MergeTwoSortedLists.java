package com.leetcode.second.linkedlist;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode current = dummyHead;


        while(list1!=null && list2!=null){
            if(list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;

            } else {
                current.next =list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        current.next = list1 == null? list2: list1;

        return dummyHead.next;
    }


}
