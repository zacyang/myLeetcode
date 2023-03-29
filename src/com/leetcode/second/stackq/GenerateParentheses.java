package com.leetcode.second.stackq;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class GenerateParentheses {
    String[] ps = new String[]{"(", ")"};

    public List<String> generateParenthesis(int n) {
//        need to be blance, so the count of ( and ) should be equals to n/2
//        try put int ( and/or ) based on the count
//        if you can , then put the new () into the current result list
//        add the result list into the finnal result list in the end of the recurssion

        int numberOfAllowedLeftP = n;
        int numberOfAllowedRightP = n;

        Set<String> result = new HashSet<>();

        String current = "(";

        numberOfAllowedLeftP--;

        putInCombo(numberOfAllowedLeftP, numberOfAllowedRightP, result, current);

        return new LinkedList<>(result);
    }

    private void putInCombo(int numberOfAllowedLeftP, int numberOfAllowedRightP, Set<String> result, String current) {
        for (int i = 0; i < ps.length; i++) {
//            can alway place ( if anything left
            if (i == 0 && numberOfAllowedLeftP > 0) {
                this.putInCombo(numberOfAllowedLeftP-1,numberOfAllowedRightP, result, current+ps[i]);


            }
//            can only place ) if it can close the current (
            if (i == 1 && numberOfAllowedRightP > 0 && numberOfAllowedRightP > numberOfAllowedLeftP) {

                this.putInCombo(numberOfAllowedLeftP,numberOfAllowedRightP-1, result, current+ps[i]);
            }

            if (numberOfAllowedLeftP == numberOfAllowedRightP && numberOfAllowedRightP == 0) {
//                got one shot
                result.add(current);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(3));
    }


}
