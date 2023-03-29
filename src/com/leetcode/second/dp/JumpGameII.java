package com.leetcode.second.dp;

public class JumpGameII {

    public int jump(int[] nums) {

        int result = 0;
        int current = 0;
        int furtherst = 0;
        for (int i = 0; i < nums.length-1; i++) {
            furtherst = Math.max(furtherst, i+ nums[i]);


            if(i == current) {
                result++;
                current = furtherst;
            }

       }
        return result;
    }

    public static void main(String[] args) {
//        int jump = new JumpGameII().jump(new int[]{2, 3, 1, 1, 4});
        int jump = new JumpGameII().jump(new int[]{2, 3, 1, 1, 4});
        System.out.println(jump);
    }
}
