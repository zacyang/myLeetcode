package com.leetcode.second.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new LinkedList<>();

        backTrack(result, nums, new LinkedList<>());
        return result;
    }

    private void backTrack(List<List<Integer>> result, int[] nums, LinkedList<Integer> currentCombo) {

        if (currentCombo.size() == nums.length) {
            result.add(new ArrayList<>(currentCombo));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (currentCombo.contains(nums[i])) {
                continue;
            }

            currentCombo.add(nums[i]);

            backTrack(result, nums, currentCombo);

            currentCombo.removeLast();

        }

    }

    public static void main(String[] args) {
        List<List<Integer>> permute = new Permutations().permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }
}
