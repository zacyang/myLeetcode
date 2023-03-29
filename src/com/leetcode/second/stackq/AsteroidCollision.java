package com.leetcode.second.stackq;

import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> register = new Stack<Integer>();
        for (int i =0; i < asteroids.length ; i++) {

            int currentAstroidSize = asteroids[i];
            boolean totalAnnilation =false;
            while(!register.isEmpty() && isColliding(currentAstroidSize, register.peek()) ) {

                Integer prevSize = register.pop();
                int prevAbs = Math.abs(prevSize);
                int currentAbs = Math.abs(currentAstroidSize);
                if(prevAbs -currentAbs ==0){
                    totalAnnilation = true;
                    break;
                }

                if (prevAbs > currentAbs) {
                    currentAstroidSize =prevSize;
                } else if (currentAbs > prevAbs) {
                    currentAstroidSize =currentAstroidSize;
                }
            }
            if(!totalAnnilation) {
                register.push(currentAstroidSize);
            }


            // register.push(asteroids[i]);
        }
        int[] result = new int[register.size()];

        int currentIdx = register.size()-1;
        while (!register.isEmpty()) {
            result[currentIdx] = register.pop();
            currentIdx--;
        }

        return result;
    }

    private boolean isColliding(int currentAstroidSize, Integer prev) {
         if(prev > 0 && currentAstroidSize<0){
             return true;
         }
         return false;
    }

    public static void main(String[] args) {
        int[] ints = new AsteroidCollision().asteroidCollision(new int[]{8, -8});
//        System.out.println(System.currentTimeMillis());
//        int[] ints = new AsteroidCollision().asteroidCollision(new int[]{10,2,-5});
//        int[] ints = new AsteroidCollision().asteroidCollision(new int[]{-2,-1,1,2});
//        System.out.println(System.currentTimeMillis());
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
