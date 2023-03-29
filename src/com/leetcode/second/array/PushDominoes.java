package com.leetcode.second.array;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class DominoesMeta {
    char value;
    int index;

    public DominoesMeta(char value, int index) {
        this.value = value;
        this.index = index;
    }
}

public class PushDominoes {
//    public String pushDominoes(String S) {
//        char[] A = S.toCharArray();
//        int N = A.length;
//        int[] forces = new int[N];
//
//        // Populate forces going from left to right
//        int force = 0;
//        for (int i = 0; i < N; ++i) {
//            if (A[i] == 'R') force = N;
//            else if (A[i] == 'L') force = 0;
//            else force = Math.max(force - 1, 0);
//            forces[i] += force;
//        }
//
//        // Populate forces going from right to left
//        force = 0;
//        for (int i = N-1; i >= 0; --i) {
//            if (A[i] == 'L') force = N;
//            else if (A[i] == 'R') force = 0;
//            else force = Math.max(force - 1, 0);
//            forces[i] -= force;
//        }
//
//        StringBuilder ans = new StringBuilder();
//        for (int f: forces)
//            ans.append(f > 0 ? 'R' : f < 0 ? 'L' : '.');
//        return ans.toString();
//    }
    public String pushDominoes(String S) {
        char[] A = S.toCharArray();
        int N = A.length;
        int[] forces = new int[N];
        int force = 0;
        for (int i = 0; i < A.length; i++) {
            char target = A[i];

            if(target=='R'){
                force = N;
            } else if (target=='L') {
                force =0 ;
            } else {
                force = Math.max(force-1, 0);
            }

            forces[i] += force;
        }

        force = 0;
        for (int i = A.length-1; i >= 0 ; i--) {
            char target = A[i];

            if(target =='L'){
                force = N;
            } else if (target =='R') {
                force =0;
            } else {
                force = Math.max(force-1, 0);
            }
            forces[i] = forces[i] - force;

        }

        StringBuilder ans = new StringBuilder();
        for (int f: forces)
            ans.append(f > 0 ? 'R' : f < 0 ? 'L' : '.');
        return ans.toString();
    }


    public static void main(String[] args) {
//        String s = new PushDominoes().pushDominoes("RR.L");
        String s = new PushDominoes().pushDominoes(".L.R...LR..L..");
        System.out.println(s);
    }
}
