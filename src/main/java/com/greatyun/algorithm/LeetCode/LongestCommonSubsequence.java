package com.greatyun.algorithm.LeetCode;

import java.util.HashSet;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {

        if(text1.length() < 1 || text2.length() < 1) {
            return 0;
        }
        int result = 0;
        int rememberIndex = -1;
        for (int i = 0; i < text1.length(); i++) {
            if(text2.length() == 0){
                break;
            }
            String str = text1.substring(i , i+1);
            int index2 = text2.indexOf(str);
            if(index2 > -1 && index2 > rememberIndex) {
                result++;
                String str1 = text2.substring(0 , index2);
                String str2 = text2.substring(index2 , index2+1);
                String str3 = text2.substring(index2+1);
                text2 = str1 + str3;
                rememberIndex = index2;
                System.out.println("change text2 [" + text2 + "]");
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LongestCommonSubsequence obj = new LongestCommonSubsequence();
        String str1 = "abcde";
        String str2 = "ace";

        System.out.println(obj.longestCommonSubsequence(str1 , str2));
    }
}
