package com.greatyun.algorithm.LeetCode.challenge8;

import java.util.HashMap;
import java.util.Map;

/**
 * 171. Excel Sheet Column Number
 * Easy
 *
 * 1051
 *
 * 157
 *
 * Add to List
 *
 * Share
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * For example:
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * Example 1:
 *
 * Input: "A"
 * Output: 1
 * Example 2:
 *
 * Input: "AB"
 * Output: 28
 * Example 3:
 *
 * Input: "ZY"
 * Output: 701
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 7
 * s consists only of uppercase English letters.
 * s is between "A" and "FXSHRXW".
 */
public class ExcelSheet {
    public int titleToNumber(String s) {
        int ret = 0;
        int count = 26;
        Map<String , Integer> map = new HashMap<>();
        int value = 1;
        for (int i = 65; i < 65 + 26; i++) {
            char alpabet = (char) i;
            map.put(String.valueOf(alpabet) , value);
            value++;
        }

        int depth = 0;
        for (int i = s.length(); i > 0; i--) {
            Integer integer = map.get(s.substring(i - 1, i));
            int number1 = depth * count * integer;
            double pow = Math.pow(Double.parseDouble(String.valueOf(count)) , Double.parseDouble(String.valueOf(depth)));

            //System.out.println("#1 : " + s.substring(i - 1 , i) + " : " + pow );
            pow = pow * integer;
            //System.out.println("#2 : " + s.substring(i - 1 , i) + " : " + pow );
            if(i == s.length()) {
                ret = integer;
            } else {
                ret +=  pow;
            }
            depth++;
        }
        return ret;
    }
    public static void main(String[] args) {
        ExcelSheet obj = new ExcelSheet();
        String str = "BA";
        System.out.println(obj.titleToNumber(str));
    }
}
