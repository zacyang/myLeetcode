package com.leetcode.second.heap;

import java.util.PriorityQueue;

public class KthLargestElementStream {

    private final PriorityQueue<Integer> priorityQueue;
    private final int size;

    public KthLargestElementStream(int k, int[] nums) {
        priorityQueue = new PriorityQueue<>();
        size = k;

        for (int num : nums) {
            this.add(num);
        }

    }

    public int add(int val) {

        if (priorityQueue.size() < size) {
            priorityQueue.offer(val);
        } else {
            if (priorityQueue.peek() < val) {
                priorityQueue.poll();
                priorityQueue.offer(val);
            }
        }

        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        int add = new KthLargestElementStream(3, new int[]{4, 5, 8, 2}).add(3);
        System.out.println(add);
    }
}
