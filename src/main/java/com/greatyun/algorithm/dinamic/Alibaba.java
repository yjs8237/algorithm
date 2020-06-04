package com.greatyun.algorithm.dinamic;

public class Alibaba {

    /**
     * 알리바바는 40인의 도둑으로부터 금화를 훔쳐 도망치고 있습니다. 알리바바는 도망치는 길에 평소에 잘 가지 않던 계곡의 돌다리로 도망가고자 한다. 계곡의 돌다리는 N×N개의 돌들로 구성되어 있다. 각 돌다리들은 높이가 서로 다릅니다. 해당 돌다리를 건널때 돌의 높이 만큼 에너지가 소비됩니다. 이동은 최단거리 이동을 합니다. 즉 현재 지점에서 오른쪽 또는 아래쪽으로만 이동해야 합니다. N*N의 계곡의 돌다리 격자정보가 주어지면 (1, 1)격자에서 (N, N)까지 가는데 드는 에너지의 최소량을 구하는 프로그램을 작성하세요. 만약 N=3이고, 계곡의 돌다리 격자 정보가 다음과 같다면
     * 3 3 5
     * 2 3 4
     * 6 5 2
     * (1, 1)좌표에서 (3, 3)좌표까지 가는데 드는 최소 에너지는 3+2+3+4+2=14이다.
     * ▣ 입력설명 첫 번째 줄에는 자연수 N(1<=N<=20)이 주어진다. 두 번째 줄부터 계곡의 N*N 격자의 돌다리 높이(10보다 작은 자연수) 정보가 주어진다.
     * ▣ 출력설명 첫 번째 줄에 (1, 1)출발지에서 (N, N)도착지로 가기 위한 최소 에너지를 출력한다.
     * ▣ 입력예제 1                                   5 3 7 2 1 9 5 8 3 9 2 5 3 1 2 3 5 4 3 2 1 1 7 5 2 4
     * ▣ 출력예제 1 25
     *
     */
    public static void solution(int [][] arr) {

        // 현재 좌표로 오기 까지 가능한 경로
        // [i-1][j] , [i][j-1]

        int [][] d = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr[0].length; j++) {

                if(i == 0 && j == 0) {
                    d[i][j] = arr[i][j];
                } else if(i == 0) {
                    d[i][j] = d[i][j-1] + arr[i][j];
                } else if(j == 0) {
                    d[i][j] = d[i-1][j] + arr[i][j];
                } else {
                    d[i][j] = Math.min(d[i-1][j] , d[i][j-1]) + arr[i][j];
                }
            }

        }

        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[0].length; j++) {
                System.out.print(d[i][j] + " ");
            }
            System.out.println();
        }



    }

    public static void main(String[] args) {
        int [][] arr = {{4,5,1} , {2,6,9} , {2,3,1}};
        Alibaba.solution(arr);
    }
}
