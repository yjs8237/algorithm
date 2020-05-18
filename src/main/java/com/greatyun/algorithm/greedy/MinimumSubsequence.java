package com.greatyun.algorithm.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumSubsequence {

    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        if(nums.length == 0) return ret;
        if(nums.length == 1) {
            ret.add(nums[0]);
            return ret;
        }
        Arrays.sort(nums);
        int num1 = nums[nums.length-1];
        ret.add(num1);

        int target = num1;
        int index = nums.length-2;
        while(true) {
            int subSum = 0;
            int innerIndex = index;
            while(innerIndex >= 0) {
                subSum += nums[innerIndex];
                innerIndex--;
            }
            if(target > subSum) {
                break;
            } else {
                target += nums[index];
                ret.add(nums[index]);
                index--;
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        MinimumSubsequence obj = new MinimumSubsequence();
        int []arr = {10,2,5};
        List<Integer> integers = obj.minSubsequence(arr);
        for (Integer integet : integers) {
            System.out.println(integet);
        }
    }
}
