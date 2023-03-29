package com.leetcode.second.dailyc;

public class MinimumTimeCompleteTrips {
    //  n = totalTrips- time.len
//    pick N from time where max(time ) is min
    public long minimumTime(int[] time, int totalTrips) {
        int maxTime = 0;
        for (int i : time) {
            maxTime = Math.max(i, maxTime);
        }
        int left = 1;
        int right = totalTrips * maxTime;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (canMakeTheTravel(middle, time, totalTrips)) {
                right = middle;
            } else {
                left = middle + 1;
            }

        }

        return left;
    }

    private boolean canMakeTheTravel(int givenTime, int[] time, int totalTrips) {
        int actualTravelNumber = 0;

        for (int t : time) {
            actualTravelNumber += givenTime / t;
        }

        return actualTravelNumber >= totalTrips;
    }

    public static void main(String[] args) {
        long l = new MinimumTimeCompleteTrips().minimumTime(new int[]{1, 2, 3}, 5);
        System.out.println(l);
    }
}
