package com.leetcode.second.stackq;

import java.util.Stack;

public class LargestRectangleHistogram {
    public int largestRectangleArea(int[] heights) {
//        intuiation, you can only extend to the right if the right >= current, which makes it a monotomic increasing stack
        int maxArea = 0;

        Stack<int[]> stack = new Stack<>();

//        pop out any larger element in the stack , push into stack in the end
        for (int i = 0; i < heights.length; i++) {

            int start = i;
            while (!stack.isEmpty() && stack.peek()[0] > heights[i]) {
                int[] pop = stack.pop();
                start = pop[1];
//              calculate the area, that the high (in the stack top) can only extended to (exclude current i)
                maxArea = Math.max(pop[0] * (i-start), maxArea);
            }
            maxArea = Math.max(maxArea, heights[i]);
//            NOTE, you need to record the index of `start` of the possible index on the left, which updated by the while-> pop action,for later correctly calculate the area
//            as we need to find the smaller heigh's initial idx (not the first appreance in the original heights array)
            stack.push(new int[]{heights[i], start});
        }


//        note in the end, the result stack is a monotomic increasing stack, we need calculate it as well
//        all the element can extend to the end (as all the ones not match has been excluded from the stack , the bigger ones)
        int len = heights.length;
        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            maxArea = Math.max(maxArea, pop[0] *  (len - pop[1]));

        }
        return maxArea;
    }

    public static void main(String[] args) {
//        int i = new LargestRectangleHistogram().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
        int i = new LargestRectangleHistogram().largestRectangleArea(new int[]{2, 1, 2});
//        int i = new LargestRectangleHistogram().largestRectangleArea(new int[]{0, 9});
        System.out.println(i);
    }
}
