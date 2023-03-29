package com.leetcode.second.atlassian;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class RankTeamsbyVotes {

    public String rankTeams(String[] votes) {
        Map<Character, int[]> register = new HashMap<>();


        for (String vote : votes) {
            char[] chars = vote.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int[] orDefault = register.getOrDefault(chars[i], new int[vote.length()]);
                orDefault[i]++;
                register.put(chars[i], orDefault);
            }
        }

        Stream<Character> sorted = register.keySet().stream().sorted((o1, o2) -> {
            int[] v1 = register.get(o1);
            int[] v2 = register.get(o2);
            int comparsionIdx = 0;
            while (v1[comparsionIdx] == v2[comparsionIdx] && comparsionIdx< v1.length) {
                comparsionIdx++;
            }

            int diff =  comparsionIdx< v1.length ?v2[comparsionIdx] -v1[comparsionIdx] :0;
            return diff == 0 ? o1 - o2 : diff;
        });



        String collect = sorted.map(k -> k.toString()).collect(Collectors.joining());



        return collect;
    }


    public static void main(String[] args) {
        String s = new RankTeamsbyVotes().rankTeams(new String[]{"WXYZ", "XYZW"});
        System.out.println(s);
    }

}
