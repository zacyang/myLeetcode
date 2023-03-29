package com.leetcode.second.dp;

import java.util.*;

public class WordBreak {
    private Integer start;
//    public boolean wordBreak(String s, List<String> wordDict) {
//        return wordBreakRecur(s, new HashSet<>(wordDict), 0);
//    }
//    private boolean wordBreakRecur(String s, Set<String> wordDict, int start) {
//        if (start == s.length()) {
//            return true;
//        }
//        for (int end = start + 1; end <= s.length(); end++) {
//            if (wordDict.contains(s.substring(start, end)) && wordBreakRecur(s, wordDict, end)) {
//                return true;
//            }
//        }
//        return false;
//    }

    public boolean wordBreak(String s, List<String> wordDict) {
        char[] chars = s.toCharArray();
        Set<String> wordDicSet = new HashSet<>(wordDict);

        Queue<Integer> frontierIndex = new LinkedList<>();
        Set<Integer> visitedStartIndex = new HashSet<>();
        frontierIndex.add(0);
        while (!frontierIndex.isEmpty()) {
            Integer start = frontierIndex.poll();
            if(visitedStartIndex.contains(start)){
                continue;
            }
//            BFS
            for (int end = start + 1; end <= chars.length; end++) {

                if (wordDicSet.contains(s.substring(start, end))) {
                    frontierIndex.add(end);

                    if (end == chars.length) {
                        return true;
                    }
                }
            }

            visitedStartIndex.add(start);

        }
        return false;
    }
}
