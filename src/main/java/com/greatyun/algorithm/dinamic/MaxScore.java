package com.greatyun.algorithm.dinamic;

public class MaxScore {

    public static void solution (int [][] arr , int maxTime) {

        /**
         * 메모라이즈 배열을 2차원 배열로하게 되면 공간복잡도가 높아진다..
         * 1차원배열로 사용하면 되는데..
         * 만약 문제에서 해당 아이템 (파라미터 array) 를 딱 1번만 사용할 수 있다 라는 조건이 있을경우에는
         * 1차원 배열로 사용하면 중복으로 사용하게 된다..
         * 이럴때는 메모라이즈 배열 탐색을 index 0 부터가 아닌 뒤에서 부터 하게 되면
         * 중복 탐색을 안하게 된다.....
         */


        int [] d = new int[maxTime + 1];

        for (int i = 0; i < arr.length; i++) {
            int startIndex = arr[i][0];
            for (int j = startIndex; j < d.length; j++) {

                if(j == arr[i][1]) {
                    // 시간이 딱맞는경우
                    d[i+1] = Math.max(d[i+1] , arr[i][0]);
                } else if(j > arr[i][1]) {
                    // 시간이 남는경우
                    int lastValue = j - arr[i][1];  // 나머지
                    d[i+1] = Math.max(d[i+1] , d[lastValue] + arr[i][0]);
                    System.out.print(d[i+1] + " ");
                } else {
                    // 시간이 모자를 경우
                }
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int [][] arr = {{10,5} , {25,12} , {15,8} , {6,3} , {7,4}};
        int maxScore = 20;
        MaxScore.solution(arr , maxScore);
    }
}
