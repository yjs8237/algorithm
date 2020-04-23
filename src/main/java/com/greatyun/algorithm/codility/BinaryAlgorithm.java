package com.greatyun.algorithm.codility;

public class BinaryAlgorithm {
    static class Solution {
        public int solution(int K, int M, int[] A) {
            // write your code in Java SE 8

            return 0;
        }
        public void recur3(int n) {
            if(n > 0) {
                recur3(n-1);
                recur3(n-2);
                System.out.print(n + " , ");
            }
        }
        public void recur4(int n) {

        }
    }

    public static void main( String [] args) {
        Solution solution = new Solution();

        solution.recur3(5);
//        solution.solution();
    }


}
