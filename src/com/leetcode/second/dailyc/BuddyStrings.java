package com.leetcode.second.dailyc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BuddyStrings {
    public boolean buddyStrings(String s1, String s2) {
//        O(N)

        if (s1.length() != s2.length()) {
            return false;
        }

        int numberOfDiff = 0;
        int numberOfDup = 1;
        Map<Character, Integer> register = new HashMap<>();
        Set<Character> dupset = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            if (dupset.contains(s1.charAt(i))) {
                numberOfDup++;
            } else {

                dupset.add(s1.charAt(i));
            }
            if (s1.charAt(i) != s2.charAt(i)) {
                register.compute(s1.charAt(i), (k, v) -> register.getOrDefault(k, 0) +1);
                register.compute(s2.charAt(i), (k, v) -> register.getOrDefault(k, 0) -1);
                numberOfDiff++;
            }
        }
        return numberOfDiff == 2 && register.keySet().stream().allMatch(k -> register.getOrDefault(k, 0) == 0) || numberOfDiff == 0 && numberOfDup >= 2;
    }

    public static void main(String[] args) {
        boolean b = new BuddyStrings().buddyStrings("ab", "ab");
        System.out.println(b);
    }
}
