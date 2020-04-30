package com.greatyun.algorithm.LeetCode.binarySearch;

public class FirstBadVersion {

    public int firstBadVersion(int n) {
        int first = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;

        int [] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+1;
        }

        int mid = (arr.length) / 2;
        int index = searchFirstBadVersion(arr, 0, mid);
        if(index == -1) {
            index = searchFirstBadVersion(arr, mid, arr.length);
        }

        first = index;
        end = index;

        System.out.println("index : " + index);

        System.out.println("2. first -> " + first);

        boolean isTarget = true;
        int targetIndex = first;
        while(isTarget) {
            if(targetIndex >= 0) {
                isTarget = isBadVersion(arr[targetIndex]);
                if(isTarget) {
                    first = targetIndex;
                    targetIndex--;
                } else {

                }
            } else {
                isTarget = false;
            }
        }

        System.out.println("1. first -> " + first);

        isTarget = true;
        targetIndex = end;
        while(isTarget) {

            if(targetIndex < arr.length) {
                isTarget = isBadVersion(arr[targetIndex]);
                if(isTarget) {
                    end = targetIndex;
                    targetIndex++;
                }
            } else {
                isTarget = false;
            }
        }

        int ret = first < 0 ? arr[end] : arr[first];

        System.out.println(first + " , " + end);
        return ret;
    }

    public int searchFirstBadVersion(int [] arr , int start , int end) {

        if(start > end) return -1;

        int mid = (start+end) / 2;

        if(!isBadVersion(arr[mid])) {
            searchFirstBadVersion(arr , start , mid - 1);
        } else {
            return mid;
        }
        return -1;
    }


    public boolean isBadVersion(int n) {
        if(from <= n && end >= n) {
            return true;
        } else {
            return false;
        }
    }

    int from = 1;
    int end = 2;

    public static void main(String[] args) {
        FirstBadVersion obj = new FirstBadVersion();
        System.out.println("result : " + obj.firstBadVersion(4));
    }
}
