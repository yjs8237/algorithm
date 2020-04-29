package com.greatyun.algorithm.LeetCode;

import java.util.Arrays;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int index = 0;
        for (int i = m; i < nums1.length; i++) {
            nums1[i] = nums2[index];
            index++;
        }
        Arrays.sort(nums1);
    }

    public static void main(String[] args) {
        MergeSortedArray obj = new MergeSortedArray();
    }
}
