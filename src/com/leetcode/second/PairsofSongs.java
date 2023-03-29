package com.leetcode.second;

import java.util.*;
import java.util.stream.Collectors;

public class PairsofSongs {
//    public int numPairsDivisibleBy60(int[] time) {
//
//        int count = 0;
//        Map<Integer, Integer> map = new HashMap<>();
//
//        for (int i = 0; i < time.length; i++) {
//
//            int key = time[i] % 60;
//            int pairedKey = key == 0 ? key : 60 - key;
//
//            count += map.getOrDefault(pairedKey, 0);
//
//            map.put(key, map.getOrDefault(key, 0) + 1);
//        }
//
//        return count;
//    }
    public int numPairsDivisibleBy60(int[] time) {
//        generate mod diff for all invividual songs
        Map<Integer, List<Integer>> modDiffRegister = new HashMap<>();
        for (int i = 0; i < time.length; i++) {
            int key = 60 - time[i] % 60;
            if (key == 60) {
                key = 0;
            }
            List<Integer> diffIdx = modDiffRegister.getOrDefault(key, new ArrayList<>());
            diffIdx.add(i);
            modDiffRegister.put(key, diffIdx);
        }
//        store in map  < diff, List<idx>>

//        loop thru the time, find the ball part if in dict
        int result = 0;
        for (int i = 0; i < time.length; i++) {
            int mod = time[i] % 60;
            final int idx = i;
            List<Integer> otherParts = modDiffRegister.get(mod);
            if (otherParts != null && !otherParts.isEmpty()) {
//                int laterSize = otherParts.stream().filter(op -> op > idx).collect(Collectors.toList()).size();
                int laterSize = 0;
                for (Integer otherPart : otherParts) {
                    laterSize += otherPart> idx ? 1:0;
                }
                result += laterSize;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int i = new PairsofSongs().numPairsDivisibleBy60(new int[]{
//                30, 20, 150, 100, 40
//        });

//        int i = new PairsofSongs().numPairsDivisibleBy60(new int[]{
//                60, 60, 60
//        });
        System.out.println((4/3)*3);


    }

}
