package com.leetcode.second.array;

import jdk.jshell.EvalException;

import java.util.*;
import java.util.stream.Collectors;

public class FindAllDuplicatesArray {
//    public List<Integer> findDuplicates(int[] nums) {
//        HashMap<Integer, Integer> seen = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            Integer value = seen.getOrDefault(nums[i], 0);
//            seen.put(nums[i], value ++);
//        }
//
//        return seen.keySet().stream().filter(k -> seen.get(k) ==2).collect(Collectors.toList());
//    }

//    public List<Integer> findDuplicates(int[] nums) {
//        Arrays.sort(nums);
//
//        List<Integer> result = new LinkedList<>();
//        for (int i = 0; i < nums.length - 1; i++) {
//
//            if (nums[i] == nums[i + 1]) {
//                result.add(nums[i]);
//            }
//        }
//        return result;
//
//    }
public List<Integer> findDuplicates(int[] nums) {
    List<Integer> ans = new ArrayList<>();
    for (int num : nums) {

        if(nums[Math.abs(num) -1] < 0) {
//            visited before thus 2nd time
            ans.add(Math.abs(num));
        }
        nums[Math.abs(num) -1] *= -1;
    }

    return ans;
}

    public static void main(String[] args) {
        new FindAllDuplicatesArray().findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
    }
}
