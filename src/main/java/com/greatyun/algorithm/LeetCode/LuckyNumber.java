package com.greatyun.algorithm.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1380. Lucky Numbers in a Matrix
 * Easy
 *
 * 215
 *
 * 25
 *
 * Add to List
 *
 * Share
 * Given a m * n matrix of distinct numbers, return all lucky numbers in the matrix in any order.
 *
 * A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.
 *
 *
 *
 * Example 1:
 *
 * Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
 * Output: [15]
 * Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column
 * Example 2:
 *
 * Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
 * Output: [12]
 * Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
 * Example 3:
 *
 * Input: matrix = [[7,8],[1,2]]
 * Output: [7]
 */
public class LuckyNumber {

    public static List<Integer> sol(int [][] matrix) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                int target = matrix[i][j];

                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;

                for (int k = 0; k < matrix[0].length; k++) {
                    min = Math.min(min , matrix[i][k]);
                }
                for (int k = 0; k < matrix.length; k++) {
                    max = Math.max(max , matrix[k][j]);
                }
                if(target == min && target == max) {
                    ret.add(target);
                }
            }
        }
        return ret;
    }
    public static void main(String[] args) {

    }
}
