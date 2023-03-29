package com.leetcode.second.backtracking;

import java.util.LinkedList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        int[] candidates = new int[n];


        for (int i = 0; i < candidates.length; i++) {
            candidates[i] = i +1;
        }


        backTracking(0, k, result, candidates, new LinkedList<>());
        return result;

    }

    private void backTracking(int current, int k, LinkedList<List<Integer>> result, int[] candidates, LinkedList<Integer> picks) {

        if(picks.size() == k) {
            result.add(new LinkedList<>(picks));
            return;
        }

        for (int i = current; i < candidates.length; i++) {

            picks.add(candidates[i]);
            backTracking(i+1, k, result, candidates, picks);
            picks.removeLast();
        }

    }
}
