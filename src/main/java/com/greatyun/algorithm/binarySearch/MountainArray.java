package com.greatyun.algorithm.binarySearch;

public class MountainArray {

    public int peakIndexInMountainArray(int[] A) {
        int mid = A.length / 2;

        int start = 0;
        int end = A.length - 1;

        return search(A , start , end);
    }

    public int search(int [] A , int start , int end) {

        if(start >= end) return -1;
        int mid = (start + end) / 2;
        int before = A[mid-1];
        int after = A[mid+1];
        int target = A[mid];

        if(before < target && target < after) {
            return search(A , mid , end);
        } else if (before > target && target > after) {
            return search(A , start , mid);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int [] arr = {3,4,5,1};
        MountainArray obj = new MountainArray();
        System.out.println(obj.peakIndexInMountainArray(arr));
    }
}
