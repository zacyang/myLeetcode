package com.leetcode.second.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        int n = nums.length;

        for (int i = 0; i <= n; i++) {
            generateCombo(i, 0, nums, result, new ArrayList<>());
        }

        return result;
    }

    private void generateCombo(int targetK, int first, int[] nums, LinkedList<List<Integer>> output, List<Integer> curr) {
        if (curr.size() == targetK) {
            output.add(new ArrayList<>(curr));
        }

        for (int i = first; i < nums.length; i++) {
            if (i != first && nums[i] == nums[i - 1]) {
                continue;
            }
                curr.add(nums[i]);

                generateCombo(targetK, i + 1, nums, output, curr);


                curr.remove(curr.size() - 1);


        }
    }


    public static void main(String[] args) {
        List<List<Integer>> subsets = new Subsets2().subsetsWithDup(new int[]{1, 2, 2});
        System.out.println(subsets);
    }
}
