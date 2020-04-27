package com.greatyun.algorithm.LeetCode;

import java.util.ArrayList;

public class Palindrome {

    public boolean solution(int number) {

        return false;
    }
    public int lengthOfLastWord(String s) {

        if(s.length() == 0) return 0;

        String[] s1 = s.split(" ");
        if( s1.length == 0) return 0;

        return s1[s1.length-1].length();
    }

    public int[] plusOne(int[] digits) {
        if(digits.length == 0) return digits;
        int index = digits.length-1;
        boolean isUp = false;
        while(index >= 0) {

            if(index == digits.length-1) {
                int tempInt = digits[index];
                if(tempInt == 9) {
                    isUp = true;
                    digits[index] = 0;
                } else {
                    digits[index] = digits[index] + 1;
                }
            } else {
                if(isUp) {
                    int tempInt = digits[index];
                    if(tempInt == 9) {
                        isUp = true;
                        digits[index] = 0;
                    } else {
                        digits[index] = digits[index] + 1;
                        isUp = false;
                    }
                } else {
                    break;
                }
            }
            index--;
        }

        if(isUp) {
            int [] newResult = new int[digits.length + 1];
            newResult[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                newResult[i+1] = digits[i];
            }
            return newResult;
        }

        return digits;
    }

    public static void main(String[] args) {
        Palindrome obj = new Palindrome();
        String str = " ";
//        System.out.println(obj.lengthOfLastWord(str));
        int [] arr = {9};
        int[] ints = obj.plusOne(arr);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
        System.out.println();
    }
}
