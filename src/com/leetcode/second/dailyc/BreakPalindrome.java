package com.leetcode.second.dailyc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BreakPalindrome {
    public String breakPalindrome(String palindrome) {
        int length = palindrome.length();
        if (length <= 1) {
            return "";
        }
        char[] palindromeArray = palindrome.toCharArray();
        for (int i = 0; i < palindromeArray.length/2; i++) {
            if(palindromeArray[i] !='a') {
                palindromeArray[i] ='a';
            return new String(palindromeArray);
            }
        }

//        at this point there are 1 possible, that is all chars =='a' including this last one, so simple replace it to highest lexicon
        palindromeArray[length-1] = 'b';
        return new String(palindromeArray);

    }
    public String breakPalindrome1(String palindrome) {
        int length = palindrome.length();
        if (length == 1) {
            return "";
        }
        // Strings are immutable in Java, convert it into a char array
        char[] palindromeArray = palindrome.toCharArray();

        for (int i = 0; i < length / 2; i++) {
            if (palindromeArray[i] != 'a') {
                palindromeArray[i] = 'a';
                return String.valueOf(palindromeArray);
            }
        }

        palindromeArray[length - 1] = 'b';
        return String.valueOf(palindromeArray);
    }
//    public String breakPalindrome(String palindrome) {
//        char[] chars = palindrome.toCharArray();
//        char[] atoz = new char[26];
//        if (palindrome.length() <= 1) {
//            return "";
//
//        }
//        for (int i = 0; i < atoz.length; i++) {
//            atoz[i] = (char) ('a' + i);
//        }
//        List<String> result = new ArrayList<>();
//        for (int i = 0; i < chars.length; i++) {
//            for (int replacementIdx = 0; replacementIdx < atoz.length; replacementIdx++) {
//
////                not parilidm TOOD, check if it is the middle
//
//
//                if (atoz[replacementIdx] != chars[i] && atoz[replacementIdx] != chars[chars.length - 1 - i]) {
//                    if (chars.length % 2 != 0 && i == chars.length / 2) {
//                        continue;
//                    }
//                    char[] newChars = Arrays.copyOf(chars, chars.length);
//                    newChars[i] = atoz[replacementIdx];
//                    result.add(new String(newChars));
//                }
//
//            }
//        }
//
//        result.sort(Comparator.naturalOrder());
//        return result.get(0);
//    }

    public static void main(String[] args) {
        String abccba = new BreakPalindrome().breakPalindrome("aa");
        System.out.println(abccba);
    }
}
