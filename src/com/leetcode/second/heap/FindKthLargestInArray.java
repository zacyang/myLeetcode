package com.leetcode.second.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKthLargestInArray {
    public String kthLargestNumber(String[] nums, int k) {
        // Reverse pq to store only k elements [i.e. Min Heap]
        PriorityQueue<String> pq = new PriorityQueue<>(new StringNumberComparartor());

        for(String numStr: nums) {
            pq.add(numStr);
            if(pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        q.offer(1);
        q.offer(2);
        q.offer(3);

        System.out.println(q.peek());

    }
}

class StringNumberComparartor implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return (s1.length() - s2.length());
        }
        int len = s1.length();
        for(int i=0; i<len; i++) {
            char c1 = s1.charAt(i), c2 = s2.charAt(i);
            if(c1 == c2) { continue; }
            return (c1 - c2);
        }
        return 0;
    }
}