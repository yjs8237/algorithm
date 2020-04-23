package com.greatyun.algorithm.LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class SubarraySumEqualsK {



    private int findCount(int[] nums, int start , int end , int k) {

        if(start > end) return -1;

        int mid = (start + end) / 2;
        if(nums[mid] > k) {
            findCount(nums , start , mid - 1 , k);
        } else if(nums[mid] < k) {
            findCount(nums , mid+1 , end , k);
        } else {
            return mid;
        }
        return -1;
    }

    public int subarraySum(int[] nums, int k) {

        int count = 0;
        HashMap<String , String> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int subSum = 0;
            String key = "";
            for (int j = i+1; j < nums.length; j++) {

                subSum += nums[j];
                if(k == nums[i] + nums[j] && j-i == 1) {
                    count++;

                } else if(k == nums[i] + subSum) {
                    //System.out.println("2 [" + nums[i] + "] j [" + nums[j] + "]");
                    count++;
                }
            }
            if(k == nums[i]) {
                count++;
            }

        }
        return count;
    }

    public static void main(String []args) {
        SubarraySumEqualsK obj = new SubarraySumEqualsK();
        int [] arr = {1,1,1};
        int k = 2;
        System.out.println("count : " + obj.subarraySum(arr , k));
    }

}
