package com.leetcode.second.stackq;

import java.util.Stack;

public class OneTwoThreePattern {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        int[] minRegister = new int[nums.length];

        minRegister[0] = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            minRegister[i] = Math.min(minRegister[i - 1], nums[i-1]);
        }
//        record the min on the left side of itself , inclusive


//        reverse order put nums in to mono stack and find the exncresed one
//        compare the pop() out idx's min, if it is left_min < pop()
//        then the condition is matched. return true
        for (int i = nums.length - 1; i > 0; i--) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                Integer previousSmall = stack.pop();
                if(nums[previousSmall] > minRegister[i] ) {
                    return true;
                }
            }
            stack.push(i);
        }

        return false;
    }

    public static void main(String[] args) {
//        boolean pattern = new OneTwoThreePattern().find132pattern(new int[]{1, 2, 3, 4});
//        boolean pattern = new OneTwoThreePattern().find132pattern(new int[]{1,0,1,-4,-3});
        boolean pattern = new OneTwoThreePattern().find132pattern(new int[]{3,1,4,2});
        System.out.println(pattern);

    }
}
