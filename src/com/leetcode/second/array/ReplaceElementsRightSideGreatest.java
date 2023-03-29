package com.leetcode.second.array;

public class ReplaceElementsRightSideGreatest {
    public int[] replaceElements(int[] arr) {
        int currentMax = -1;
        int[] result = new int[arr.length];
        result[arr.length-1] = -1;
        currentMax =arr[arr.length-1];
        for (int i = arr.length-2; i >=0; i--) {
            result[i] = currentMax;
            currentMax = Math.max(currentMax, arr[i]);

        }
        return result;
    }
}
