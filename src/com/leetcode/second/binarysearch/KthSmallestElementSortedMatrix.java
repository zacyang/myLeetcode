package com.leetcode.second.binarysearch;

import java.util.*;

public class KthSmallestElementSortedMatrix {
//    public int kthSmallest(int[][] matrix, int k) {
////     merge matrix into 1D array
//
//        int[] matrixSubArrayIndexes = new int[matrix.length];
//
//        int subArrayLen = matrix[0].length;
//        List<Integer> sorted = new ArrayList<>();
//
//
//        while (sorted.size() < matrix.length * matrix[0].length) {
//
//            for (int i = 0; i < matrix.length; i++) {
//                int smallestIndex = 0;
//                int smallest = Integer.MAX_VALUE;
//
//                for (int markerInx = 0; markerInx < matrixSubArrayIndexes.length; markerInx++) {
//                    if(matrixSubArrayIndexes[markerInx] == subArrayLen) {
//                        continue;
//                    }
//
//                    if (matrix[markerInx][matrixSubArrayIndexes[markerInx]] <= smallest) {
//                        smallest = matrix[markerInx][matrixSubArrayIndexes[markerInx]];
//                        smallestIndex = markerInx;
//
//                    }
//                }
//
//                sorted.add(smallest);
//                matrixSubArrayIndexes[smallestIndex]++;
//
//            }
//        }
//
////        peak k-th element
//
//        return sorted.get(k-1);
//    }

    class MyHeapComparator implements Comparator<MyHeapNode> {
        public int compare(MyHeapNode x, MyHeapNode y) {
            return x.value - y.value;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<MyHeapNode> minHeap = new PriorityQueue<>(new MyHeapComparator());
        for (int i = 0; i < n; i++) {
//            feed inital columns
            minHeap.offer(new MyHeapNode(matrix[i][0],i, 0));
        }
        MyHeapNode element = minHeap.peek();
        while (k-- > 0){
            element = minHeap.poll();
            int column = element.column;
            int row = element.row;
            if(column < n -1){
//                feed the next row
                minHeap.offer(new MyHeapNode(matrix[row][column+1], row, column+1));
            }
        }
        return element.value;
    }
    class MyHeapNode {

        int row;
        int column;
        int value;

        public MyHeapNode(int v, int r, int c) {
            this.value = v;
            this.row = r;
            this.column = c;
        }

        public int getValue() {
            return this.value;
        }

        public int getRow() {
            return this.row;
        }

        public int getColumn() {
            return this.column;
        }
    }

    public static void main(String[] args) {
        int i = new KthSmallestElementSortedMatrix().kthSmallest(new int[][]{
                        new int[]{1, 5, 9},
                        new int[]{10, 11, 13},
                        new int[]{12, 13, 15}
                },
                8);

        System.out.println(i);
    }
}
