package com.leetcode.second.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//LC 295
public class FindMedianDataStream {
    private Queue<Integer> leftQ;
    private Queue<Integer> rightQ;

    public FindMedianDataStream() {
        leftQ = new PriorityQueue<>((o1, o2) -> o2-o1);
        rightQ = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(leftQ.isEmpty() || leftQ.peek() < num) {
            leftQ.offer(num);
        } else  {
            rightQ.offer(num);
        }

//        balance two Qs
        if(leftQ.size() - rightQ.size() > 1) {
            rightQ.offer(leftQ.poll());

        } else  if (rightQ.size() - leftQ.size() >1){
            leftQ.offer(rightQ.poll());
        }

    }

    public double findMedian() {

        if(leftQ.size() == rightQ.size()) {
            return ((double)(leftQ.peek() +rightQ.peek()))/2;
        } else if (leftQ.size() > rightQ.size()){
            return leftQ.peek();
        } else {
            return rightQ.peek();
        }
    }

    public static void main(String[] args) {
        FindMedianDataStream findMedianDataStream = new FindMedianDataStream();
        findMedianDataStream.addNum(1);
        findMedianDataStream.addNum(2);
        System.out.println(findMedianDataStream.findMedian());
        findMedianDataStream.addNum(3);
        System.out.println(findMedianDataStream.findMedian());


    }
}
