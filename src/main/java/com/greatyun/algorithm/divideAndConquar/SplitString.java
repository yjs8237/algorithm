package com.greatyun.algorithm.divideAndConquar;

public class SplitString {

    public int balancedStringSplitV2(String s) {
        int ret = 0;

        char[] chars = s.toCharArray();

        int start = 0;
        int end = chars.length-1;

        int l_count = 0;
        int r_count = 0;

        while (start <= end) {

            char temp = chars[start];
            if(temp == 'L') {
                l_count++;
            } else if(temp == 'R') {
                r_count++;
            }
            if(l_count == r_count) {
                ret++;
            }
            start++;
        }
        System.out.println("ret -> " + ret);
        return  ret;
    }


    public int balancedStringSplit(String s) {
        int ret = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length-1; i++) {
            char char_i = chars[i];
//            System.out.println("i -> " + char_i);
            for (int j = i+1; j < chars.length; j+=2) {
//                System.out.println(i + " , " + j);
//                System.out.println(s.substring(i+1 , j+1));
                if(checkBalance(String.valueOf(char_i) + s.substring(i+1 , j+1))) {
                    ret++;
                }
            }
            System.out.println("---------------------");
        }
        System.out.println("ret -> " + ret);
        return ret;
    }

    private boolean checkBalance(String s) {
        int l_count = 0;
        int R_count = 0;
        System.out.println("check : " + s);
        for (int i = 0; i < s.length(); i++) {
            String substring = s.substring(i, i + 1);
            if(substring.equalsIgnoreCase("L")) {
                l_count++;
            } else if(substring.equalsIgnoreCase("R")) {
                R_count++;
            }
        }
        return l_count == R_count;
    }

    public static void main(String[] args) {
        SplitString obj = new SplitString();
        String s = "RLLLLRRRLR";
        obj.balancedStringSplitV2(s);
    }


    /**
     * Balanced strings are those who have equal quantity of 'L' and 'R' characters.
     *
     * Given a balanced string s split it in the maximum amount of balanced strings.
     *
     * Return the maximum amount of splitted balanced strings.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "RLRRLLRLRL"
     * Output: 4
     * Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
     * Example 2:
     *
     * Input: s = "RLLLLRRRLR"
     * Output: 3
     * Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains same number of 'L' and 'R'.
     * Example 3:
     *
     * Input: s = "LLLLRRRR"
     * Output: 1
     * Explanation: s can be split into "LLLLRRRR".
     * Example 4:
     *
     * Input: s = "RLRRRLLRLL"
     * Output: 2
     * Explanation: s can be split into "RL", "RRRLLRLL", since each substring contains an equal number of 'L' and 'R'
     */


}
