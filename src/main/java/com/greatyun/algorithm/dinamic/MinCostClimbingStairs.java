package com.greatyun.algorithm.dinamic;

public class MinCostClimbingStairs {

    public static int solution(int [] cost) {

        /**
         * bottom up 방식을 이용한 DP 문제 풀이
         */

        if(cost.length == 1) {
            return cost[0];
        }
        if(cost.length == 2) {
            return Math.min(cost[0] , cost[1]);
        }

        int [] d = new int[cost.length + 1];

        d[0] = cost[0];
        d[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
            d[i] = cost[i] + Math.min(d[i-1] , d[i-2]);
//            System.out.println(d[i]);
        }
        return Math.min(d[d.length-3] , d[d.length-2]);
    }

    public static void main(String[] args) {
        int [] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(MinCostClimbingStairs.solution(cost));
    }
}
