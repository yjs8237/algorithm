package com.greatyun.algorithm.LeetCode;

import java.util.HashMap;
import java.util.Stack;

public class JumpGame {

    /**
     * Given an array of non-negative integers, you are initially positioned at the first index of the array.
     *
     * Each element in the array represents your maximum jump length at that position.
     *
     * Determine if you are able to reach the last index.
     *
     * Example 1:
     *
     * Input: [2,3,1,1,4]
     * Output: true
     * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
     * Example 2:
     *
     * Input: [3,2,1,0,4]
     * Output: false
     * Explanation: You will always arrive at index 3 no matter what. Its maximum
     *              jump length is 0, which makes it impossible to reach the last index.
     */

    public boolean canJump(int[] nums) {
        if(nums.length == 0) return false;
        if(nums.length == 1 || nums.length == 2) return true;
        boolean isJump = false;

        int index = 0;
        int step = nums[index];
        int nextIndex = 0;
        while(true) {
            if(index == nums.length - 1) {
                isJump = true;
                break;
            } else if(index >= nums.length || step == 0) {
                isJump = false;
                break;
            }
            nextIndex = index + step;


            if(nextIndex >= nums.length) return false;
            step = nums[nextIndex];
            index = nextIndex;
        }
        return isJump;
    }


    /**
     *
     * 67. Add Binary
     * Easy
     *
     * 1546
     *
     * 258
     *
     * Add to List
     *
     * Share
     * Given two binary strings, return their sum (also a binary string).
     *
     * The input strings are both non-empty and contains only characters 1 or 0.
     *
     * Example 1:
     *
     * Input: a = "11", b = "1"
     * Output: "100"
     * Example 2:
     *
     * Input: a = "1010", b = "1011"
     * Output: "10101"
     */
    public String addBinary(String a, String b) {
        char[] char_a = a.toCharArray();
        char[] char_b = b.toCharArray();
        Stack<Character> stack = new Stack<>();

        int a_index = a.length() - 1;
        int b_index = b.length() - 1;
        int isUp = 0;
        while(a_index >= 0 || b_index >= 0) {
            int aVal = 0; int bVal = 0;
            if(char_a.length > a_index && a_index >= 0) {
                aVal = Integer.parseInt(String.valueOf(char_a[a_index]));
            }
            if(char_b.length > b_index && b_index >= 0) {
                bVal = Integer.parseInt(String.valueOf(char_b[b_index]));
            }
            int sum = aVal + bVal + isUp;
            if(sum >= 2) {
                isUp = 1;
            } else {
                isUp = 0;
            }
            a_index--; b_index--;
            System.out.println("aVal : " + aVal + " bVal : " + bVal + " sum : " + sum);
            if(sum > 2) stack.push('1');
            else if(sum % 2 == 0) stack.push('0');
            else stack.push('1');

        }

        if(isUp > 0) stack.push('1');
        StringBuilder stringBuilder = new StringBuilder();
        while(!stack.empty()) {
            stringBuilder.append(stack.pop());
        }

        return stringBuilder.toString();
    }


    /**
     *
     * Sqrt(x)
     * Easy
     *
     * 1155
     *
     * 1768
     *
     * Add to List
     *
     * Share
     * Implement int sqrt(int x).
     *
     * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
     *
     * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
     *
     * Example 1:
     *
     * Input: 4
     * Output: 2
     * Example 2:
     *
     * Input: 8
     * Output: 2
     * Explanation: The square root of 8 is 2.82842..., and since
     *              the decimal part is truncated, 2 is returned.
     */
    public int mySqrt(int x) {
        return (int)Math.sqrt(x);
    }

    /**
     * Climbing Stairs
     * Easy
     *
     * 3767
     *
     * 122
     *
     * Add to List
     *
     * Share
     * You are climbing a stair case. It takes n steps to reach to the top.
     *
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     *
     * Note: Given n will be a positive integer.
     *
     * Example 1:
     *
     * Input: 2
     * Output: 2
     * Explanation: There are two ways to climb to the top.
     * 1. 1 step + 1 step
     * 2. 2 steps
     * Example 2:
     *
     * Input: 3
     * Output: 3
     * Explanation: There are three ways to climb to the top.
     * 1. 1 step + 1 step + 1 step
     * 2. 1 step + 2 steps
     * 3. 2 steps + 1 step
     *
     */


    public static void main(String[] args) {
        JumpGame obj = new JumpGame();
//        int [] arr = {2,3,1,1,4};
//        int [] arr = {3,2,1,0,4};
//        int [] arr = {1,2};
                int [] arr = {2,0};

//        System.out.println(obj.canJump(arr));
        String str1 = "1111";
        String str2 = "1111";
//        System.out.println(obj.addBinary(str1 , str2));

        System.out.println(obj.mySqrt(4));
    }
}
