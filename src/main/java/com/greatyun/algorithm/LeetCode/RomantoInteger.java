package com.greatyun.algorithm.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class RomantoInteger {

    /**
     * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
     *
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
     *
     * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
     *
     * I can be placed before V (5) and X (10) to make 4 and 9.
     * X can be placed before L (50) and C (100) to make 40 and 90.
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
     *
     * Example 1:
     *
     * Input: "III"
     * Output: 3
     * Example 2:
     *
     * Input: "IV"
     * Output: 4
     *
     */

    public int romanToInt(String s) {

        HashMap<String , Integer> map = new HashMap<String , Integer>();
        map.put("I" , 1);
        map.put("V" , 5);
        map.put("X" , 10);
        map.put("L" , 50);
        map.put("C" , 100);
        map.put("D" , 500);
        map.put("M" , 1000);

        if(s.length() == 0 ) return 0;

        int rememberNumber = Integer.MAX_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String temp = s.substring(i , i+1);
            temp = temp.toUpperCase();
            if(map.containsKey(temp)) {
                Integer targetNum = map.get(temp);
                if(targetNum > rememberNumber && rememberNumber != Integer.MAX_VALUE) {
                    Integer pop = stack.pop();
                    stack.push(targetNum - rememberNumber);
                } else {
                    stack.push(targetNum);
                }
                rememberNumber = targetNum;
            } else {
                return 0;
            }
        }

        int result = 0;
        while(!stack.empty()) {
            result += stack.pop();
        }
        return result;
    }
    public static void main(String []args) {
        RomantoInteger obj = new RomantoInteger();
        String str = "LVIII";
        System.out.println("result : " + obj.romanToInt(str));
    }
}
