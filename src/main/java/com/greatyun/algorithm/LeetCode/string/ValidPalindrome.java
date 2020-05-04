package com.greatyun.algorithm.LeetCode.string;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if(s.length() <= 1) return true;
        s = s.toLowerCase().replaceAll(" " , "");
        char[] chars = s.toCharArray();

        StringBuilder builder1 = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            if((chars[i] >= 97 && chars[i] <= 122) || (chars[i] >= 48 && chars[i] <= 57)) {
                builder1.append(chars[i]);
                builder2.append(chars[i]);
            }
        }
        return builder1.reverse().toString().equalsIgnoreCase(builder2.toString());
    }

    public static void main(String[] args) {
        ValidPalindrome obj = new ValidPalindrome();
        System.out.println(obj.isPalindrome("0P"));
        StringBuffer buffer = new StringBuffer();
        StringBuilder builder = new StringBuilder();
        HashMap<String, String > map = new HashMap<>();
        Hashtable<String, String> table = new Hashtable<>();

        ConcurrentHashMap<String , String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("1" , "1");
        concurrentHashMap.get("1");
        map.put("1" , null);
        table.put("1" , "123");

        table.get("1");
        buffer.append("123");
        builder.append("1234");
    }
}
