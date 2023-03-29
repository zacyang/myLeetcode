package com.leetcode.second.dailyc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntegerToRoman {


    public String intToRoman(int num) {
// a map to hold the digiti (includes offset) to roman CV
//        loop thru num by dividing it 10^n , n ==offset

        int offset = String.valueOf(num).length();

        int currentDigitsMark = offset - 1;

        int currentNum = num;

        StringBuilder sb = new StringBuilder();
        while (currentDigitsMark >= 0) {
            int digits = currentNum / (10 ^ currentDigitsMark);
            String romanRepresentation = getRomanRep(digits, currentDigitsMark);
            sb.append(romanRepresentation);
            currentDigitsMark--;
        }

        return sb.toString();
    }

    private String getRomanRep(int digits, int currentDigitsMark) {

        return "";

    }

}
