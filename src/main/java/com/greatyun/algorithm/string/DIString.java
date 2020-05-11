package com.greatyun.algorithm.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import static java.util.Comparator.reverseOrder;

public class DIString {
    public int[] diStringMatch(String S) {

        int [] ret = new int[S.length() + 1];

        int start = 0;
        int end = S.length();

        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == 'I') {
                ret[i] = start;
                start++;
            } else {
                ret[i] = end;
                end--;
            }
        }

        ret[S.length() + 1] = start;
        return ret;
    }

    private void swap(Integer[] ret, int i , boolean isIncresing) {
        if(isIncresing) {
            Arrays.sort(ret , i , ret.length);
        } else {
            Arrays.sort(ret , i , ret.length , Comparator.reverseOrder());
        }
    }

    public static void main(String[] args) {
        DIString obj = new DIString();
        String str = "IDID";
        obj.diStringMatch(str);
    }






















    /**
     * Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.
     *
     * Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:
     *
     * If S[i] == "I", then A[i] < A[i+1]
     * If S[i] == "D", then A[i] > A[i+1]
     *
     *
     * Example 1:
     *
     * Input: "IDID"
     * Output: [0,4,1,3,2]
     * Example 2:
     *
     * Input: "III"
     * Output: [0,1,2,3]
     * Example 3:
     *
     * Input: "DDI"
     * Output: [3,2,0,1]
     */
}
