package com.greatyun.algorithm.hackerRank;

public class JumpingClouds {
    static int jumpingOnClouds(int[] c) {

        int count = -1;
        int n = c.length;
        for (int i = 0; i < n; i++, count++) {
            if (i<n-2 && c[i+2]==0) i++;
        }
        return count;
    }
    public static void main(String[] args) {
//        int [] c = {0,0,0,1,0,0};
        int [] c = {0,1,0,1,0,0,0,0,0};
        System.out.println(JumpingClouds.jumpingOnClouds(c));
    }
}
