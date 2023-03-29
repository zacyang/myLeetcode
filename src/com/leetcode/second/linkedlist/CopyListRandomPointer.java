package com.leetcode.second.linkedlist;

import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListRandomPointer {
    HashMap<Node, Node> oldToNew = new HashMap<>();


    public Node copyRandomList(Node head) {

        if(head==null) {
            return null;
        }
//record old to new relationships

        if(oldToNew.containsKey(head)) {
            return oldToNew.get(head);
        }

        Node node  = new Node(head.val);
        oldToNew.put(head, node);


        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);

        return node;
    }
}
