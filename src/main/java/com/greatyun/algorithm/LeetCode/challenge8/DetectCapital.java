package com.greatyun.algorithm.LeetCode.challenge8;

import java.util.HashSet;
import java.util.Set;

public class DetectCapital {

    public boolean detectCapitalUse(String word) {
        boolean ret = false;

        boolean isFirstUpper = false;
        int upperCnt = 0;
        int lowerCnt = 0;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(i ==0 && Character.isUpperCase(chars[i])) {
                isFirstUpper = true;
            }

            if(Character.isUpperCase(chars[i])) {
                upperCnt++;
            }
            if(Character.isLowerCase(chars[i])) {
                lowerCnt++;
            }

        }

        if(isFirstUpper && upperCnt == word.length()) {
            ret = true;
        } else if(isFirstUpper && upperCnt == 1) {
            ret = true;
        } else if(upperCnt == 0 || lowerCnt == 0 ) {
            ret = true;
        }

        return ret;
    }


    public static void main(String[] args) {

    }
}
