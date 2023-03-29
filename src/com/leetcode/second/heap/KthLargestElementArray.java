package com.leetcode.second.heap;

import java.util.PriorityQueue;

public class KthLargestElementArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minQ = new PriorityQueue<>();


        for (int num : nums) {
            if(minQ.size()< k) {
                minQ.offer(num);
            } else {
                if(minQ.peek() < num) {
                    minQ.poll();
                    minQ.offer(num);
                }
            }
        }
        return minQ.peek();
    }
}
