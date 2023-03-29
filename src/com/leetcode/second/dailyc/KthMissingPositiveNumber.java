package com.leetcode.second.dailyc;


public class KthMissingPositiveNumber {
//    public int findKthPositive(int[] arr, int k) {
//        Set<Integer> objects = new HashSet<>();
//        for (int i : arr) {
//            objects.add(i);
//        }
//
//        int current = 0;
//        while (k> 0) {
//            if(!objects.contains(++current)) {
//                k--;
//            }
//
//
//        }
//        return current;
//    }

    public int findKthPositive(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        int pivot = left + (right - left) / 2;

        while (left <= right) {
            int missingNumber = arr[pivot] - (pivot + 1);

            if (missingNumber < k) {
                left = pivot + 1;
            } else if (missingNumber > k) {
                right = pivot - 1;
            }
        }

        return left + k;
    }

    public static void main(String[] args) {
//        int kthPositive = new KthMissingPositiveNumber().findKthPositive(new int[]{2, 3, 4, 7, 11}, 5);
        int kthPositive = new KthMissingPositiveNumber().findKthPositive(new int[]{1, 2}, 1);
        System.out.println(kthPositive);
    }

}
