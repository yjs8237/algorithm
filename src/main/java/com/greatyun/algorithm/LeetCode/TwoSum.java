package com.greatyun.algorithm.LeetCode;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        int [] result = new int[2];
        if(nums.length == 0) return result;
        if(nums.length == 1) return nums;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    public static void main(String [] args) {
        TwoSum obj = new TwoSum();

        int [] arr = {1,2,3};
        int target = 0;

        obj.twoSum(arr , target);
    }
}
