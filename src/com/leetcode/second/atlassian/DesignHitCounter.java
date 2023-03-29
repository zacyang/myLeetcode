package com.leetcode.second.atlassian;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class DesignHitCounter {
    private final LinkedList<Integer> hitChache;
    private int currentTs;
    public DesignHitCounter() {
        this.hitChache = new LinkedList<>();
    }

    public void hit(int timestamp) {

        hitChache.addLast(timestamp);
    }

    public int getHits(int timestamp) {
        while(hitChache.getFirst() < timestamp - 300) {
            hitChache.removeFirst();
        }

        return hitChache.size();
    }

    public static void main(String[] args) {
        DesignHitCounter hitCounter = new DesignHitCounter();
        hitCounter.hit(1);       // hit at timestamp 1.
        hitCounter.hit(2);       // hit at timestamp 2.
        hitCounter.hit(3);       // hit at timestamp 3.
        hitCounter.getHits(4);   // get hits at timestamp 4, return 3.
        hitCounter.hit(300);     // hit at timestamp 300.
        hitCounter.getHits(300); // get hits at timestamp 300, return 4.
        hitCounter.getHits(301); // get hit
        System.out.println(hitCounter.getHits(301));
    }
}
