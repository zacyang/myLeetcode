package com.leetcode.second.dp;

import java.util.*;
import java.util.stream.Collectors;

public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).reduce((a, b) -> a + b).getAsInt();
        if (sum % 2 != 0) {
            return false;
        }

        Arrays.sort(nums);
        Set<Integer> sumCache = new HashSet<>();

        for (int num : nums) {

//            nums before it can form sum/2 -num OR it is half of the sum
            if (sumCache.contains(sum / 2 - num) || sum/2 == num) {
                return true;

            }
            Set<Integer> collect = sumCache.stream().map(el -> el + num).collect(Collectors.toSet());
            sumCache.addAll(collect);
            sumCache.add(num);
        }
        return false;

    }
//    public boolean canPartition(int[] nums) {
////        calculate sum
//        int sum = Arrays.stream(nums).reduce((a, b) -> a + b).getAsInt();
//        if (sum % 2 != 0) {
//            return false;
//        }
////        backtracking
//
//        List<Integer> candidates = new ArrayList<>(nums.length);
//        for (int i : nums) {
//            candidates.add(i);
//        }
//
//
//        boolean result = backTracking(sum / 2, candidates);
//        return result;
//    }
//
//    private boolean backTracking(int target, List<Integer> candidates) {
//
//        if (target == 0) {
//            return true;
//        }
//        if (target < 0) {
//            return false;
//        }
//
//        LinkedList<Integer> copyCandidates = new LinkedList<>(candidates);
//        for (Integer candidate : candidates) {
//            copyCandidates.remove(candidate);
//            if (backTracking(target - candidate, copyCandidates)) {
//                return true;
//            }
//            copyCandidates.add(candidate);
//
//        }
//        return false;
//    }

    public static void main(String[] args) {
        boolean b = new PartitionEqualSubsetSum().canPartition(new int[]{1, 5, 11, 5});
//        boolean b = new PartitionEqualSubsetSum().canPartition(new int[]{1, 1});
//        boolean b = new PartitionEqualSubsetSum().canPartition(new int[]{2,2,3,5});
//        boolean b = new PartitionEqualSubsetSum().canPartition(new int[]{1, 2, 5});
        System.out.println(b);
    }
}
