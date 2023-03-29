package com.leetcode.second.twopointer;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int missingPartLarge = target - numbers[left];
            int missPartSmaller = target - numbers[right];


            if(missingPartLarge == numbers[right] || missPartSmaller == numbers[left] ) {
                break;
            }

            if(missingPartLarge > numbers[right] ) {
                left++;
            } else
            if(missPartSmaller < numbers[left]) {
                right--;
            }


        }
        return new int[]{left + 1, right + 1};
    }

    public static void main(String[] args) {
        int[] ints = new TwoSumII().twoSum(new int[]{2,3,4}, 6);
        System.out.println(ints[0] +"" + ints[1]);
    }
}
