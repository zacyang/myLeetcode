package com.leetcode.second.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        int n = nums.length;

        for (int i = 0; i <= n; i++) {
            generateCombo(i, 0, nums, result, new ArrayList<>());
        }

        return result;
    }

    private void generateCombo(int targetK, int first, int[] nums, LinkedList<List<Integer>> output, List<Integer> curr) {

        if (curr.size() == targetK) {
            output.add(new ArrayList(curr));
            return;
        }


        for (int i = first; i < nums.length; i++) {
            int num = nums[i];
            curr.add(num);
            generateCombo(targetK, i + 1, nums, output, curr);
            curr.remove(curr.size() - 1);
        }
    }


//
//    List<List<Integer>> output = new ArrayList();
//    int n, k;
//
//    public void backtrack(int targetK, int first, ArrayList<Integer> curr, int[] nums) {
//        // if the combination is done
//        if (curr.size() == targetK) {
//            output.add(new ArrayList(curr));
//            return;
//        }
//        for (int i = first; i < n; i++) {
//            // add i into the current combination
//            curr.add(nums[i]);
//            // use next integers to complete the combination
//            backtrack(targetK, i + 1, curr, nums);
//            // backtrack
//            curr.remove(curr.size() - 1);
//        }
//    }
//
//    public List<List<Integer>> subsets(int[] nums) {
//        n = nums.length;
//        for (k = 0; k < n + 1; k++) {
//            backtrack(k,0, new ArrayList<Integer>(), nums);
//        }
//        return output;
//    }


    public static void main(String[] args) {
        List<List<Integer>> subsets = new Subsets().subsets(new int[]{1, 2, 3});
        System.out.println(subsets);
    }
}
