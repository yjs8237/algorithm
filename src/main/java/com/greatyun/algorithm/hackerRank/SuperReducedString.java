package com.greatyun.algorithm.hackerRank;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SuperReducedString {

    /**
     * 중복된 문자를 제외한 문자열을 리턴하는 함수를 작성하시오
     */

    static String superReducedString(String s) {

        char[] chars = s.toCharArray();
        if(chars.length == 0) return "Empty String";

        char temp = ' ';
        StringBuilder builder = new StringBuilder();
        int dupCount = 0;
        for (int i = 0; i < chars.length; i++) {
            if(temp == chars[i]) {
                dupCount++;
                temp = ' ';
                if(builder.length() > 0) {
                    builder.deleteCharAt(builder.length() - 1);
                }
            } else {
                builder.append(chars[i]);
                temp = chars[i];
            }
        }

        if(dupCount == 0) {
            return builder.toString();
        }

        return superReducedString(builder.toString());
    }

    public static void main(String [] args) {

        String str = "abba";
        String result = SuperReducedString.superReducedString(str);

//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("a").append("b").append("c").append("d");
//        stringBuilder.delete(stringBuilder.length() - 3 , stringBuilder.length());
//        System.out.println("builder : " + stringBuilder.toString());
        System.out.println("result : " + result);
    }

}
