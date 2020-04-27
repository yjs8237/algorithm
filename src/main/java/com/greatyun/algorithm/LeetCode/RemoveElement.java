package com.greatyun.algorithm.LeetCode;

import java.util.Arrays;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == val) {
                nums[i] = Integer.MAX_VALUE;
            } else {
                result++;
            }
        }
        Arrays.sort(nums);
        return result;
    }

    public static void main(String[] args) {
        RemoveElement obj = new RemoveElement();
        int [] arr = {0,0,0,1,2,3};
        int val = 0;
        System.out.println(obj.removeElement(arr , val));
    }
}
