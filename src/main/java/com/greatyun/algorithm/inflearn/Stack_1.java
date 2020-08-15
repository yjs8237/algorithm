package com.greatyun.algorithm.inflearn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Stack_1 {

    /** 전위 연산 후위 연산 Stack 사용 */

    /**
     * 3+5*2/(7-2) -> 352*72-/+ 후위 연산으로 표현하기
     *
     *  1. + 또는 - 는 stack push
     *  2. * 또는 / 는 stack에 나와 비슷한 레벨의 연산자가 있는지 확인하고 있으면 pop 없을때까지 pop 한뒤 나 자신 push
     *  3. ( -> stack push
     *  4. ) -> ( 가 나올때 까지 pop
     *  5. 최종적으로 루프가 다돌고난 뒤 stack 에 있는 모든것을 다 pop
     *
     * 후위연산으로 표현한뒤
     *
     *   1. "*" 앞 두 피연산자 5 와 2를 곱하고 : 10
     *   2. "-" 앞 두 피연산자 7 과 2를 빼고 : 5
     *   3. "/" 앞 두 피연산자 10 과 5를 나누고 : 2
     *   4. "+" 앞 두 피연산자 3과 2를 더하면 : 5
     *
     *
     */

    public static void sol(String str) {

        char[] chars = str.toCharArray();
        List<String> list = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {

            if(Character.isDigit(chars[i])) {
                // 숫자이면
                list.add(String.valueOf(chars[i]));
            } else {
                // 연산자 이면
                char calChar = chars[i];
                if(calChar == '+' || calChar == '-') {
                    stack.push(String.valueOf(calChar));
                } else if(calChar == '*' || calChar == '/') {

                    while(true) {
                        String peek = stack.peek();
                        if(peek.equals("*") || peek.equals("/")) {
                            list.add(stack.pop());
                        } else {
                            break;
                        }
                    }
                    stack.push(String.valueOf(calChar));

                } else if(calChar == '(') {
                    stack.push(String.valueOf(calChar));
                } else if(calChar == ')') {

                    while(true) {
                        String pop = stack.pop();
                        if(pop.equals("(")) {
                            break;
                        } else {
                            list.add(pop);
                        }
                    }

                }
            }
        }
        while(!stack.isEmpty()) {
            list.add(stack.pop());
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    public static void main(String[] args) {
        Stack_1.sol("10+5*2/(7-2)");
    }
}
