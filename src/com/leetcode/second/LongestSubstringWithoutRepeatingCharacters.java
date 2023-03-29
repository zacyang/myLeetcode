package com.leetcode.second;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Character> seenBefore = new HashMap<>();
        int longest = 0;
        int currentStartingPoint = 0;
        if(s.length() ==0) {
            return 0;
        }
        for (int i = 0; i < chars.length; i++) {

            while(seenBefore.get(chars[i]) !=null) {
                seenBefore.remove(chars[currentStartingPoint]);
                currentStartingPoint ++;
            }

            seenBefore.put(chars[i], chars[i]);

            longest = Math.max(i - currentStartingPoint+1, longest);

        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"));
    }
}
