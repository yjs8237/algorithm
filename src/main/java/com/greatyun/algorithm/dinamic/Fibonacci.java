package com.greatyun.algorithm.dinamic;

public class Fibonacci {

    public static void solution (int n) {

        int [] arr = new int[n+1];
        int i = fibonacci_bottomup(arr, n);
        System.out.println(i);
    }

    public static int fibonacci_bottomup(int [] arr , int n) {

        if(arr[n] != 0) return arr[n];

        if(n == 0 || n == 1) {
            return n;
        }
        arr[n] = fibonacci_bottomup(arr , n-1) + fibonacci_bottomup(arr , n-2);
        return arr[n];
    }

    public static void main(String[] args) {
        Fibonacci.solution(17);
    }
}
