package com.leetcode.second.backtracking;

import java.util.*;

public class PermutationII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> numberRegister = new HashMap<>();
        for (int num : nums) {
            numberRegister.compute(num, (k, v) -> numberRegister.getOrDefault(k, 0) + 1);
        }

        List<List<Integer>> result = new ArrayList<>();
        backTracking(nums, result, new LinkedList<>(), numberRegister);

        return result;
    }

    private void backTracking(int[] nums, List<List<Integer>> result, LinkedList<Integer> current, Map<Integer, Integer> numberRegister) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }


        for (Map.Entry<Integer, Integer> entry : numberRegister.entrySet()) {
            Integer count = numberRegister.get(entry.getKey());
            if (count == 0) {
                continue;
            }
            numberRegister.compute(entry.getKey(), (k, v) -> v - 1);
            current.add(entry.getKey());

            backTracking(nums, result, current, numberRegister);
            numberRegister.compute(entry.getKey(), (k, v) -> v + 1);
            current.removeLast();
        }
    }


    public static void main(String[] args) {
        List<List<Integer>> lists = new PermutationII().permuteUnique(new int[]{1, 1, 2});
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.println(integer);
            }
            System.out.println("---");
        }
    }
}
