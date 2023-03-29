package com.leetcode.second.dailyc;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandom {
    private Map<Integer, Integer> register =new HashMap<Integer, Integer>();
    private LinkedList<Integer> list = new LinkedList<>();
    Random rand = new Random();
    public InsertDeleteGetRandom() {

    }

    public boolean insert(int val) {
        if(register.containsKey(val)) {
            return false;
        }
        list.addLast(val);

        register.put(val, list.size()-1);
        return true;
    }

    public boolean remove(int val) {
        if (! register.containsKey(val)) return false;

        // move the last element to the place idx of the element to delete
        int lastElement = list.get(list.size() - 1);
        int idx = register.get(val);
        list.set(idx, lastElement);
        register.put(lastElement, idx);
        // delete the last element
        list.remove(list.size() - 1);
        register.remove(val);
        return true;

    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
