package com.greatyun.algorithm.LeetCode.string;

import org.graalvm.compiler.core.common.type.ArithmeticOpTable;

import java.util.ArrayList;
import java.util.List;

public class AddString {

    public String solution(String num1 , String num2) {

        int index_1 = num1.length() - 1;
        int index_2 = num2.length() - 1;

        StringBuilder builder = new StringBuilder();

        int up = 0;
        while(true) {

            if(index_1 < 0 && index_2 < 0) break;
            int ret = 0;
            int num_1 = 0;
            int num_2 = 0;
            if(index_1 >= 0) {
                num_1 = Integer.parseInt(String.valueOf(num1.charAt(index_1)));
            }
            if(index_2 >= 0) {
                num_2 = Integer.parseInt(String.valueOf(num2.charAt(index_2)));
            }

            int subSum = num_1 + num_2 + up;
            if(subSum >= 10) {
                ret = subSum % 10;
            } else {
                ret = subSum;
            }

            up = subSum / 10;
            index_1--;
            index_2--;
            builder.append(String.valueOf(ret));

        }

        if(up > 0) {
            builder.append(String.valueOf(up));
        }
        return builder.reverse().toString();

    }

    public static void main(String[] args) {
        AddString obj = new AddString();
        String num1 = "10910";
        String num2 = "90090";
        System.out.println(obj.solution(num1 , num2));
    }
}
