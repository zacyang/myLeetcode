package com.leetcode.second.dailyc;

import java.util.HashMap;
import java.util.Map;

public class UniqueMorseCodeWords {
    private String[] morseCode = new String[]{
            ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
    };

    public int uniqueMorseRepresentations(String[] words) {
        Map<String, Integer> register = new HashMap<>();

        for (String word : words) {
            String result = "";
            for (char c : word.toCharArray()) {
                String s = morseCode[c - 'a'];

                result += s;
            }
            register.compute(result, (k, v)-> register.getOrDefault(k, 0)+1);

        }
        return register.keySet().size();

    }
}
