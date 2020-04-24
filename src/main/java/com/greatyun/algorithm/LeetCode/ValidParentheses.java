package com.greatyun.algorithm.LeetCode;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {

    /**
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     *
     * An input string is valid if:
     *
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     * Note that an empty string is also considered valid.
     *
     * Example 1:
     *
     * Input: "()"
     * Output: true
     * Example 2:
     *
     * Input: "()[]{}"
     * Output: true
     * Example 3:
     *
     * Input: "(]"
     * Output: false
     */

    public boolean isValid(String s) {

        if(s.length() == 0) return true;
        if(s.length() <= 1 || s.length() % 2 != 0) return false;
        HashMap<Character , Character> map = new HashMap<>();
        map.put('(' , ')');
        map.put('[' , ']');
        map.put('{' , '}');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            // 시작태그가 계속 나오면 종료태그를 stack 에 push 하고 종료태그가 나오면 stack 에 있는걸 꺼내서 비교한다.
            // 다른 태그이면 false , stack 이 비어 있어도 false
            if(map.containsKey(charAt)) {
                // 시작태그
                stack.push(map.get(charAt));
            } else if(map.containsValue(charAt)) {
                // 종료태그
                if(stack.empty() || stack.pop() != charAt) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String []args) {
        ValidParentheses obj = new ValidParentheses();
        String str = "([])";
        System.out.println("result : " + obj.isValid(str));
    }
}
