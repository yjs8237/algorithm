package com.greatyun.algorithm.LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class ContiguousArray {

    /**
     * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
     *
     * Example 1:
     * Input: [0,1]
     * Output: 2
     * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
     * Example 2:
     * Input: [0,1,0]
     * Output: 2
     * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
     * Note: The length of the given binary array will not exceed 50,000.
     *
     */

    public int findMaxLength(int[] nums) {
        HashMap<Integer , Integer> map = new HashMap<>();
        int maxCount = 1;
        int tempNum = -1;
        for (int i = 0; i < nums.length; i++) {
            if(tempNum != -1) {
                if(isContinueNum(tempNum , nums[i])) {
                    if(!map.containsKey(tempNum+nums[i])) {
                        maxCount++;
                        map.put(tempNum + nums[i] , i);
                    }
                }
            }
            tempNum = nums[i];
        }
        return maxCount;
    }

    public boolean isContinueNum(int num1 , int num2) {
        int result = num1 - num2;
        if(result == 1 || result == -1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String []args) {
        ContiguousArray contiguousArray = new ContiguousArray();
        int [] arr = {0,1,0};
        int result = contiguousArray.findMaxLength(arr);
        System.out.println("result : " + result);
    }

}
