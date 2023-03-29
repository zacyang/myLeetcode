package com.leetcode.second.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> register = new HashMap<>();
        for (String str : strs) {

            char[] a = str.toCharArray();
            Arrays.sort(a);
            String sortedKey = new String(a);
            List<String> content = register.getOrDefault(sortedKey, new LinkedList<>());
            content.add(str);
            register.put(sortedKey, content);
        }


        return register.keySet().stream().map(k -> register.get(k)).collect(Collectors.toList());

    }
}
