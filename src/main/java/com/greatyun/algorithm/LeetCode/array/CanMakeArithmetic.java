package com.greatyun.algorithm.LeetCode.array;


import java.util.Arrays;
import java.util.HashSet;

/**
 * 1502. Can Make Arithmetic Progression From Sequence
 * Easy
 *
 * 73
 *
 * 6
 *
 * Add to List
 *
 * Share
 * Given an array of numbers arr. A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.
 *
 * Return true if the array can be rearranged to form an arithmetic progression, otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [3,5,1]
 * Output: true
 * Explanation: We can reorder the elements as [1,3,5] or [5,3,1] with differences 2 and -2 respectively, between each consecutive elements.
 * Example 2:
 *
 * Input: arr = [1,2,4]
 * Output: false
 * Explanation: There is no way to reorder the elements to obtain an arithmetic progression.
 */
public class CanMakeArithmetic {

    public static boolean sol(int [] arr) {
        boolean ret = true;
        Arrays.sort(arr);
        int start = 0;
        int end = arr.length - 1;
        HashSet<Integer> set = new HashSet<>();
        while (start < arr.length) {
            if(start < arr.length - 1) {
                int numberOne = Math.abs(arr[start] - arr[start + 1]);
                int numberTwo = Math.abs(arr[end] - arr[end - 1]);

                if(numberOne != numberTwo) {
                    return false;
                } else if(set.size() > 0 && !set.contains(numberOne)) {
                    return false;
                } else {
                    set.add(numberOne);
                }

            }
            start++;
            end--;
        }
        return ret;
    }

    public static void main(String[] args) {
        int [] arr = {1,100};
        System.out.println(CanMakeArithmetic.sol(arr));

    }
}
