package com.leetcode.second.stackq;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

class CarStatus {
    int speed;
    int position;

    public CarStatus(int position,int speed ) {
        this.speed = speed;
        this.position = position;
    }
}

public class CareFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> timeToReachTheTarget = new Stack<>();

        ArrayList<CarStatus> carStatuses = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            carStatuses.add(new CarStatus(position[i], speed[i]));
        }
        carStatuses.sort((o1, o2) -> o1.position - o2.position);

        for (int i = carStatuses.size()-1; i>=0; i--) {
            double currentTimeToTarget = (target - carStatuses.get(i).position) / (double) carStatuses.get(i).speed;
            if(timeToReachTheTarget.isEmpty() || timeToReachTheTarget.peek() < currentTimeToTarget) {
                timeToReachTheTarget.add(currentTimeToTarget);
            }
        }



        return timeToReachTheTarget.size();
    }

//    public int carFleet(int target, int[] position, int[] speed) {
//        LinkedList<CarStatus> carStatuses = new LinkedList<>();
//        for (int i = 0; i < position.length; i++) {
//            carStatuses.add(new CarStatus(position[i], speed[i]));
//        }
//        carStatuses.sort((o1, o2) -> o1.position - o2.position);
//
//        Stack<CarStatus> stack = new Stack<>();
//        for (int i = carStatuses.size() -1; i>=0 ; i--) {
//            CarStatus carStatus = carStatuses.get(i);
//            int newSpeed = carStatus.speed;
//            int newPosition = carStatus.position;
//
//            while (!stack.isEmpty() && canMergeFleet(stack.peek(), carStatus, target)) {
////                bond to merge
//
//                CarStatus slower = stack.pop();
//                newSpeed = slower.speed;
//                newPosition = slower.position;
//
//            }
//            stack.push(new CarStatus(newPosition, newSpeed));
//        }
//        return stack.size();
//    }
//
//    private boolean canMergeFleet(CarStatus later, CarStatus prev, int target) {
//        if(prev.speed==0) {
//            return false;
//        }
//        if((target - later.position )/(double)later.speed >= (target - prev.position )/(double)prev.speed ) {
//            return true;
//        }
//        return false;
//
//    }

    public static void main(String[] args) {
//        int i = new CareFleet().carFleet(10, new int[]{6,8},  new int[]{3,2});
        int i = new CareFleet().carFleet(12, new int[]{10,8,0,5,3},  new int[]{2,4,1,1,3});
        System.out.println(i);
    }
}
