package com.leetcode.second.atlassian;

import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> counterCache = new HashMap<>();
        for (String word : words) {
            Integer counter = counterCache.getOrDefault(word, 0);
            counterCache.put(word, counter + 1);
        }

        PriorityQueue<String> frequenceQ = new PriorityQueue<>((w1, w2) -> {
            Integer w1Count = counterCache.getOrDefault(w1, 0);
            Integer w2Count = counterCache.getOrDefault(w2, 0);
            if (w1Count != w2Count) {
                return w2Count - w1Count;
            }
            return w1.compareTo(w2);
        });

        counterCache.keySet().forEach(word -> frequenceQ.offer(word));

        List<String> result = new ArrayList<>();
        while (k > 0 && !frequenceQ.isEmpty()) {
            result.add(frequenceQ.poll());
            k--;
        }
        return result;
    }
}
