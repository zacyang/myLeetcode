package com.leetcode.second.dailyc;

public class GuessNumberHigherLower {
    private int guess(int num) {
        return num - 4;
    }

    public int guessNumber(int n) {
        int low = 1;
        int high = n;

        while(low<= high) {
            int mid = low + (high - low) / 2;
            int guess = guess(mid);
            if(guess == 0) {
                return mid;
            }
            if(guess>0) {
                high = mid-1;
            } else {
                low = mid+1;

            }
        }

        return -1;


    }

    public static void main(String[] args) {
        int guess = new GuessNumberHigherLower().guessNumber(10);
        System.out.println(guess);

    }
}
