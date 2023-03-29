package com.leetcode.second;

import java.util.ArrayList;
import java.util.List;

public class TrappingRainWater {
    public int trap(int[] height) {


        int[] leftmax = new int[height.length];
        leftmax[0] = height[0];

        for (int i = 1; i < height.length; i++) {
            leftmax[i] = Math.max(height[i], leftmax[i - 1]);
        }

        int[] rightMax = new int[height.length];
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i > 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        int result = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int lowerBound = Math.min(leftmax[i], rightMax[i]);

            result += lowerBound - height[i];
        }
        return result;

    }
//    public int trap(int[] height) {
//        int currentAnchorInx = 0;
//        int allWaterTrapped = 0;
//        for (int i = 0; i < height.length; i++) {
//            if(currentAnchorInx==-1) {
//                break;
//            }
//            if ((currentAnchorInx < height.length - 2) && height[currentAnchorInx + 1] > height[currentAnchorInx]) {
//                currentAnchorInx++;
//            }
//            int rightBarrier = findNextHigherIndex(currentAnchorInx, height);
//            if (rightBarrier < 0) {
////                desc order
//                rightBarrier = findSecondHighest(currentAnchorInx, height);
//            }
//            int currentWaterHoldingCapacity = calculateWater(currentAnchorInx, rightBarrier, height);
//            allWaterTrapped += currentWaterHoldingCapacity;
//            currentAnchorInx = rightBarrier;
//        }
//        return allWaterTrapped;
//    }
//
//    private int findSecondHighest(int currentAnchorInx, int[] height) {
//        if (currentAnchorInx >= height.length - 2) {
//            return -1;
//        }
//        int currentMax=0;
//        int currentMaxInx=0;
//        for (int i = currentAnchorInx + 1; i < height.length; i++) {
//            if(height[i]> currentMax) {
//                currentMax = height[i];
//                currentMaxInx= i;
//            }
//
//        }
//        return currentMaxInx;
////        for (int i = currentAnchorInx + 1; i < height.length; i++) {
////            if (height[i] < height[i + 1]) {
////                return i + 1;
////            } else {
////                return i;
////            }
////        }
////        return -1;
//    }
//
//    private int calculateWater(int currentAnchorInx, int nextHiIndx, int[] height) {
//        if (currentAnchorInx == -1 || nextHiIndx == -1) {
//            return 0;
//        }
//        int topWaterLevel = Math.min(height[currentAnchorInx], height[nextHiIndx]);
//        int result = 0;
//        for (int i = currentAnchorInx + 1; i < nextHiIndx; i++) {
//            result += topWaterLevel - height[i];
//        }
//        return result;
//    }
//
//    private int findNextHigherIndex(int currentAnchorInx, int[] height) {
//
//        for (int i = currentAnchorInx + 2; i < height.length; i++) {
//
//            if (height[i] >= height[currentAnchorInx]) {
//                return i;
//
//            }
//        }
//        return -1;
//    }

    public static void main(String[] args) {
//        System.out.println(new TrappingRainWater().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(new TrappingRainWater().trap(new int[]{0, 7, 1, 4, 6}));
    }
}
