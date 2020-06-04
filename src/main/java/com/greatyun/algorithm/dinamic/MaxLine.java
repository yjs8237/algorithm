package com.greatyun.algorithm.dinamic;

public class MaxLine {

    /**
     * 왼쪽의 번호와 오른쪽의 번호가 있는 그림에서 같은 번호끼리 선으로 연결하려고 합니다. 왼쪽번호는 무조건 위에서부터 차례로 1부터 N까지 오름차순으로 나열되어 있습니다. 오른쪽의 번호 정보가 위부터 아래 순서로 주어지만 서로 선이 겹치지 않고 최대 몇 개의 선 을 연결할 수 있는 지 구하는 프로그램을 작성하세요.
     * 1 4
     * 2 1
     * 3 2
     * 4 3
     * 5 9
     * 6 7
     * 7 5
     * 8 6
     * 9 10
     * 10 8
     * 왼쪽 오른쪽
     * 위의 그림은 오른쪽 번호 정보가 4 1 2 3 9 7 5 6 10 8 로 입력되었을 때 선이 서로 겹치지 않고 연결할 수 있는 최대 선을 개수 6을 구한 경우입니다.
     * ▣ 입력설명 첫 줄에 자연수 N(1<=N<=100)이 주어집니다. 두 번째 줄에 1부터 N까지의 자연수 N개의 오른쪽 번호 정보가 주어집니다. 순서는 위쪽번호 부터 아래쪽번호 순으로입니다.
     * ▣ 출력설명 첫 줄에 겹치지 않고 그을 수 있는 최대선의 개수를 출력합니다.
     */

    public static void solution(int [] arr_1 , int [] arr_2) {
        int [] d = new int[arr_1.length + 1];
        int ret = 0;
        for (int i = 0; i < arr_1.length; i++) {
            for (int j = 0; j < arr_2.length; j++) {



                if(arr_1[i] == arr_2[j]) {
                    if(i == 0 || d[i-1] < j ) {
                        System.out.println("j : " + j);
                        d[i] = j;
                        ret++;
                    } else {
                        d[i] = d[i-1];
                    }
                }
            }
        }
        System.out.println(ret);
    }

    public static void main(String[] args) {
        int [] arr1 = {1,2,3,4,5};
        int [] arr2 = {5,2,1,4,3};

        MaxLine.solution(arr1 , arr2);
    }
}
