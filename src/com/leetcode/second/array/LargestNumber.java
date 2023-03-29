package com.leetcode.second.array;

import java.util.*;



public class LargestNumber {
    public String largestNumber(int[] nums) {
        LinkedList<String> strings = new LinkedList<>();
        for (int num : nums) {
            strings.add(String.valueOf(num));
        }

        strings.sort((o1, o2) -> {
            String p1 = o1 + o2;
            String p2 = o2 + o1;
            return p2.compareTo(p1);
        });

        if(strings.get(0).indexOf('0') == 0){
            return "0";
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (String element : strings) {
            stringBuilder.append(element);
        }
        return stringBuilder.toString();

    }

    public List<Integer> intToConsistueDigits(int num) {

        LinkedList<Integer> result = new LinkedList<>();

        while (num >= 10) {

            int lastDigit = num % 10;
            result.add(lastDigit);
            num = num / 10;
        }
        result.add(num);
        return result;

    }

    public static void main(String[] args) {
        String firstDigits = new LargestNumber().largestNumber(new int[]{3,30,34,5,9});
//        String firstDigits = new LargestNumber().largestNumber(new int[]{34323,3432});
//        List firstDigits = new LargestNumber().intToConsistueDigits(1234);
//        for (Object firstDigit : firstDigits) {
//            System.out.println(firstDigit);
//        }
        System.out.println(firstDigits);
    }
}
