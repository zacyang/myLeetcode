package com.leetcode.second.atlassian;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {
    private Map<String, Integer> cache;

    public LoggerRateLimiter() {
        cache = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!cache.containsKey(message)) {
            cache.put(message, timestamp);
            return true;
        } else {
            Integer lastPrintTS = cache.get(message);

            if( lastPrintTS + 10 <= timestamp ) {
                cache.put(message, lastPrintTS + 10 );
                return true;
            }
            return false;
        }

    }

    public static void main(String[] args) {
        LoggerRateLimiter logger = new LoggerRateLimiter();

        logger.shouldPrintMessage(1, "foo");  // return true, next allowed timestamp for "foo" is 1 + 10 = 11
        logger.shouldPrintMessage(2, "bar");  // return true, next allowed timestamp for "bar" is 2 + 10 = 12
        logger.shouldPrintMessage(3, "foo");  // 3 < 11, return false
        logger.shouldPrintMessage(8, "bar");  // 8 < 12, return false
        logger.shouldPrintMessage(10, "foo"); // 10 < 11, return false
        logger.shouldPrintMessage(11, "foo"); // 11 >= 11, return true, next allowed timestamp for "foo" is 11 + 10 = 21
    }
}
