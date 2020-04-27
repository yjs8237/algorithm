package com.greatyun.algorithm.LeetCode;

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
    public static void main(String[] args) {
        JumpGame obj = new JumpGame();
//        int [] arr = {2,3,1,1,4};
//        int [] arr = {3,2,1,0,4};
//        int [] arr = {1,2};
                int [] arr = {2,0};

        System.out.println(obj.canJump(arr));
    }
}
