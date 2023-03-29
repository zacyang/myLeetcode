package com.leetcode.second.backtracking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LetterCombinationsPhoneNumber {
    static Map<Integer, char[]> digitsToCharRegister = new HashMap<>();

    static {
        digitsToCharRegister.put(2, new char[]{'a', 'b', 'c'});
        digitsToCharRegister.put(3, new char[]{'d', 'e', 'f'});
        digitsToCharRegister.put(4, new char[]{'g', 'h', 'i'});
        digitsToCharRegister.put(5, new char[]{'j', 'k', 'l'});
        digitsToCharRegister.put(6, new char[]{'m', 'n', 'o'});
        digitsToCharRegister.put(7, new char[]{'p', 'q', 'r', 's'});
        digitsToCharRegister.put(8, new char[]{'t', 'u', 'v'});
        digitsToCharRegister.put(9, new char[]{'w', 'x', 'y', 'z'});

    }

    public List<String> letterCombinations(String digits) {

        int[] candidateNums = new int[digits.length()];
        char[] chars = digits.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            candidateNums[i] = chars[i] - '0';
        }

        LinkedList<String> result = new LinkedList<>();

        backTrack(0, candidateNums, result, new LinkedList<Character>());
        return result;
    }

    private void backTrack(int candidateIdx, int[] candidateNums, LinkedList<String> result, LinkedList<Character> currentCombo) {
        if (candidateIdx == candidateNums.length) {
            if (currentCombo.size() == 0) {
                return;
            }

            String oneComboStr = currentCombo.stream().map(String::valueOf).collect(Collectors.joining());

            result.add(oneComboStr);
            return;
        }

        char[] candidateChar = digitsToCharRegister.getOrDefault(candidateNums[candidateIdx], new char[]{});
        for (int i = 0; i < candidateChar.length; i++) {

            currentCombo.add(candidateChar[i]);

            backTrack(candidateIdx + 1, candidateNums, result, currentCombo);

            currentCombo.removeLast();
        }
    }

    public static void main(String[] args) {
        List<String> strings = new LetterCombinationsPhoneNumber().letterCombinations("23");
        System.out.println(strings);
    }

}
