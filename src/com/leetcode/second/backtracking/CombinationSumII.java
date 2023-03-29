package com.leetcode.second.backtracking;

import java.util.Arrays;
import java.util.Comparator;

import java.util.LinkedList;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        LinkedList<List<Integer>> result = new LinkedList<>();

        backTrack(0, target, candidates, result, new LinkedList<>(), 0);

        return result;
    }

    private void backTrack(int currentCheckIdx, int target, int[] candidates, LinkedList<List<Integer>> result, LinkedList<Integer> currentCombo, int currentSum) {
        if (currentSum == target) {
            result.add(new LinkedList<>(currentCombo));
            return;
        }
        if (currentCombo.size() == candidates.length) {
            return;
        }


        for (int i = currentCheckIdx; i < candidates.length; i++) {
            if (i != currentCheckIdx && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (currentSum > target) {
                continue;
            }
            currentCombo.add(candidates[i]);
            currentSum = currentSum + candidates[i];
            backTrack(i + 1, target, candidates, result, currentCombo, currentSum);
            currentCombo.removeLast();

            currentSum = currentSum - candidates[i];
        }

    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new CombinationSumII().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        System.out.println(lists);
//        new CombinationSumII().testParameterChange(1);
    }

    void testParameterChange(int i) {
        if (i == 10) {
            return;
        }
        System.out.println(i);
        i = i + 1;
        testParameterChange(i);

        System.out.println(i);
    }
}
