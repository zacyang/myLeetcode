package com.leetcode.second.array;

import java.util.LinkedList;
import java.util.List;

public class EncodeDecodeStrings {

    public static final String DELIMITOR = "#";

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        String result = "";
        for (String str : strs) {
            int length = str.length();
            result += length+ DELIMITOR + str;
        }
        return result;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new LinkedList<>();
        int currentIdx = 0;

        String targetString = s;
//        read until the #
        String currentDigits= "";
        int nextStringLenght = 0;
        while (currentIdx<s.length()) {
            char currentChar = s.charAt(currentIdx);
            if(currentChar == '#') {
                nextStringLenght = Integer.      parseInt(currentDigits);
                currentDigits = "";
                String nextString = s.substring(currentIdx+1, currentIdx + nextStringLenght +1);
                result.add(nextString);
                currentIdx+= nextStringLenght;

            } else {
                currentDigits += currentChar;
            }
                currentIdx++;

        }


        return result;
    }

    public static void main(String[] args) {
        List<String> objects = new LinkedList<>();
        objects.add("hello");
        objects.add("world");
        EncodeDecodeStrings encodeDecodeStrings = new EncodeDecodeStrings();
        String result = encodeDecodeStrings.encode(objects);
        System.out.println(encodeDecodeStrings.decode(result));


    }
}
