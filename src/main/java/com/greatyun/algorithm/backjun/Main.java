package com.greatyun.algorithm.backjun;

import java.io.*;
import java.util.*;

public class Main {

    public List<String> solution(int N) {
        List<String> ret = new ArrayList<>();

        for(int i=1; i<10; i++) {
            String str = String.valueOf(N) + " * " + i + " = " + String.valueOf(N*i);
            ret.add(str);
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String count = bufferedReader.readLine();
        int [] arr = new int[123];
        for (int i = 97; i < arr.length; i++) {
            arr[i] = -1;
        }
        for (int i = 0; i < count.length(); i++) {
            String str = count.substring(i , i+1);
            char c = str.charAt(0);
            if(arr[c] == -1) {
                arr[c] = i;
            }
        }

        for (int i = 97; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}
