package com.leetcode.second.dailyc;

public class VerifyinganAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i + 1 < words.length; i++) {
            if (!isLexicoOrder(words[i], words[i + 1], order)) {
                return false;
            }
        }
        return true;
    }

    private boolean isLexicoOrder(String word1, String word2, String order) {
        int min = Math.min(word1.length(), word2.length());
        int examingIdx = 0;
        while (examingIdx <= min) {

            char c1 = word1.charAt(examingIdx);
            int c1LexiIdx = order.indexOf(c1);
            char c2 = word2.charAt(examingIdx);
            int c2LexiIdx = order.indexOf(c2);
            if (c1 != c2) {
                if (c1LexiIdx > c2LexiIdx) {
//                    don't care the rest
                    return false;
                } else {
                    return true;
                }
            }

            examingIdx++;
        }
        return word1.length() > word2.length() ? false: true;
    }

    public static void main(String[] args) {
//        boolean res = new VerifyinganAlienDictionary().isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz");
        boolean res = new VerifyinganAlienDictionary().isAlienSorted(new String[]{"word","world","row"}, "worldabcefghijkmnpqstuvxyz");
        System.out.println(res);
    }
}
