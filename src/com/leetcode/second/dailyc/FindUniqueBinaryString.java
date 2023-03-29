package com.leetcode.second.dailyc;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindUniqueBinaryString {
    public String findDifferentBinaryString(String[] nums) {
//        sort
        Arrays.sort(nums);
        Set<String> numsList = Arrays.stream(nums).collect(Collectors.toSet());
//        start from 0, binary +1 until not find

        String target = nums[0];
        while(numsList.contains(target)) {
            target = binaryPlus(target, 1);
        }

        return target;
    }

    private String binaryPlus(String target, int i) {
        int intValue = toInt(target);
        return toBinary(intValue+1);

    }

    private String toBinary(int i) {
        return null;
    }

    private int toInt(String target) {
        int length = target.length();
        int current = 0;
        int result = 0;


        return 0;
    }
}
