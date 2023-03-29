package com.leetcode.second.window;

import java.util.*;

//LC 567
public class PermutationString {
    public boolean checkInclusion(String s1, String s2) {
        int targetLen = s1.length();
        char[] a = s1.toCharArray();
        Arrays.sort(a);
        String targetString = new String(a);

        if(s2.length()< s1.length()) {
            return  false;
        }

        for (int i = 0; i <= s2.length() -targetLen; i++) {

            String substring = s2.substring(i, i + targetLen);
            if(isPermutation(substring, targetString)) {
                return true;
            }
        }
        return false;
    }

    private boolean isPermutation(String substring, String s1) {
        char[] a = substring.toCharArray();
        Arrays.sort(a);
        return new String(a).equals(s1);


    }


    public static void main(String[] args) {
        boolean permutation = new PermutationString().checkInclusion("ab", "eidbaooo");
        System.out.println(permutation);
    }
}
