package com.greatyun.algorithm.dinamic;

public class NetworkCable {

    public int solution (int k) {
        int ret = 0;
        int [] arr = new int[k];

        arr[0] = 1;
        arr[1] = 1;


        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[arr.length - 1];
    }

    public static void main(String[] args) {
        NetworkCable obj = new NetworkCable();
        System.out.println(obj.solution(7));
    }
}
