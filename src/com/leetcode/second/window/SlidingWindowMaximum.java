package com.leetcode.second.window;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k > nums.length) {
            return null;
        }

        PriorityQueue<Integer> integerPriorityQueue = new PriorityQueue<>((o1, o2) -> o2-o1);

        int initNum = 0;
        while(initNum<k) {
            integerPriorityQueue.offer(nums[initNum]);
            initNum++;
        }
        int[] result = new int[nums.length-k+1];

        result[0]= integerPriorityQueue.peek();
        integerPriorityQueue.remove(nums[0]);

        for (int i = k +1; i < nums.length; i++) {
            integerPriorityQueue.add(nums[i]);
            result[i-k] = integerPriorityQueue.peek();
            integerPriorityQueue.remove(nums[i-k+1]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] ints = new SlidingWindowMaximum().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(ints);
    }
}
