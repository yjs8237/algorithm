package com.greatyun.algorithm.array;

import java.util.LinkedList;

public class HowManyNumbers {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int [] ret = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if(nums[i] > nums[j]) {
                    count++;
                }
            }
            ret[i] = count;
        }
        return ret;
    }

    public static void main(String[] args) {
        HowManyNumbers obj = new HowManyNumbers();
        int [] arr = {1,2,3,4};
        obj.smallerNumbersThanCurrent(arr);
        System.out.println();
    }
}
