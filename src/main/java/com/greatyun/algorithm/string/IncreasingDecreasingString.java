package com.greatyun.algorithm.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 1370
 *
 * 1370. Increasing Decreasing String
 * Easy
 *
 * 152
 *
 * 128
 *
 * Add to List
 *
 * Share
 * Given a string s. You should re-order the string using the following algorithm:
 *
 * Pick the smallest character from s and append it to the result.
 * Pick the smallest character from s which is greater than the last appended character to the result and append it.
 * Repeat step 2 until you cannot pick more characters.
 * Pick the largest character from s and append it to the result.
 * Pick the largest character from s which is smaller than the last appended character to the result and append it.
 * Repeat step 5 until you cannot pick more characters.
 * Repeat the steps from 1 to 6 until you pick all characters from s.
 * In each step, If the smallest or the largest character appears more than once you can choose any occurrence and append it to the result.
 *
 * Return the result string after sorting s with this algorithm.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aaaabbbbcccc"
 * Output: "abccbaabccba"
 * Explanation: After steps 1, 2 and 3 of the first iteration, result = "abc"
 * After steps 4, 5 and 6 of the first iteration, result = "abccba"
 * First iteration is done. Now s = "aabbcc" and we go back to step 1
 * After steps 1, 2 and 3 of the second iteration, result = "abccbaabc"
 * After steps 4, 5 and 6 of the second iteration, result = "abccbaabccba"
 */
public class IncreasingDecreasingString {

    public static void solution(String s) {
        char[] chars = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        Arrays.sort(chars);
        Set<Integer> indexSet = new HashSet<>();
        int isOdd = 0;
        while(true) {
            if(builder.toString().length() == s.length()) {
                break;
            }
            Set<String> set = new HashSet<>();
            if(isOdd % 2 == 0) {
                for (int i = 0; i < chars.length; i++) {
                    if(!set.contains(String.valueOf(chars[i])) && !indexSet.contains(i)) {
                        builder.append(String.valueOf(chars[i]));
                        indexSet.add(i);
                        set.add(String.valueOf(chars[i]));
                    }
                }
            } else {
                for (int i = chars.length - 1; i >= 0; i--) {
                    if(!set.contains(String.valueOf(chars[i])) && !indexSet.contains(i)) {
                        builder.append(String.valueOf(chars[i]));
                        indexSet.add(i);
                        set.add(String.valueOf(chars[i]));
                    }
                }
            }
            isOdd++;
        }

        System.out.println(builder.toString());
    }

    public static void main(String[] args) {
        IncreasingDecreasingString.solution("aaaabbbbcccc");
    }



}
