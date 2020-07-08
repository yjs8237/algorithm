package com.greatyun.algorithm.hackerRank;

public class JumpingClouds {
    static int jumpingOnClouds(int[] c) {

        int index = 0;
        int ret = 0;
        boolean isZero = false;

        while (true) {
            int next = index + 1;
            int twoNext = index + 2;
            if (index >= c.length) {
                break;
            }
            if (c[index] == 1) {
                index++;
                continue;
            } else if (c[index] == 0) {
                if (next < c.length && c[next] == 0) {
                    if (isZero) {
                        isZero = false;
                        continue;
                    } else {
                        isZero = true;
                        //ret++;
                    }
                } else {
                    isZero = false;
                    //ret++;
                }
                ret++;
            }
            index++;
        }

        return ret;
    }
    public static void main(String[] args) {
        int [] c = {0,0,0,1,0,0};
        System.out.println(JumpingClouds.jumpingOnClouds(c));
    }
}
