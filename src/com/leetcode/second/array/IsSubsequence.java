package com.leetcode.second.array;

import java.util.*;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int leftP = 0;
        int rightP = 0;
        while(leftP < s.length() && rightP< t.length()) {
            if(s.charAt(leftP) == t.charAt(rightP)) {
//                found one move on
                leftP++;
            }
//            regardless the reresult , we need to check the next one
            rightP++;
        }
        return leftP==s.length();
    }
}
