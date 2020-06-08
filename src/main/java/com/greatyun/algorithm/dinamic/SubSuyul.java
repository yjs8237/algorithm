package com.greatyun.algorithm.dinamic;

public class SubSuyul {

    public static void solution (int []arr) {
        int [] d = new int[arr.length + 1];
        d[0] = 1;
        int ret = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i-1; j >= 0; j--) {
                if(arr[i] > arr[j]) {
                    max = Math.max(max , d[j]);
                }
            }
            d[i] = max + 1;
            ret = Math.max(ret , d[i]);
        }
        System.out.println(ret);
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,0};
        SubSuyul.solution(arr);
    }
}
