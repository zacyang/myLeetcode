package com.leetcode.second.twopointer;

import java.util.LinkedList;
import java.util.Queue;

public class MoveZeroes {
    public void moveZeroes1(int[] nums) {

        Queue<Integer> q = new LinkedList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                q.add(nums[i]);
            }


        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = q.isEmpty()? q.poll(): 0;
        }
    }
    public void moveZeroes(int[] nums) {
//        start from back <- front;

        int idx = 0;
        int swapingIdx = 0;


        while(swapingIdx < nums.length) {
            if(nums[swapingIdx]!=0) {
                nums[idx] = nums[swapingIdx];
                idx++;
            }

            swapingIdx++;
        }

        for (int i = idx; i < nums.length; i++) {
            nums[i] =0;
        }
    }

    public static void main(String[] args) {
        new MoveZeroes().moveZeroes(new int[]{0,0,1,2,3});
    }

}
