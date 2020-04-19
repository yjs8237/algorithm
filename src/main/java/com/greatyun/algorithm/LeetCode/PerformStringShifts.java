package com.greatyun.algorithm.LeetCode;

public class PerformStringShifts {

    /**
     * You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:
     *
     * direction can be 0 (for left shift) or 1 (for right shift).
     * amount is the amount by which string s is to be shifted.
     * A left shift by 1 means remove the first character of s and append it to the end.
     * Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
     * Return the final string after all operations.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "abc", shift = [[0,1],[1,2]]
     * Output: "cab"
     * Explanation:
     * [0,1] means shift to left by 1. "abc" -> "bca"
     * [1,2] means shift to right by 2. "bca" -> "cab"
     * Example 2:
     *
     * Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
     * Output: "efgabcd"
     * Explanation:
     * [1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
     * [1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
     * [0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
     * [1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
     */


    public String stringShift(String s, int [][] shift) {
        String str = s;
        int strLen = str.length();

        char [] charArr = str.toCharArray();
        for (int i = 0; i < shift.length; i++) {
            int direction = shift[i][0];
            int moveCount = shift[i][1];
            if(direction == 0) {
                // left
                char temp;
                for (int j = 0; j < moveCount; j++) {
                    temp = charArr[0];
                    for (int k = 0; k < charArr.length; k++) {
                        if(k == charArr.length - 1) {
                            charArr[k] = temp;
                        } else {
                            charArr[k] = charArr[k+1];
                        }
                    }
                }
            } else {
                // right
                char temp;
                for (int j = 0; j < moveCount; j++) {
                    temp = charArr[charArr.length-1];
                    for (int k = charArr.length-1; k >= 0; k--) {
                        if(k == 0) {
                            charArr[k] = temp;
                        } else {
                            charArr[k] = charArr[k-1];
                        }
                    }
                }
            }
        }
        str = String.valueOf(charArr);
        return str;
    }



    public static void main(String [] args) {
        PerformStringShifts performStringShifts = new PerformStringShifts();
        String str = "abc";
        int [][] shift = {{0,0} , {0,0} , {1,1}};
        String result = performStringShifts.stringShift(str , shift);
        System.out.println("result : " + result);
    }



}
