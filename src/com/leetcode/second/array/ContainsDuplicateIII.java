package com.leetcode.second.array;

import java.util.TreeSet;

public class ContainsDuplicateIII {
//    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
//
////        brute force
//        int n = nums.length;
//        for (int i = 0; i < n; i++) {
//            int currentCandidate = nums[i];
//
//
//            int minStart = i - indexDiff  > 0 ?i - indexDiff : 0;
//            int maxEnd = i + indexDiff >= n - 1 ? n - 1 : i + indexDiff;
//
//            for (int j = minStart; j <= maxEnd; j++) {
//                if(i == j) {
//                    continue;
//                }
//                int abs = Math.abs(nums[i] - nums[j]);
//                if (abs <= valueDiff) {
//                    return true;
//                }
//            }
//
//
//        }
//        return false;
//    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {

        TreeSet<Integer> integers = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            Integer predecessorNode = integers.floor(nums[i]);
            if (predecessorNode != null && nums[i] <= predecessorNode + valueDiff) {
                return true;
            }

            Integer successorNode = integers.ceiling(nums[i]);
            if (successorNode != null && nums[i] + valueDiff >= successorNode) {
                return true;
            }

            integers.add(nums[i]);

            if (integers.size() > indexDiff) {
                integers.remove(nums[i - indexDiff]);
            }
        }
        return false;

    }

    public static void main(String[] args) {
        boolean b = new ContainsDuplicateIII().containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3);
        System.out.println(b);
    }
}
