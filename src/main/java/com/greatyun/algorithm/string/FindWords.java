package com.greatyun.algorithm.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindWords {
    /**
     * You are given an array of strings words and a string chars.
     *
     * A string is good if it can be formed by characters from chars (each character can only be used once).
     *
     * Return the sum of lengths of all good strings in words.
     *
     *
     *
     * Example 1:
     *
     * Input: words = ["cat","bt","hat","tree"], chars = "atach"
     * Output: 6
     * Explanation:
     * The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
     * Example 2:
     *
     * Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
     * Output: 10
     * Explanation:
     * The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
     *
     * @param words
     * @param chars
     * @return
     */


    public static int countCharacters(String[] words, String chars) {
        int ret = 0;

        List<String> list = new ArrayList<>();

        for (int i = 0; i < chars.length(); i++) {
            String tempStr = chars.substring(i , i+1);
            list.add(tempStr);
        }

        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            int containCnt = 0;

            Map<Integer , Integer> map = new HashMap<>();

            for (int j = 0; j < str.length(); j++) {
                String innerStr = str.substring(j , j+1);

                for (int k = 0; k < list.size(); k++) {
                    String listStr = list.get(k);

//                    System.out.println("innder Str : " + innerStr + " , listStr : " + listStr);
                    if(listStr.equals(innerStr) && !map.containsKey(k)) {
                    System.out.println("innder Str : " + innerStr + " , listStr : " + listStr);
                        containCnt++;
                        map.put(k , k);
                    }
                }
            }
            if(str.length() == containCnt) {
//                System.out.println(str);
                ret += str.length();
            }
            System.out.println("-----------------------");
        }
        return ret;
    }


    public static void main(String[] args) {
        String [] words = {"cat","bt","hat","tree"};
        String chars = "atach";
        int result = FindWords.countCharacters(words , chars);
        System.out.println("result : " + result);
    }
}
