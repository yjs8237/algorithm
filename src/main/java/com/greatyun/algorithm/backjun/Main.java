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
        String first = bufferedReader.readLine();
        String second = bufferedReader.readLine();

        int secodelen = second.length();

        int ret = 0;
        for (int i = 0; i < first.length(); i+=secodelen) {
            if(first.length() >= i+secodelen) {
                String target = first.substring(i , i + secodelen);
                if(target.equals(second)) {
                    ret++;
                }
            }
        }
        System.out.println(ret);
    }
}
