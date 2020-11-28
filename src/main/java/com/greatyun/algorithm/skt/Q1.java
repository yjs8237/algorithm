package com.greatyun.algorithm.skt;

import java.util.Arrays;

public class Q1 {

    int solution(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;;
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0;
        for (int k = 0; k < n; k++) {
            if (i < m - 1 && B[i] < A[k])
                i += 1;
            if (m > 0 && A[k] == B[i])
                return A[k];
        }
        return -1;
    }

    public static void main(String[] args) {
        Q1 q1 = new Q1();
        int [] A = {1,2,3,4,5,0};
        int [] B = {};
        System.out.println(q1.solution(A , B));
    }
}
