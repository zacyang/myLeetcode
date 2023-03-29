package com.leetcode.second.dp;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        if(word1.equals(word2)){
            return 0;
        }

        int w1Len = word1.length() + 1;
        int w2Len = word2.length() + 1;
        int[][] dpTable = new int[w1Len][w2Len];

        dpTable[0][0] = 0;

        for (int i = 0; i < dpTable.length; i++) {
            dpTable[i][0] = i;
        }
        for (int i = 0; i < dpTable[0].length; i++) {
            dpTable[0][i] = i;
        }

        for (int w1idx = 1; w1idx < w1Len; w1idx++) {
            for (int w2idx = 1; w2idx < w2Len; w2idx++) {
                int previousAsymetricMin = Math.min(dpTable[w1idx - 1][w2idx], dpTable[w1idx][w2idx - 1]);

                if(word1.charAt(w1idx-1) == word2.charAt(w2idx-1)) {
                    dpTable[w1idx][w2idx]= Math.min(previousAsymetricMin+1, dpTable[w1idx-1][w2idx-1]);
                } else {
                        //need to  do one of insert delete or remove
                    dpTable[w1idx][w2idx] = Math.min(previousAsymetricMin, dpTable[w1idx-1][w2idx-1]) +1;
                }

            }
        }


        return dpTable[w1Len-1][w2Len-1];

    }

    public static void main(String[] args) {
        int i = new EditDistance().minDistance("horse",
                "ros");
        System.out.println(i);
    }
}
