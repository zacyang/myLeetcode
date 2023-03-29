package com.leetcode.second.array;

import java.util.LinkedList;
import java.util.Queue;

public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                shift(arr, i);
                i++;
            }
        }
    }

    private void shift(int[] arr, int start) {
        for (int i = arr.length-2; i >= start; i--) {
            arr[i+1] = arr[i];
        }
    }

    public void duplicateZeros2(int[] arr) {
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<arr.length; i++){
            q.add(arr[i]);

            if(arr[i] == 0)
                q.add(0);

            if(q.size()==arr.length) {
                break;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i]=q.poll();
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        new DuplicateZeros().duplicateZeros(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
