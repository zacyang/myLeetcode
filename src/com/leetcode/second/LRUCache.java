package com.leetcode.second;

import java.util.HashMap;
import java.util.Map;

class LinkedListNode {
    LinkedListNode prev;
    LinkedListNode next;
    int key;
    int value;

    public LinkedListNode(int key, int val) {
        this.key = key;
        this.value = val;
    }
}

public class LRUCache {
    private final Map<Integer, LinkedListNode> cache;
    private final LinkedListNode head;
    private final LinkedListNode tail;
    private int capacity;

    public LRUCache(int capacity) {

        this.capacity = capacity;
        this.cache = new HashMap<>();
        head = new LinkedListNode(-1, -1);
        tail = new LinkedListNode(-1, -1);

        head.next = tail;
        head.prev = null;

        tail.prev = head;
        tail.next = null;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            LinkedListNode linkedListNode = cache.get(key);
            moveToHead(linkedListNode);
            return linkedListNode.value;
        }
        return -1;
    }

    private void moveToHead(LinkedListNode linkedListNode) {
        remove(linkedListNode);
        addToHead(linkedListNode);
    }

    private void addToHead(LinkedListNode linkedListNode) {
        LinkedListNode originalNext = this.head.next;
        linkedListNode.prev = this.head;
        linkedListNode.next = originalNext;

        this.head.next = linkedListNode;
        originalNext.prev = linkedListNode;
    }

    private void remove(LinkedListNode linkedListNode) {
        LinkedListNode prev = linkedListNode.prev;
        LinkedListNode next = linkedListNode.next;

        prev.next = next;
        next.prev = prev;
    }

    private LinkedListNode popTail() {
        if (this.tail.prev != this.head && this.tail.prev != null) {
            LinkedListNode toBeRemove = this.tail.prev;
            remove(toBeRemove);

//            for completeness
            toBeRemove.prev = null;
            toBeRemove.next = null;
            return toBeRemove;
        }
        return null;
    }


    public void put(int key, int value) {
        if (cache.containsKey(key)) {
//            impossible to do evict
            LinkedListNode linkedListNode = cache.get(key);
            moveToHead(linkedListNode);
            linkedListNode.value = value;
            cache.put(key, linkedListNode);

        } else {
            if (cache.size() >= this.capacity) {
//                evict first
                LinkedListNode lastElement = popTail();
                if (lastElement != null) {
                    cache.remove(lastElement.key);
                }
            }
            LinkedListNode newNode = new LinkedListNode(key, value);
            addToHead(newNode);
            cache.put(key, newNode);
        }

    }
}
