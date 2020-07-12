package com.greatyun.algorithm.LeetCode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * 1309. Decrypt String from Alphabet to Integer Mapping
 * Easy
 *
 * 260
 *
 * 25
 *
 * Add to List
 *
 * Share
 * Given a string s formed by digits ('0' - '9') and '#' . We want to map s to English lowercase characters as follows:
 *
 * Characters ('a' to 'i') are represented by ('1' to '9') respectively.
 * Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
 * Return the string formed after mapping.
 *
 * It's guaranteed that a unique mapping will always exist.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "10#11#12"
 * Output: "jkab"
 * Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
 * Example 2:
 *
 * Input: s = "1326#"
 * Output: "acz"
 * Example 3:
 *
 * Input: s = "25#"
 * Output: "y"
 * Example 4:
 *
 * Input: s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
 * Output: "abcdefghijklmnopqrstuvwxyz"
 */
public class DecryptString {
    public static String solution (String s) {
        StringBuilder builder = new StringBuilder();


        Map<String, String> map = new HashMap<>();
        int ascii = 97;
        for (int i = 0; i < 9; i++) {
            char ch = (char) ascii;
            map.put(String.valueOf(i+1) , String.valueOf(ch));
            ascii++;
        }

        for (int i = 0; i < 17; i++) {
            char ch = (char) ascii;
            map.put(String.valueOf(i+10) + "#" , String.valueOf(ch));
            ascii++;
        }

//        int index = s.indexOf("#" , 6);
//        System.out.println(index);

        HashSet<Integer> indexSet = new HashSet<>();
        int index = 0;
        while(index >= 0) {
            index = s.indexOf("#" , index);
            if(index > 0) {
                indexSet.add(index - 2);
                System.out.println(index - 2);
            } else {
                break;
            }
            index++;
        }

        for (int i = 0; i < s.length(); i++) {

            if(indexSet.contains(i)) {
                // j부터 시작되는 문자열
                String key = s.substring(i , i+3);
                String value = map.get(key);
//                System.out.println("#1 " + i + " , " + value);
                builder.append(value);
                i += 2;
            } else {
                String tempStr = s.substring(i , i+1);
                if(map.containsKey(tempStr)) {
                    String value = map.get(tempStr);
//                    System.out.println("#2 : " + i + " , " + value);
                    builder.append(value);
                }
            }

        }

//
//        Iterator iterator = map.keySet().iterator();
//        while(iterator.hasNext()) {
//            String key = (String) iterator.next();
//            System.out.println(key + " , " + map.get(key));
//        }

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(DecryptString.solution("10#11#12"));
    }
}
