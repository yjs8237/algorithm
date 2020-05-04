package com.greatyun.algorithm.LeetCode.string;

import java.util.Stack;

public class ReverseString {

    public void reverseString(char[] s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length; i++) {
            stack.push(s[i]);
        }

        int index = 0;
        while (!stack.empty()) {
            s[index] = stack.pop();
            index++;
        }
    }

    public void reverseStringV2(char[] s) {
        int start = 0;
        int end = s.length - 1;

        while(start <= end) {

            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        ReverseString obj = new ReverseString();
        char [] arr = {'a' , 'b' , 'c'};
        obj.reverseString(arr);
    }
}
