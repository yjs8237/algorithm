package com.greatyun.algorithm.LeetCode;

import java.util.Stack;

public class ReverseInteger {

    /**
     * Given a 32-bit signed integer, reverse digits of an integer.
     *
     * Example 1:
     *
     * Input: 123
     * Output: 321
     */

    public int reverse(int x) {
        Stack<String> stack = new Stack<>();
        boolean isMinus = false;
        if(x < 0) {
            isMinus = true;
            x = x * -1;
        }

        String value = String.valueOf(x);

        for (int i = 0; i < value.length(); i++) {
            String temp = value.substring(i , i+1);
            stack.push(temp);
        }

        StringBuilder builder = new StringBuilder();
        if(isMinus) {
            builder.append("-");
        }
        while (!stack.empty()) {
            String pop = stack.pop();
            builder.append(pop);
        }

        int result = 0;
        try {
            result = Integer.parseInt(builder.toString());
        } catch (NumberFormatException e) {
            result = 0;
        }

        return result;
    }

    public static void main(String [] args) {
        ReverseInteger obj = new ReverseInteger();
        int x = 1534236469;
        obj.reverse(x);
    }
}
