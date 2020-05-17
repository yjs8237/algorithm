package com.greatyun.algorithm.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Test1 {

    public String solution(String str , String str1) {
        String ret = "";

        int count = Integer.parseInt(str);
        String[] arr = str1.split(" ");

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int target = Integer.parseInt(arr[i]);
            min = Math.min(min , target);
            max = Math.max(max , target);
        }
        ret = String.valueOf(min) + " " + String.valueOf(max);
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        String str1 = bufferedReader.readLine();
        Test1 obj = new Test1();
        System.out.println(obj.solution(str , str1));
    }

}
