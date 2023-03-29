package com.leetcode.second.binarysearch;

import java.util.*;

public class FindKClosestElements {
//    public List<Integer> findClosestElements(int[] arr, int k, int x) {
//        PriorityQueue<Integer> heap = new PriorityQueue<>(
//
////                Comparator.comparingInt(o -> Math.abs(o - x))
//                (o1, o2) -> {
//                    if (Math.abs(o1 - x) == Math.abs(o2 - x)) {
//                        return o1 - o2;
//                    }
//
//                    return Math.abs(o1 - x) -  Math.abs(o2 - x);
//
//                }
//        );
//
//        for (int i : arr) {
//            heap.offer(i);
//        }
//        List<Integer> result = new LinkedList<>();
//        while (k > 0) {
//            result.add(heap.poll());
//            k--;
//        }
//        result.sort(Comparator.naturalOrder());
//        return result;
//    }


    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<Integer>();
        if (arr.length == k) {
            for (int i = 0; i < k; i++) {
                result.add(arr[i]);
            }

            return result;
        }

//        locate the closest to x in the array
        int left = 0, right = arr.length;
        int middle = arr.length / 2;

        while (left < right) {
            if (arr[middle] >= x) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

//        left is the cloests


        // Initialize our sliding window's bounds
        left -= 1;
        right = left + 1;
        while (right - left - 1 < k) {
            if (left == -1) {
//                reached left end, only increasing right bound
                right++;
            }

            if (right == arr.length || Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                left--;
            } else {
                right++;
            }
        }

        for (int i = left + 1; i < right; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}
