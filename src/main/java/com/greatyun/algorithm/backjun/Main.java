package com.greatyun.algorithm.backjun;

import java.io.*;
import java.util.*;

public class Main {

    public long solution(int N) {
        long answer = 0;

        int a1 = 1;
        int a2 = 1;
        int a3 = 0;

        System.out.println(a1);
        System.out.println(a2);
        List<Integer> list = new ArrayList<>();
        for(int i=3; i<=N; i++){
            a3=a1+a2;
            a1=a2;
            a2=a3;
            list.add(0 , a3);
        }
        System.out.println(list.get(0) + " , " + list.get(1));
        answer = (list.get(0) * 4) + (list.get(1) * 2);
        return answer;
    }


    public void maxValue(int [] arr) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if(max < arr[i]) {
                max = arr[i];
                index = i;
            }
        }
        System.out.println(max);
        System.out.println(index);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int [] arr = new int[9];
        for (int i = 0; i < 9; i++) {
            String str = bufferedReader.readLine();
            arr[i] = Integer.parseInt(str);
        }
        main.maxValue(arr);
    }
}
