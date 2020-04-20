package com.greatyun.algorithm.hackerRank;

public class CamelCase {

    static int camelcase(String s) {

        if(s.length() == 0) return 0;

        char[] chars = s.toCharArray();
        int result = 1;
        for (char character : chars) {
            int ascii = character;
            if(ascii >= 65 && ascii <= 90) {
                // 대문자
                result++;
            } else if(ascii >= 97 && ascii <= 122) {
                // 소문자

            } else {

            }
        }
        return result;
    }

    public static void main(String [] args) {
        String str = "testAbd";
        int camelcase = CamelCase.camelcase(str);
        System.out.println(camelcase + "");
    }

}
