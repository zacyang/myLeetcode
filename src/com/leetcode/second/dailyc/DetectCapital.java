package com.leetcode.second.dailyc;

public class DetectCapital {
    public boolean detectCapitalUse(String word) {

        char[] chars = word.toCharArray();

        if(Character.isUpperCase(chars[0])) {
            return allInUpperCase(chars) || allInLowerCase(chars);
        }


        return allInLowerCase(chars);
    }

    private boolean allInUpperCase(char[] chars) {
        for (int i = 1; i < chars.length; i++) {
            if(!Character.isUpperCase(chars[i])) {
                return false;
            }
        }
        return true;
    }
    private boolean allInLowerCase(char[] chars) {
        for (int i = 1; i < chars.length; i++) {
            if(!Character.isLowerCase(chars[i])) {
                return false;
            }
        }
        return true;
    }
}
