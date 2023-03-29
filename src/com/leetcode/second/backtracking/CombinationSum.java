package com.leetcode.second.backtracking;

import java.util.*;
import java.util.stream.Collectors;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {



        List<List<Integer>> results = new ArrayList<List<Integer>>();
        LinkedList<Integer> comb = new LinkedList<Integer>();
         findSolution(candidates,0, target, results, comb);
return results;

    }

    private List<List<Integer>> dedup(List<List<Integer>> result) {
        Set<List<Integer>> uniq = new HashSet<>();
        for (List<Integer> integers : result) {
            uniq.add(integers);
        }
        return uniq.stream().toList();
    }

//    private void findSolution(int[] candidates, int reminderValue, List<List<Integer>> result, LinkedList<Integer> currentPick) {
//        if (reminderValue == 0) {
//            result.add(new LinkedList<>(currentPick.stream().sorted().collect(Collectors.toList())));
//            return;
//        }
//
//
//        for (int candidate : candidates) {
//            int nextRoundReminderValue = reminderValue - candidate;
//
//            if (nextRoundReminderValue >= 0) {
//                currentPick.add(candidate);
//                findSolution(candidates, nextRoundReminderValue, result, currentPick);
//                currentPick.removeLast();
//            }
//        }
//    }

    private void findSolution(int[] candidates, int start, int reminderValue, List<List<Integer>> result, LinkedList<Integer> currentPick) {
        if (reminderValue == 0) {
            result.add(new LinkedList<>(currentPick));
            return;
        } else if (reminderValue < 0) {
            return;
        }


        for (int i = start; i < candidates.length; ++i) {
            currentPick.add(candidates[i]);
            findSolution(candidates,i,  reminderValue - candidates[i], result, currentPick);
            currentPick.removeLast();

        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{100,200,4,12}, 400));
    }
}
