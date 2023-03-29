package com.leetcode.second.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.function.BiFunction;

public class ReorganizeString {
    public String reorganizeString(String s) {
//        create a Q ordered by ferqency
// while Q not empty, pick the most frequent one & it's not the last in result
//        if it is in result pick the next most frequnt elment
//        update the Q

        HashMap<Character, Integer> register = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            register.put(aChar, register.getOrDefault(aChar, 0) + 1);
        }

        PriorityQueue<Character> candidateQ = new PriorityQueue<>((o1, o2) -> register.get(o2) - register.get(o1));


        for (Character character : register.keySet()) {
            candidateQ.offer(character);
        }


        LinkedList<Character> resultList = new LinkedList<>();
        while (resultList.size() < s.length()) {
            Character mostFreqenctChar = candidateQ.poll();
            if (register.get(mostFreqenctChar) <= 0) {
                break;
            }
            if (!resultList.isEmpty() && resultList.peekLast().equals(mostFreqenctChar)) {

                Character secondMostFreqChar = candidateQ.poll();
                if(secondMostFreqChar == null || register.get(secondMostFreqChar) ==0) {
//                    no more choice
                    return "";
                }
                register.compute(secondMostFreqChar, (character, integer) -> integer - 1);

                candidateQ.offer(secondMostFreqChar);
                candidateQ.offer(mostFreqenctChar);
                resultList.addLast(secondMostFreqChar);
            } else {
                resultList.addLast(mostFreqenctChar);
                register.compute(mostFreqenctChar, (character, integer) -> integer - 1);
                candidateQ.offer(mostFreqenctChar);
            }


        }

        StringBuilder result = new StringBuilder();
        for (Character character : resultList) {
            result.append(character);
        }

        return result.toString();
    }

    public static void main(String[] args) {
//        String aab = new ReorganizeString().reorganizeString("aab");
        String aab = new ReorganizeString().reorganizeString("bbbbbbb");
//        String aab = new ReorganizeString().reorganizeString("aaab");
        System.out.println(aab);
    }

}
