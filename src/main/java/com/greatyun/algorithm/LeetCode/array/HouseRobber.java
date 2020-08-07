package com.greatyun.algorithm.LeetCode.array;

public class HouseRobber {
    public int rob(int[] nums) {
        int ret = Integer.MIN_VALUE;

        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i % 2 ==0) {
                num2 += nums[i];
            } else {
                num1 += nums[i];
            }
        }
        return Math.max(num1 , num2);
    }
    public static void main(String[] args) {
        HouseRobber obj = new HouseRobber();
        int [] nums = {1,2,3,1};
        System.out.println(obj.rob(nums));
    }
}
