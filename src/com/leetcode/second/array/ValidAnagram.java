package com.leetcode.second.array;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) {
            return false;
        }

        int[] chartable = new int[26];

        char[] sourceArray = s.toCharArray();
        for (int i = 0; i < sourceArray.length; i++) {
            chartable[sourceArray[i] - 'a'] +=1;
        }


        char[] targetArray = t.toCharArray();
        for (int i = 0; i < targetArray.length; i++) {
            chartable[targetArray[i]-'a'] -=1;
        }

        for (int i : chartable) {
            if(i!=0) {
                return false;
            }
        }

        return true;
    }
}
