package com.leetcode.second.heap;

import java.util.Arrays;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] freqencyRegister = new int[26];
        for (char task : tasks) {
            freqencyRegister[task - 'A']++;
        }

        Arrays.sort(freqencyRegister);

        int maxFreqCount = freqencyRegister[25];


        int maxIdle = (maxFreqCount - 1) * n;

        int reminderIdle = maxIdle;
//        reduce maxIdle
        for (int i = freqencyRegister.length - 2; i >= 0 && reminderIdle>0; i--) {

            reminderIdle -= Math.min(maxFreqCount - 1, freqencyRegister[i]);
        }

        reminderIdle = Math.max(0, reminderIdle);
        return reminderIdle + tasks.length;
    }
}
