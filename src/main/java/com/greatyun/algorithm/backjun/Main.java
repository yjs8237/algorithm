package com.greatyun.algorithm.backjun;

import java.io.*;
import java.util.*;

public class Main {

    public static int solution (int n) {

        int [] arr = new int[n+1];
        return fibonacci_bottomup(arr, n);

    }

    public static int fibonacci_bottomup(int [] arr , int n) {

        if(arr[n] != 0) return arr[n];

        if(n == 0 || n == 1) {
            return n;
        }
        arr[n] = fibonacci_bottomup(arr , n-1) + fibonacci_bottomup(arr , n-2);
        return arr[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String first = bufferedReader.readLine();
        System.out.print(Main.solution(Integer.parseInt(first)));
    }
}
