package com.leetcode.second.linkedlist;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class LinkedListRandomNode {
    private List<ListNode>  list = new LinkedList<>();
    public LinkedListRandomNode(ListNode head) {
        while (head!=null){
            list.add(head);
            head = head.next;
        }

    }

    public int getRandom() {
        double v = list.size() * Math.random();
        return list.get((int)v).val;


    }
}
