package com.leetcode.second.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class IntegertoEnglishWords {
    TreeMap<Integer, List<String>> register = new TreeMap<>();

    {
        register.put(1, List.of("One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"));
        register.put(2, List.of("Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"));
        register.put(3, List.of("Hundred"));

        register.put(4, List.of("Thousand"));
        register.put(5, List.of("Thousand"));
        register.put(5, List.of("Thousand"));

        register.put(7, List.of("Million"));
        register.put(8, List.of("Million"));
        register.put(9, List.of("Million"));

        register.put(10, List.of("Billion"));
    }

    public String numberToWords(int num) {
        String s = String.valueOf(num);
        int currentProcessingNumberOfDigits = s.length();

        List<String> resultOnEachDigits = new ArrayList<>();

        for (int i = 10; i > 0; i--) {
            int numberOfCurrentDigi = 0;
            if (currentProcessingNumberOfDigits >= i) {
                numberOfCurrentDigi = currentProcessingNumberOfDigits - i;
            } else {
                continue;
            }

            currentProcessingNumberOfDigits = currentProcessingNumberOfDigits - numberOfCurrentDigi;
            String currentNumber = s.substring(0, numberOfCurrentDigi);
            s = s.substring(numberOfCurrentDigi);

            List<String> callNames = register.get(currentProcessingNumberOfDigits);
            int indixOfActualCallName = Integer.parseInt(currentNumber.substring(0, 1));
            String s1 = callNames.get(indixOfActualCallName);
            resultOnEachDigits.add(s1 +" ");


        }

        return "";
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}
