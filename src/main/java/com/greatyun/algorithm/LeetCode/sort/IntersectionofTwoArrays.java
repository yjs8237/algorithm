package com.greatyun.algorithm.LeetCode.sort;

import java.util.*;

public class IntersectionofTwoArrays {
    /**
     * Intersection of Two Arrays
     * Easy
     *
     * 710
     *
     * 1122
     *
     * Add to List
     *
     * Share
     * Given two arrays, write a function to compute their intersection.
     *
     * Example 1:
     *
     * Input: nums1 = [1,2,2,1], nums2 = [2,2]
     * Output: [2]
     * Example 2:
     *
     * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * Output: [9,4]
     * Note:
     *
     * Each element in the result must be unique.
     * The result can be in any order.
     */
    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < nums1.length; i++) {
            int num1 = nums1[i];
            for (int j = 0; j < nums2.length; j++) {
                if(num1 == nums2[j]) {
                    set.add(num1);
                }
            }
        }
        int [] ret = new int[set.size()];
        Iterator<Integer> iterator = set.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            ret[index] = iterator.next();
            index ++;
        }
        return ret;
    }

    public static void main(String[] args) {
        IntersectionofTwoArrays obj = new IntersectionofTwoArrays();
        int [] num1 = {1,2,3};
        int [] num2 = {1,2,3};
        int[] intersection = obj.intersection(num1, num2);
        for (int i = 0; i < intersection.length; i++) {
            System.out.print(" " + intersection[i]);
        }
    }
}
