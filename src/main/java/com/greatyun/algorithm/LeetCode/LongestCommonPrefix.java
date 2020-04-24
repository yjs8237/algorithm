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

    class Data {
        char character;
        int count;
    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder builder = new StringBuilder();

        HashMap<Character , Integer > map = new HashMap<>();

        LinkedList<Character> linkedList = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        int minValue = Integer.MAX_VALUE;
        String resultStr = "";
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] charArray = str.toCharArray();
            boolean isSame = false;
            for (int j = 0; j < charArray.length; j++) {
                if(i == 0) {
                    isSame = true;
                    linkedList.add(charArray[j]);
                    resultStr += charArray[j];
                } else {

                    if(linkedList.contains(charArray[j])) {
                        isSame = true;
                    } else {
                        isSame = false;

                    }

                }
            }
            if(!isSame) {

                break;
            }

        }

        StringBuilder stringBuilder = new StringBuilder();
        Set keySet = map.keySet();
        Iterator iterator = keySet.iterator();
        int totalCount = 0;
        while(iterator.hasNext()) {
            Character key = (Character) iterator.next();
            Integer count = map.get(key);
            if(totalCount < count) {
                stringBuilder.append(key);
                totalCount = count;
            }
            System.out.println("key : " + key +  " , count : " + count + " , result : " + stringBuilder.toString());

        }

        System.out.println("min Value : " + minValue);

        return ""resetStr"";
    }


    public static void main(String [] args) {
        LongestCommonPrefix obj = new LongestCommonPrefix();
        String [] strArr = {"te" , "te" , "tes"};
        System.out.println("result : " + obj.longestCommonPrefix(strArr));
    }
}
