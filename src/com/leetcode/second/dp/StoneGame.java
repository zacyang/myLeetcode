package com.leetcode.second.dp;

import java.util.HashMap;
import java.util.Map;

class StoneCache {
    int start ;
    int end;
    boolean fromStart;

    public StoneCache(int start, int end, boolean fromStart) {
        this.start = start;
        this.end = end;
        this.fromStart = fromStart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StoneCache)) return false;

        StoneCache that = (StoneCache) o;

        if (start != that.start) return false;
        if (end != that.end) return false;
        return fromStart == that.fromStart;
    }

    @Override
    public int hashCode() {
        int result = start;
        result = 31 * result + end;
        result = 31 * result + (fromStart ? 1 : 0);
        return result;
    }
}
public class StoneGame {
    private Map<StoneCache, Integer > cache = new HashMap<>();
    public boolean stoneGame(int[] piles) {
        int sum = 0;

//        only check alice is enough
        int start = 0;
        int end = 0;
        int aliceSum = Math.max(pickFromPile(start, end, piles, true), pickFromPile(start, end, piles, false));


        return aliceSum > sum / 2;
    }

    private int pickFromPile(int start, int end, int[] piles, boolean fromStart) {
        StoneCache key = new StoneCache(start, end, fromStart);
        if(cache.containsKey(key)) {
            return cache.get(key);
        } else {
            int result = 0;
            if (fromStart && start < piles.length) {
                int current = piles[start];
                int pickHead = current + Math.max(pickFromPile(start + 1, end - 1, piles, true), pickFromPile(start + 2, end, piles, true));
                int pickTail = current + Math.max(pickFromPile(start + 1, end - 1, piles, false), pickFromPile(start + 2, end, piles, true));
                 result = Math.max(pickHead, pickTail);
                return result;
            } else if(!fromStart && end >= 0){
                int current = piles[end];
                int pickHead = current + Math.max(pickFromPile(start +1, end - 1, piles, true), pickFromPile(start, end -2, piles, true));
                int pickTail = current +Math.max(pickFromPile(start + 1, end - 1, piles, false), pickFromPile(start , end -2, piles, true));
                 result = Math.max(pickHead, pickTail);

            }
            cache.put(key, result);
            return result;

        }

    }


}
