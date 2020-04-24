package com.greatyun.algorithm.LeetCode;

import java.util.*;

public class LongestCommonPrefix {



    /**
     * Write a function to find the longest common prefix string amongst an array of strings.
     *
     * If there is no common prefix, return an empty string "".
     *
     * Example 1:
     *
     * Input: ["flower","flow","flight"]
     * Output: "fl"
     * Example 2:
     *
     * Input: ["dog","racecar","car"]
     * Output: ""
     * Explanation: There is no common prefix among the input strings.
     * Note:
     *
     * All given inputs are in lowercase letters a-z.
     */

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];

        StringBuilder stringBuilder = new StringBuilder();
        String firstStr = strs[0];

        for (int i = 0; i < firstStr.length(); i++) {
            String subStr = firstStr.substring(i , i+1);
            stringBuilder.append(subStr);
            int matchCount = 0;
            for (int j = 1; j < strs.length; j++) {
                if(strs[j].startsWith(stringBuilder.toString())) {
                    matchCount++;
                } else {
                    stringBuilder.delete(stringBuilder.length()-1 , stringBuilder.length());
                    break;
                }
            }
            if(matchCount == strs.length - 1) {
                System.out.println(stringBuilder.toString() + " 여기까지 정답" );
            } else if(i == 0) {
                return "";
            } else {
                return stringBuilder.toString();
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LongestCommonPrefix obj = new LongestCommonPrefix();

        String [] arr = {"apcb" , "apb" };
        System.out.println(obj.longestCommonPrefix(arr));
    }


}
