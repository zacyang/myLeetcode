package com.leetcode.second;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RemoveDuplicatesSortedArray {
    public int removeDuplicates(int[] nums) {

        Set<Integer> seen = new HashSet<>();
        int lastSortedIdx = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!seen.contains(nums[i])) {
                seen.add(nums[i]);
                nums[lastSortedIdx] = nums[i];
                lastSortedIdx += 1;
            }
        }

        return lastSortedIdx;
    }

    public int removeDuplicates2(int[] nums) {
        int lastSortedIdx = 0;
        int currentLookingIdx = 0;


       while(currentLookingIdx< nums.length) {
           int currentLookingNum = nums[currentLookingIdx];
           nums[lastSortedIdx] = currentLookingNum;


           while(currentLookingIdx<nums.length -1 && currentLookingNum == nums[currentLookingIdx]) {
               currentLookingIdx++;
           }

           lastSortedIdx++;
           if(currentLookingIdx==nums.length-1){
               break;
           }


       }
        return lastSortedIdx;
    }


    public static void main(String[] args) {
//        int i = new RemoveDuplicatesSortedArray().removeDuplicates(new int[]{1, 1, 2});
        int i = new RemoveDuplicatesSortedArray().removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
        System.out.println(i);
    }
}
