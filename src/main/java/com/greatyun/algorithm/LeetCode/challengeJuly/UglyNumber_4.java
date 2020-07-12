package com.greatyun.algorithm.LeetCode.challengeJuly;


/**
 * Write a program to find the n-th ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 *
 * Example:
 *
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note:
 *
 * 1 is typically treated as an ugly number.
 * n does not exceed 1690.
 */

public class UglyNumber_4 {
    public static int solution (int n) {
        int count = 1;
        int number = 2;

        if(n == 1) return n;
        while(true) {
            if((number % 2 == 0) || (number % 3 == 0) || (number % 5 == 0)) {
                count++;
                if(count == n) {
                    return number;
                }
            }
            number++;
        }
    }
    public static void main(String[] args) {
        System.out.println(UglyNumber_4.solution(11));
    }
}
