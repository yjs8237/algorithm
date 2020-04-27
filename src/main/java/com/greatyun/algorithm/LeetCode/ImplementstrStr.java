package com.greatyun.algorithm.LeetCode;

public class ImplementstrStr {

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0) return 0;

        for (int i = 0; i < nums.length; i++) {
            if(i < nums.length) {
                if(nums[i] >= target) {
                    return i;
                } else if(nums[i] < target) {
                    continue;
                }
            }
        }
        return nums.length;
    }




    public static void main(String[] args) {
        ImplementstrStr obj = new ImplementstrStr();
        String haystack = "hello";
        String needle = "ll";
//        System.out.println(obj.strStr(haystack , needle));

        int [] arr = {1,3,5,6};
        int target = 5;
        System.out.println(obj.searchInsert(arr , target));
    }
}
