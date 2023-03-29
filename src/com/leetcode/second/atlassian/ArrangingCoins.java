package com.leetcode.second.atlassian;

public class ArrangingCoins {
    public int arrangeCoins(int n) {
        long start= 0;
        long end= n;

        long k=0;
        while(start<= end) {
            k = start + (end - start)/2;
            long current = k * (k +1)/2;
            if(current ==n) {
                return (int)k;
            }

            if(current > n) {
                end = k-1;
            } else {
                start = k+1;
            }


        }
        return (int)end;
    }

    public static void main(String[] args) {
        int i = new ArrangingCoins().arrangeCoins(3);
        System.out.println(i);
    }
}
