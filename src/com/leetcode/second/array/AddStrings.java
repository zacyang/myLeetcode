package com.leetcode.second.array;

public class AddStrings {
    public String addStrings(String num1, String num2) {

        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;

        StringBuilder result = new StringBuilder();

        int carry = 0;
        while (p1 >= 0 || p2 >= 0) {

            int n1 = p1 >= 0 ? num1.charAt(p1) - '0' : 0;
            int n2 = p2 >= 0 ? num2.charAt(p2) - '0' : 0;

            int sum = n1 + n2 + carry;
            carry = sum / 10;

            result.append(sum % 10);

            p1--;
            p2--;

        }
        if(carry!=0) {
            result.append(carry);
        }
        return result.reverse().toString();

    }

    public static void main(String[] args) {
        String s = new AddStrings().addStrings("6913259244", "71103343");
        System.out.println(s);
    }
}
