package com.leetcode.second.array;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            seen.add(num);
        }

        int max = 0;
        for (int num : nums) {
            while (seen.contains(num - 1)) {
                num--;
            }

            int count = 0;
            while (seen.contains(num)) {
                seen.remove(num);
                num++;
                count++;

            }

            max = Math.max(max, count);
        }
        return max;

    }

    public static void main(String[] args) {
        int i = new LongestConsecutiveSequence().longestConsecutive(new int[]{9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6});
        System.out.println(i);
    }
}
