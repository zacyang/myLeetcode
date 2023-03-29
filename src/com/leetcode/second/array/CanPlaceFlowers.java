package com.leetcode.second.array;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int target = n;
//        brute force
        for (int i = 0; i < flowerbed.length; i++) {

            if (canPlace(flowerbed, i)) {
                target--;
                i++;
            }
        }
        return target <= 0;
    }

    private boolean canPlace(int[] flowerbed, int i) {
        if (i > 0 && i < flowerbed.length - 1) {
            return flowerbed[i] == 0 && flowerbed[i + 1] == flowerbed[i - 1] && flowerbed[i + 1] == 0;
        } else if (i == 0) {
            return flowerbed[i] == 0 && (i + 1 < flowerbed.length ? flowerbed[i + 1] == 0 : true);
        } else {
            return flowerbed[i] == 0 && (i-1 >= 0 ? flowerbed[i - 1] == 0: true);
        }
    }

    public static void main(String[] args) {
        System.out.println(new CanPlaceFlowers().canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
    }
}
