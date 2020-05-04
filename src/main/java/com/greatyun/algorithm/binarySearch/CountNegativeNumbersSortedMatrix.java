package com.greatyun.algorithm.binarySearch;

public class CountNegativeNumbersSortedMatrix {

    public int countNegatives(int[][] grid) {
        int ret = 0;
        for (int i = 0; i < grid.length; i++) {
            int [] arr = grid[i];
            int subSum = 0;
            int count = count(arr, 0, arr.length - 1, subSum);
            System.out.println(" " + i + " " + count);
            ret += count;
        }
        return ret;
    }

    public int count(int [] arr, int start , int end , int subSum) {
        if(start <= end) {
            int mid = (start + end) / 2;
            if(arr[mid] > 0) {
                subSum += count(arr , mid+1 , end , subSum);
            } else {
                int tempIndex = mid;
                while(tempIndex >= 0) {
                    if(arr[tempIndex] < 0) {
                        subSum++;
                        tempIndex--;
                    } else {
                        break;
                    }
                }
                tempIndex = mid+1;
                while(tempIndex <= arr.length - 1) {
                    if(arr[tempIndex] < 0) {
                        subSum++;
                    }
                    tempIndex++;
                }
            }
        }
        return subSum;
    }

    public static void main(String[] args) {
        CountNegativeNumbersSortedMatrix obj = new CountNegativeNumbersSortedMatrix();
        int [][] arr = {{4,3,2,1,0,-1} , {3,2,1,-1,-2,0} , {-1,-1,-2,-3,-4}};
        System.out.println(obj.countNegatives(arr));
    }
}
