package com.greatyun.algorithm.autoever;

import java.util.Stack;

/**
 * 괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다. 올바른 괄호의 규칙은 다음과 같습니다.
 *
 * 빈 문자열은 올바른 괄호 문자열입니다.
 * A가 올바른 괄호 문자열이라면, (A)도 올바른 괄호 문자열입니다.
 * A와 B가 올바른 괄호 문자열이라면, AB도 올바른 괄호 문자열입니다.
 * 예를 들면 "()()", "(())()"는 올바른 괄호입니다. 그러나, ")(", "())()"등은 올바르지 않은 괄호입니다.
 *
 * 괄호로만 이루어진 문자열이 담긴 두 배열이 있습니다. 각 배열에 담긴 문자열은 올바르거나, 혹은 올바르지 않은 괄호 문자열입니다. 배열의 예시는 다음과 같습니다.
 *
 * arr1 = ["()", "(()", ")()", "()"]
 * arr2 = [")()", "()", "(()"]
 * 이때, 각 배열에서 문자열을 하나씩 선택해 이어 붙여 올바른 괄호를 만드는 방법은 모두 몇 가지인지 세려 합니다. 단, 문자열을 이어 붙일 때는 반드시 arr1의 문자열이 앞에 오고, arr2의 문자열이 뒤에 와야 합니다. 또, 두 개를 이어 붙여 만든 괄호 문자열이 같더라도, arr1나 arr2에서 이전과는 다른 위치에 있는 문자열을 선택했다면 서로 다른 방법으로 세어야 합니다.
 *
 * arr1에서 첫 번째 문자열 "()"를 선택하고, arr2에서 두 번째 문자열 "()"를 선택하여 이어 붙이면 "()()"로 올바른 괄호가 됩니다.
 * arr1에서 두 번째 문자열 "(()"를 선택하고, arr2에서 첫 번째 문자열 ")()"를 선택해 이어 붙이면 "(())()"로 올바른 괄호가 됩니다.
 * arr1에서 네 번째 문자열 "()"를 선택하고, arr2에서 두 번째 문자열 "()"를 선택하여 이어 붙이면 "()()"로 올바른 괄호가 됩니다.
 * 괄호로만 이루어진 문자열이 담긴 배열 arr1, arr2가 매개변수로 주어질 때, 각 배열에서 문자열을 하나씩 선택해 이어 붙였을 때 올바른 괄호가 되는 방법은 몇 가지인지 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * arr1의 길이는 1 이상 100,000 이하입니다.
 * arr1의 원소는 '(' 또는 ')'로만 이루어진 문자열입니다.
 * 각 문자열의 길이는 1 이상 9 이하입니다.
 * arr2의 길이는 1 이상 100,000 이하입니다.
 * arr2의 원소는 '(' 또는 ')'로만 이루어진 문자열입니다.
 * 각 문자열의 길이는 1 이상 9 이하입니다.
 * arr1과 arr2에는 중복되는 문자열이 들어있을 수 있습니다.
 */
public class Q1 {

    public long sol(String [] arr1 , String [] arr2) {
        long ret = 0L;

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if(isRight(arr1[i] , arr2[j])) {
                    ret++;
                }
            }
        }

        return ret;
    }

    public boolean isRight(String str1 , String str2) {

        if(!str1.startsWith("(")) return false;
        if(!str2.endsWith(")")) return false;

        String targetStr = str1 + str2;

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < targetStr.length(); i++) {
            String innerStr = targetStr.substring(i , i+1);
            if(innerStr.equalsIgnoreCase("(")) {
                stack.push(innerStr);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        //System.out.println(stack.size());
        return stack.isEmpty();
    }

    public static void main(String[] args) {
//        String[] arr1 = {"()" , "(()" , ")()" , "()"};
//        String[] arr2 = {")()" , "()" , "(()"};

        String[] arr1 = {"()", "(()", "(", "(())"};
        String[] arr2 = {")()","()", "(())", ")()"};

        Q1 obj = new Q1();
        System.out.println(obj.isRight("()" , "()"));
        System.out.println("result -> " + obj.sol(arr1 , arr2));

    }

}
