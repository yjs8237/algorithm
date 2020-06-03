package com.greatyun.algorithm.dinamic;

public class Memoization {


    public static void solution(int num) {

        int [] arr = new int[num+1];

//        int dfs = dfs(arr, num);
        arr[1] = 1;
        arr[2] = 2;
        int dfs = bottomup(arr, num);
        System.out.println(dfs);

    }

    private static int bottomup(int[] arr, int num) {

        for (int i = 3; i < num+1; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[num];
    }

    public static int dfs(int [] arr , int num) {
        if(arr[num] != 0) {
            return arr[num];
        }
        if(num == 1 || num == 2) {
            return num;
        } else {
            arr[num] = dfs(arr , num - 1) + dfs(arr , num-2);
        }
        return arr[num];
    }

    public static void main(String[] args) {
        Memoization.solution(7);
    }
}
