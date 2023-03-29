package com.leetcode.second.array;

import java.util.*;

public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<Integer>();
        HashMap<Integer, Integer> register = new HashMap<>();
        for (int i : nums2) {
            while (!stack.isEmpty() && stack.peek() < i) {
                Integer lastSamller
                        = stack.pop();
                register.put(lastSamller, i);
            }
            stack.push(i);
        }
        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            result[i] = register.getOrDefault(nums1[i], -1);
        }

        return result;
    }

    public static void main(String[] args) {
        new NextGreaterElementI().nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
    }
}
