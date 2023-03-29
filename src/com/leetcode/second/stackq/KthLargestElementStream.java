package com.leetcode.second.stackq;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementStream {
    private final int k;

    Queue<Integer> cache;

    public KthLargestElementStream(int k, int[] nums) {
        this.k = k;

        cache = new PriorityQueue<>(Comparator.naturalOrder());
        if (nums != null) {
            for (int num : nums) {
              this.add(num);
            }
        }
    }

    public int add(int val) {
        if (cache.size() < k) {
            cache.add(val);

        } else {
            if (val > cache.peek()) {
                cache.poll();
                cache.add(val);
            }
        }
        return cache.peek();
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> ts = new PriorityQueue<>(Comparator.naturalOrder());
        ts.offer(1);
        ts.offer(2);

        ts.offer(5);

        ts.offer(-1);

        Integer poll = ts.poll();

        System.out.println("111");


    }
}
