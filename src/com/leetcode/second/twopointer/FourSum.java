package com.leetcode.second.twopointer;

import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        LinkedList<List<Integer>> result = new LinkedList<>();


        for (int i = 0; i < nums.length - 4; i++) {

            LinkedList<List<Integer>> currentResult = new LinkedList<>();
            find3Sum(i + 1, nums, target - nums[i], currentResult);
            final int idx = i;
            List<List<Integer>> tmpREsult = currentResult.stream().filter(r -> r.size() < 4).collect(Collectors.toList());
            tmpREsult.stream().forEach(r -> r.add(nums[idx]));


            result.addAll(tmpREsult);
        }
        return result;

    }

    private void find3Sum(int startingIdx, int[] nums, int target, LinkedList<List<Integer>> currentResult) {
        for (int i = startingIdx; i < nums.length - 3; i++) {

            find2Sum(i + 1, nums, target - nums[i], currentResult);
            final int idx = i;
            currentResult.forEach(r -> r.add(nums[idx]));
        }

    }

    private void find2Sum(int startingIdx, int[] nums, int target, LinkedList<List<Integer>> currentResult) {
//        reminder -> index map
        HashMap<Integer, Integer> reminderMap = new HashMap<>();
        for (int i = startingIdx; i < nums.length; i++) {

            if (reminderMap.containsKey(nums[i])) {
                ArrayList<Integer> resultList = new ArrayList<>();
                resultList.add(nums[i]);
                Integer oppositeIdx = reminderMap.get(nums[i]);
                resultList.add(nums[oppositeIdx]);
                currentResult.add(resultList);
            }
            reminderMap.put(target - nums[i], i);
        }



    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new FourSum().fourSum(new int[]{2,2,2,2,2}, 8);
        System.out.println(lists);
    }
}
