package com.leetcode.second.dailyc;

public class DeleteColumnstoMakeSorted {
    public int minDeletionSize(String[] strs) {

        Character c = null;
        int lastDeletedColumn = -1;
        int result = 0;
        for (int column = 0; column < strs[0].length(); column++) {

            for (int i = 0; i < strs.length; i++) {

                if (c != null && c > strs[i].charAt(column)) {
                    if (lastDeletedColumn != column) {
                        result++;
                        lastDeletedColumn = column;
                    }
                }

                if (i == strs.length - 1) {
                    c = null;
                } else {
                    c = strs[i].charAt(column);
                }

            }
        }
        return result;
    }

}
