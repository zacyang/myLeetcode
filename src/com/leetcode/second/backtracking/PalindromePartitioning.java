package com.leetcode.second.backtracking;

import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        LinkedList<List<String>> result = new LinkedList<>();
        int currentStart = 0;
        backTracking(currentStart, s, result, new LinkedList<>());
        return result;
    }

    private void backTracking(int currentStart, String s, LinkedList<List<String>> result, LinkedList<String> currentParition) {
        if(currentStart == s.length()) {
            result.add(new LinkedList<>(currentParition));
            return;
        }

//        pick the index that can form a palindrome, then cut the string and got to next

        for (int i = currentStart; i < s.length(); i++) {
            String parition = s.substring(currentStart, i+1);
            if (isPalindrome(parition)) {
                currentParition.add(parition);

                backTracking(i+1 , s, result, currentParition);

                currentParition.removeLast();
            }
        }

    }

    private boolean isPalindrome(String target) {
        int start= 0;
        int end = target.length()-1;
        while(start<= end ) {
            if(target.charAt(start)!= target.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> aab = new PalindromePartitioning().partition("aab");
        System.out.println(aab);
//        System.out.println("ab".substring(0,2));
    }
}
