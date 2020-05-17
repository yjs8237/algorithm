package com.greatyun.algorithm.backjun;

import java.util.Scanner;

public class Sample {

    public String solution(String input) {
        String[] arr = input.split(" ");
        if(Integer.parseInt(arr[0]) > Integer.parseInt(arr[1])) {
            return ">";
        } else if(Integer.parseInt(arr[0]) < Integer.parseInt(arr[1])){
            return "<";
        } else {
            return "==";
        }
    }
    public static void main(String[] args) {
        Sample obj = new Sample();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        System.out.println(obj.solution(input));
    }
}
