package com.leetcode.second.twopointer;

public class TrappingRainWater {
    public int trap(int[] height) {
//        for each point, get the left max and right max
        int[] leftMAX = new int[height.length];
        leftMAX[0] = height[0];


        for (int i = 1; i < height.length; i++) {

            leftMAX[i] = Math.max(leftMAX[i-1], height[i]);;
        }


//        for each point, get the right max
        int[] rightMax = new int[height.length];
        rightMax[height.length-1] =height[height.length-1];

        for (int i = height.length-2; i > 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

//        calculate the water can be hold per point

        int result = 0;

        for (int i = 1; i < height.length-1; i++) {
            int sideMin = Math.min(leftMAX[i], rightMax[i]);
            int tmp = sideMin - height[i];
            result +=tmp;
        }

        return result;
    }

    public static void main(String[] args) {
        int trap = new TrappingRainWater().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(trap);
    }
}
