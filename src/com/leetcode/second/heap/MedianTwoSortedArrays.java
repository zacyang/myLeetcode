package com.leetcode.second.heap;

import com.leetcode.second.binarysearch.FindMinimuminRotatedSortedArray;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        max heap
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>((o1, o2) -> o2-o1);
//        min heap
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();


        for (int i = 0; i < nums1.length+nums2.length; i++) {
            int currentNum = i >= nums1.length ? nums2[i-nums1.length]  : nums1[i];
            if(rightHeap.peek() == null || currentNum < rightHeap.peek() ) {
                leftHeap.offer(currentNum);
            } else {
                rightHeap.offer(currentNum);
            }

//            if(leftHeap.isEmpty() || leftHeap.peek() > currentNum) {
//                rightHeap.offer(currentNum);
//            } else {
//                leftHeap.offer(currentNum);
//            }

//            balance two heaps
            if(leftHeap.size() - rightHeap.size() >1) {
                rightHeap.offer(leftHeap.poll());
            } else if(rightHeap.size() - leftHeap.size() > 1) {
                leftHeap.offer(rightHeap.poll());
            }



        }

        if(leftHeap.size() - rightHeap.size() == 1) {
            return leftHeap.poll();
        } else if(rightHeap.size() - leftHeap.size() == 1) {
            return rightHeap.poll();
        }else {
            double topTwo = leftHeap.peek() + rightHeap.peek();
            return topTwo/2.00;
        }

    }

    public static void main(String[] args) {
//        double medianSortedArrays = new MedianTwoSortedArrays().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        double medianSortedArrays = new MedianTwoSortedArrays().findMedianSortedArrays(new int[]{0,0,0,0,0}, new int[]{-1,0,0,0,0,0,1});
        System.out.println(medianSortedArrays);

    }
}
