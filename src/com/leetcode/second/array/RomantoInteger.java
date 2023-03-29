package com.leetcode.second.array;

import java.util.HashMap;
import java.util.Map;

public class RomantoInteger {

    public int romanToInt(String s) {
        Map<String, Integer> resgister = new HashMap<>();
        resgister.put("I", 1);
        resgister.put("V", 5);
        resgister.put("IV", 4);
        resgister.put("IX", 9);
        resgister.put("X", 10);
        resgister.put("L", 50);
        resgister.put("XL", 40);
        resgister.put("XC", 90);
        resgister.put("C", 100);
        resgister.put("D", 500);
        resgister.put("CD", 400);
        resgister.put("D", 500);
        resgister.put("CM", 900);
        resgister.put("M", 1000);

        int result = 0;
        for (int i = 0; i < s.length(); i++) {

            boolean validTwo = false;
            if (i + 1 < s.length()) {
                String check = s.substring(i, i + 2);
                if (resgister.containsKey(check)) {
                    Integer integer = resgister.get(check);
                    result += integer;
                    validTwo = true;
                }
            }

            if(validTwo==false) {
                result+= resgister.get(s.substring(i, i+1));
            } else {
                i+=1;
            }



        }
        return result;
    }

    public static void main(String[] args) {
        int lviii = new RomantoInteger().romanToInt("MCMXCIV");
        System.out.println(lviii);
    }
}
