package com.leetcode.second.array;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {

        Map<Character, Character> sourceTarget = new HashMap<>();
        Map<Character, Character> targetSource = new HashMap<>();

        char[] source = s.toCharArray();
        char[] targetChars = t.toCharArray();


        for (int i = 0; i < targetChars.length; i++) {
            char targetChar = targetChars[i];
            if (targetChar == source[i]) {
                sourceTarget.put(source[i], targetChar);
                targetSource.put(targetChar, source[i]);
            } else {

//                check current
                if (sourceTarget.containsKey(source[i]) || targetSource.containsKey(targetChar)) {

                    Character replacedSourceTarget = sourceTarget.get(source[i]);
                    Character replacedTargetSource = targetSource.get(targetChar);
                    if (replacedSourceTarget != replacedTargetSource) {
                        return false;
                    }

                } else {
//                replace

                    sourceTarget.put(source[i], targetChar);
                    targetSource.put(targetChar, source[i]);
                }

            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean isomorphic = new IsomorphicStrings().isIsomorphic("badc", "baba");
        System.out.println(isomorphic);
    }

}
