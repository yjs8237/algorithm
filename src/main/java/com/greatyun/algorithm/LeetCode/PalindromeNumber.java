package com.greatyun.algorithm.LeetCode;

import java.util.LinkedList;
import java.util.Stack;

public class PalindromeNumber {

    /**
     * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
     *
     * Example 1:
     *
     * Input: 121
     * Output: true
     * Example 2:
     *
     * Input: -121
     * Output: false
     * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
     * Example 3:
     *
     * Input: 10
     * Output: false
     * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
     */

    public boolean isPalindrome(int x) {
        if(x < 10 && x > 0) return true;

        Stack<String> stack = new Stack<>();
        LinkedList<String> queue = new LinkedList<>();

        String str = String.valueOf(x);

        for (int i = 0; i < str.length(); i++) {
            String tempStr = str.substring(i , i+1);
            stack.push(tempStr);
            queue.add(tempStr);
        }

        while(!stack.empty()) {
            String pop = stack.pop();
            String remove = queue.remove();
            if(!pop.equalsIgnoreCase(remove)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String []args) {
        PalindromeNumber obj = new PalindromeNumber();
        int x = 1213;
        System.out.println("result : " + obj.isPalindrome(x));
    }

}
