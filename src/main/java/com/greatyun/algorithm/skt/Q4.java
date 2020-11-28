package com.greatyun.algorithm.skt;

public class Q4 {
    public int solution(int[] A, int K) {
        // write your code in Java SE 8
        int result = Integer.MAX_VALUE;

        // Array 길이가 제거하려는 개수 K 보다 작을 경우 0을 리턴.
        if(A.length < K) return 0;

        for (int i = 0; i < A.length; i++) {

            // K 값 기준으로 비교를 하지 말아야 하는 last index 를 구하자.
            int lastIndex = i + K - 1;

            // 제거 element 를 제외한 나머지 element 의 최대값 , 최소값 을 구하자
            int maxValue = Integer.MIN_VALUE;
            int minValue = Integer.MAX_VALUE;

            for (int j = 0; j < A.length; j++) {
                // 비교를 하지 말아야 할 타겟 index 는 pass
                if(j >= i && j <= lastIndex) continue;

                // Max , Min 값을 계속 구한다.
                maxValue = Math.max(maxValue , A[j]);
                minValue = Math.min(minValue , A[j]);
            }
            // Max 와 Min 값의 차이가 가장 작은 최종 Min 값을 구하자
            result = Math.min(result , (maxValue - minValue));

        }

        return result;
    }
    public static void main(String[] args) {
        Q4 obj = new Q4();
        int [] A = {5,3,6,1,3};
        int K = 2;
        System.out.println("result ->  " + obj.solution(A , K));
    }
}
