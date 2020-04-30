package com.greatyun.algorithm.LeetCode.binarySearch;

import com.greatyun.algorithm.LeetCode.TwoSum;

public class TwoSum2 {

    public int[] twoSum(int[] numbers, int target) {
        int[] ret = new int [2];
        int targetIndex = -1;
        if(numbers[numbers.length-1] <= target) {
            targetIndex = numbers.length-1;
            startIndex = 0;
            endIndex = targetIndex;
        } else {
            targetIndex = searchTargetIndex(numbers , 0 , numbers.length-1 , target);
        }

        System.out.println("targetIndex = " + targetIndex);
        System.out.println("startIndex = " + startIndex);
        System.out.println("endIndex = " + endIndex);

        if(targetIndex != -1) {
            if(numbers[targetIndex] < 0) {
                ret[0] = targetIndex + 1;
                ret[1] = targetIndex + 2;
                return ret;
            }
        }

        for (int i = endIndex; i >= 0; i--) {
            for (int j = 0; j < endIndex; j++) {

                if(target == numbers[i] + numbers[j]) {
                    ret[0] = j+1;
                    ret[1] = i+1;
                    return ret;
                }

            }
        }

        return ret;
    }


    Integer startIndex = Integer.MIN_VALUE;
    Integer endIndex = Integer.MAX_VALUE;
    private int searchTargetIndex(int[] numbers, int start , int end , int target) {
        if(start > end) return -1;
        int mid = (start + end) / 2;
        if(numbers[mid] > target) {
            if(endIndex > mid) {
                endIndex = mid;
            }
            searchTargetIndex(numbers , start , mid-1 , target);
        } else if( numbers[mid] < target) {
            if(startIndex < mid) {
                startIndex = mid;
            }
            searchTargetIndex(numbers , mid+1 , end , target);
        } else {
            startIndex = 0;
            endIndex = mid;
            return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        TwoSum2 obj = new TwoSum2();
        int [] numbers = {-1 , 0};
        int target = -1;
        int[] ret = obj.twoSum(numbers, target);
        for (int num : ret) {
            System.out.print(  " " + num);
        }
    }
}
