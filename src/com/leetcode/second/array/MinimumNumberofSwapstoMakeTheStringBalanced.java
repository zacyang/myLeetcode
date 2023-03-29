package com.leetcode.second.array;

public class MinimumNumberofSwapstoMakeTheStringBalanced {
    public int minSwaps(String s) {
        char[] chars = s.toCharArray();

        int balancedCounter = 0;
        int max = 0;
        for (char aChar : chars) {
            if(aChar == '[') {
                balancedCounter--;
            } else {
                balancedCounter++;
            }

            max = Math.max(max, balancedCounter);
        }

        return (max+1) /2;
    }

    public static void main(String[] args) {
        int i = new MinimumNumberofSwapstoMakeTheStringBalanced().minSwaps("][][");
        System.out.println(i);
    }
}
