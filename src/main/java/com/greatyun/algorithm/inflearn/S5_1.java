package com.greatyun.algorithm.inflearn;

import java.util.*;

public class S5_1 {

    public void func1(int [] num , int count) {
        Stack<Integer> stack = new Stack<>();
        int removeCnt = 0;
        for (int i = 0; i < num.length; i++) {
            if(stack.isEmpty()) {
                stack.push(num[i]);
            } else {

                while(!stack.isEmpty()) {
                    Integer peek = stack.peek();
                    if(peek < num[i]) {
                        stack.pop();
                        removeCnt++;
                    } else {
                        break;
                    }
                }
                stack.push(num[i]);
            }
        }
        for (int i = 0; i < count - removeCnt; i++) {
            stack.pop();
        }
        while(!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }

    public static void main(String[] args) {
        S5_1 obj = new S5_1();
        int [] arr = {9,9,7,7,2,5,2,6,4,1};
        int count = 5;
        obj.func1(arr , count);
    }
}
