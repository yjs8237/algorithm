package com.greatyun.algorithm.LeetCode.challengeJuly;

/**
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
 *
 * Given n, find the total number of full staircase rows that can be formed.
 *
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 *
 * Example 1:
 *
 * n = 5
 *
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤
 *
 * Because the 3rd row is incomplete, we return 2.
 * Example 2:
 *
 * n = 8
 *
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 *
 * Because the 4th row is incomplete, we return 3.
 */
public class ArrangingCoins_1 {


    public static int solution (int n) {
        int ret = 0;
        if(n == 0 ) return ret;
        int total = 0;
        int count = 0;
        while (true) {
            count++;
            total += count;
            if(count >= n - total) {
                ret = count;
                break;
            }
        }
//        System.out.println(ret);
        return ret;
    }
    public static void main(String[] args) {
        ArrangingCoins_1.solution(0);
    }
}
