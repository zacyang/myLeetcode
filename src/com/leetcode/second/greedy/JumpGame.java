package com.leetcode.second.greedy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.jar.JarEntry;

enum  State{
    OK,
    NO,
    UNKNOWN
}
public class JumpGame {
    private State[] cache  = new State[]{};

    public boolean canJump(int[] nums) {
        int knownLeftestGoodPosition = nums.length-1;
        for (int i = nums.length-1; i >=0; i--) {
            if(i + nums[i]>= knownLeftestGoodPosition) {
                knownLeftestGoodPosition = i;
            }
        }
        return knownLeftestGoodPosition == 0;
    }

    public static void main(String[] args) {
        boolean b = new JumpGame().canJump(new int[]{2, 3, 1, 1, 4});
        System.out.println(b);
    }
}
