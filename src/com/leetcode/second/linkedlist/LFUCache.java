package com.leetcode.second.linkedlist;

import java.util.*;

class KeyNode {
    Integer key;
    Integer value;
    Integer counter;

    public KeyNode(Integer key, Integer value, Integer counter) {
        this.key = key;
        this.value = value;
        this.counter = counter;
    }

    public void increaseCounter() {
        this.counter += 1;
    }
}

class LFUCache {
    private final TreeMap<Integer, Deque<KeyNode>> frequencyMap;
    private final Map<Integer, KeyNode> valueMap;
    private int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.frequencyMap = new TreeMap<>();
        this.valueMap = new HashMap<>();
    }

    public int get(int key) {
        if(this.capacity<=0) {
            return -1;
        }
        if(this.valueMap.containsKey(key)) {
            KeyNode keyNode = this.valueMap.get(key);

            updateValueNodeCounter(keyNode);

            updateCacheAndFrequencyMap(key, keyNode);

            return keyNode.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(this.capacity<=0) {
            return;
        }
        if (this.valueMap.containsKey(key)) {
            KeyNode keyNode = valueMap.get(key);
            keyNode.value = value;
            updateValueNodeCounter(keyNode);
            updateCacheAndFrequencyMap(key, keyNode);

        } else {

            if (valueMap.size() >= this.capacity) {
                eviction();

            }
            updateCacheAndFrequencyMap(key, new KeyNode(key, value, 1));
        }
    }

    private void eviction() {
        Integer lowestFrequency = this.frequencyMap.firstKey();


        Deque<KeyNode> keyNodesForLowestFrequency = frequencyMap.get(lowestFrequency);
        KeyNode keyNode = keyNodesForLowestFrequency.removeLast();

        this.valueMap.remove(keyNode.key);

        // can only be empty when cleaned up, so remove it here
        if (keyNodesForLowestFrequency.isEmpty()) {
            frequencyMap.remove(lowestFrequency);
        }
    }

    private void updateValueNodeCounter(KeyNode keyNode) {
        Deque<KeyNode> keyNodes = this.frequencyMap.get(keyNode.counter);
        keyNodes.remove(keyNode);
        if (keyNodes.isEmpty()) {
            frequencyMap.remove(keyNode.counter);
        }
        keyNode.increaseCounter();
    }

    private void updateCacheAndFrequencyMap(int key, KeyNode newKeyNode) {
        Deque<KeyNode> frequencyMapOrDefault = frequencyMap.getOrDefault(newKeyNode.counter, new ArrayDeque<>());
        frequencyMapOrDefault.offerFirst(newKeyNode);
        frequencyMap.put(newKeyNode.counter, frequencyMapOrDefault);
        valueMap.put(key, newKeyNode);
    }

    public static void main(String[] args) {
//        ["LFUCache","put","put","get","put","get","get","put","get","get","get"]
//[[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]
        LFUCache cache = new LFUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

}


