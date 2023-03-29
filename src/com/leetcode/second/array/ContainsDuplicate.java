package com.leetcode.second.array;

import java.util.HashMap;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> seenBefore = new HashMap<>();
        for (int num : nums) {
            if(seenBefore.get(num)!=null) {
                return true;
            }
            seenBefore.put(num, num);
        }
        return false;
    }
}
