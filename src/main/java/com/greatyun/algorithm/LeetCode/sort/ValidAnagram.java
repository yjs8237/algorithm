package com.greatyun.algorithm.LeetCode.sort;

import java.util.Arrays;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) return false;
        if(s.length() == 0 && t.length() == 0 ) return true;

        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chars1);

        for (int i = 0; i < chars.length; i++) {
            if(chars[i] != chars1[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram obj = new ValidAnagram();
        String s = "abc";
        String t = "abc";
        System.out.println(obj.isAnagram(s, t));
    }
}
