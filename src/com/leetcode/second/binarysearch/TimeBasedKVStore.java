package com.leetcode.second.binarysearch;

import java.util.*;
import java.util.stream.Collectors;


public class TimeBasedKVStore {

    private final Map<String, TreeMap<Integer, String>> internalStore;

    public TimeBasedKVStore() {
        internalStore = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> orDefault = internalStore.getOrDefault(key, new TreeMap<>());
        orDefault.put(timestamp, value);

        internalStore.put(key, orDefault);
    }

    public String get(String key, int timestamp) {
        if(!internalStore.containsKey(key)) {
            return "";
        }

        TreeMap<Integer, String> integerStringTreeMap = internalStore.get(key);
        Integer integer = integerStringTreeMap.floorKey(timestamp);
        if(integer!=null) {
            return integerStringTreeMap.get(integer);
        } else {
            return "";
        }

    }

    public static void main(String[] args) {
        TimeBasedKVStore timeBasedKVStore = new TimeBasedKVStore();
        timeBasedKVStore.set("foo", "bar",1);
        System.out.println(timeBasedKVStore.get("foo", 1));
        System.out.println(timeBasedKVStore.get("foo", 3));
        timeBasedKVStore.set("foo", "bar2",4);
        System.out.println(timeBasedKVStore.get("foo", 3));
    }
}
