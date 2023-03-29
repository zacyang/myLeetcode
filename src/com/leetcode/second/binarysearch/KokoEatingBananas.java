package com.leetcode.second.binarysearch;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {

        int maxLenOfPile = findTheMaxFromPile(piles);

        int left = 1;
        int right = maxLenOfPile;
        while (left < right) {
            int midlle = (left + right) / 2;
            if (canFinishWithIn(midlle, piles, h)) {
                right = midlle;
            } else {
                left = midlle+1;
            }

        }
        return left;
    }

    private boolean canFinishWithIn(int targetSpeed, int[] piles, int h) {

        double finishedTime = 0;


        for (int pile : piles) {
            finishedTime += Math.ceil((double)pile/targetSpeed);
        }

        return finishedTime<= h;
    }

    private int findTheMaxFromPile(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(pile, max);
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(new KokoEatingBananas().minEatingSpeed(new int[]{312884470}, 312884469));
    }
}
