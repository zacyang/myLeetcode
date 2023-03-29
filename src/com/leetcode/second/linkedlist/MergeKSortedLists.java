package com.leetcode.second.linkedlist;

import com.leetcode.second.MergeIntervals;

import java.util.*;

import java.util.stream.Collectors;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> listNodes = new PriorityQueue<>((o1, o2) -> o1.val-o2.val);

        for (ListNode list : lists) {
            ListNode currentNode = list;
            while(currentNode!=null){

                    listNodes.offer(currentNode);

                currentNode = currentNode.next;
            }
        }

         ListNode dummyHead = new ListNode();
        ListNode currentHead = dummyHead;
        while(!listNodes.isEmpty()) {
            ListNode poll = listNodes.poll();
            currentHead.next = poll;
            currentHead = poll;
        }
//        cut of the tail to prevent the cycle
        currentHead.next = null;

        return dummyHead.next;

    }

    public static void main(String[] args) {
//        ListNode listNode = new MergeKSortedLists().mergeKLists(new ListNode[]{
//                new ListNode(1, new ListNode(4, new ListNode(5))),
//                new ListNode(1, new ListNode(3, new ListNode(4))),
//                new ListNode(2, new ListNode(6)),
//        });
        ListNode listNode = new MergeKSortedLists().mergeKLists(new ListNode[]{
                new ListNode(-2, new ListNode(-1, new ListNode(-1,new ListNode(-1,new ListNode(-1 ))))),
                null

        });
        System.out.println(listNode);
    }
}
