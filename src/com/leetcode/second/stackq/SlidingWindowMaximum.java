package com.leetcode.second.stackq;

import java.util.*;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[deque.peekFirst()] < nums[i]) {
                deque.pollFirst();
            }
            deque.offerFirst(i);
        }


        int[] result = new int[nums.length - k + 1];
        result[0] = nums[deque.peekLast()];


        for (int i = k; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekLast() <= i - k) {
                deque.pollLast();
            }

            while (!deque.isEmpty() && nums[deque.peekFirst()] < nums[i]) {
                deque.pollFirst();
            }
            deque.offerFirst(i);

            result[i-k+1] = nums[deque.peekLast()];
        }
        return result;

    }
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        if(k > nums.length) {
//            return nums;
//        }
//        Queue<Integer> integers = new PriorityQueue<>((o1, o2) -> o2 - o1);
//
//        int[] result = new int[nums.length - k+1];
//        int initialIdx = 0;
//        while (integers.size() < k) {
//            integers.offer(nums[initialIdx]);
//            initialIdx++;
//        }
//        result[0] = integers.peek();
//
//        for (int i = initialIdx; i < nums.length; i++) {
//            integers.remove(nums[i - k]);
//
//            integers.offer(nums[i]);
//
//            result[i-k+1] = integers.peek();
//
//        }
//
//        return result;
//    }

    public static void main(String[] args) {
        int[] ints = new SlidingWindowMaximum().maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3);
//        int[] ints = new SlidingWindowMaximum().maxSlidingWindow(new int[]{1, -1}, 1);
//        int[] ints = new SlidingWindowMaximum().maxSlidingWindow(new int[]{1}, 1);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}

