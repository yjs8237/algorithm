package com.greatyun.algorithm.array;

/**
 * LeetCode 1299.  Replace Elements with Greatest Element on Right Side
 *
 * Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.
 *
 * After doing so, return the array.
 *
 * Example 1:
 *
 * Input: arr = [17,18,5,4,6,1]
 * Output: [18,6,6,6,1,-1]
 *
 * Constraints:
 *
 * 1 <= arr.length <= 10^4
 * 1 <= arr[i] <= 10^5
 */
public class ReplaceElements {

    public static int[] solution(int [] arr) {
        if(arr.length == 0) {
            return new int[]{};
        }
        int [] ret = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if(i == arr.length-1) {
                ret[i] = -1;
            } else {
                ret[i] = getGreatestValue(arr , i + 1, arr.length);
            }
        }
        for (int i = 0; i < ret.length; i++) {
            System.out.print(" " + ret[i]);
        }
        return ret;
    }

    private static int getGreatestValue(int[] arr, int start, int end) {
        int maxValue = Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            maxValue = Math.max(maxValue , arr[i]);
        }
        return maxValue;
    }


    public static void main(String[] args) {
        int  [] arr = {17,18,5,4,6,1};
        ReplaceElements.solution(arr);
    }
}
