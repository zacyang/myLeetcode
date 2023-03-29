package com.leetcode.second.array;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {

//        validate

        if(s.length()< 10) {
            return Collections.emptyList();
        }
//        create a window of 10 in len, slid thru the s, put all substr (10) into the map
        int start = 0;
        int end = 10;
        Map<String, Integer> register = new HashMap<>();
        while (end <= s.length()) {

            String current = s.substring(start, end);
            Integer orDefault = register.getOrDefault(current, 0);
            register.put(current, orDefault+1);
            end++;
            start++;
        }


//        return keys that value > 1
        return register.keySet().stream().filter(

                k -> register.get(k) > 1
        ).collect(Collectors.toList());

    }

    public static void main(String[] args) {
        List<String> aaaaacccccaaaaaccccccaaaaagggttt = new RepeatedDNASequences().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        aaaaacccccaaaaaccccccaaaaagggttt.stream().forEach(s -> System.out.println(s));
    }
}
