package com.greatyun.algorithm.dinamic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Knapsack {

    /**
     * 정해진 가방 용량에 가장 효율적으로 물건을 채우는 알고리즘을 구현하시오
     * amount : 가방 크기
     * List<Stuff> list : 담을 수 있는 물건
     */

    static class Stuff {
        String name;
        int weight;
        int cost;

        public Stuff(String name , int weight , int cost) {
            this.name = name;
            this.weight = weight;
            this.cost = cost;
        }
    }


    public int bestCost(List<Stuff> list , int amount) {

        // 2차원 배열 생성 (모든 element 0으로 초기화 )
        int [][] arr = new int[list.size()+1][amount+1];

        for (int i = 1; i < arr.length; i++) {

            Stuff stuff = list.get(i-1);
            System.out.println(stuff.cost);
            for (int j = 1; j < amount; j++) {

                if(j >= stuff.weight) {
                    // 들어갈 수 있는 공간
                    if(j > stuff.weight){
                        // 해당물건의 크기가 들어가고 남은 여유 공간이 있을 경우
                        // 남은 공간에 대한 이전 최적 비용값 + 현재 물건의 비용 과 현재 열 (J) 인덱스 이전 I 행 인덱스의
                        // 최적 비용과 비교하여 더 큰 값을 삽입한다.
                        int index = j - stuff.weight;
                        System.out.println("index : " + index);
                        if((arr[i-1][index] + stuff.cost) > arr[i-1][j]) {
                            arr[i][j] = arr[i-1][index] + stuff.cost;
                        }

                    } else if(j == stuff.weight) {

                    } else {

                    }

                } else {
                    // 들어갈 수 없는 공간
                    arr[i][j] = arr[i-1][j];
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        return 0;
    }

    public void solution (int [][] arr , int amount) {

        int [][] d = new int [arr.length+1][amount+1];

        for (int i = 1; i < d.length; i++) {

            for (int j = 1; j < d[0].length; j++) {

                if(arr[i-1][0] == j) {
                    // 가방 크기가 딱 맞는 경우
                    // 나의 가치와 이전 메모라이즈 최대 가치와 비교하여 최고의 가치를 기억한다.
                    d[i][j] = Math.max(d[i-1][j] , arr[i-1][1]);
                } else if(arr[i-1][0] < j) {
                    // 물건을 담고 가방 크기가 남은 경우
                    int myValue = arr[i-1][1];
                    int anotherValue = d[i][j-arr[i-1][0]];
                    d[i][j] = Math.max((myValue + anotherValue) , d[i-1][j]);
                } else {
                    // 물건의 크기가 더 큰 경우
                    d[i][j] = d[i-1][j];
                }


            }
        }

        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[0].length; j++) {
                System.out.print(d[i][j] + " ");
            }
            System.out.println();
        }
        String temp = "";
    }

    public int solution(int[] d, int budget) {
        int answer = 0;

        int [][] memo = new int[d.length+1][budget+1];

        System.out.println(memo[0].length);

        for(int i=1; i < memo.length; i++) {
            for(int j=1; j < memo[0].length; j++) {
                System.out.println("i : "+ i + " , j : " + j);
                if(j == d[i-1]) {
                    // 딱 맞을 경우
                    memo[i][j] = Math.max(memo[i-1][j] , d[i-1]);
                } else if(j > d[i-1]) {
                    // 들어가고 남을 경우
                    int myValue = d[i-1];
                    int bestPrevValue = memo[i][j - myValue];

                    memo[i][j] = Math.max(memo[i-1][j] , (myValue + bestPrevValue));
                } else {
                    // 모자를 경우
                    memo[i][j] = memo[i-1][j];
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) {
//        Stuff s1 = new Stuff("A" , 1 , 1500);
        Stuff s2 = new Stuff("B" , 3 , 1000);
//        Stuff s3 = new Stuff("C" , 5 , 2000);
        List<Stuff> list = new ArrayList<>();
        list.add(s2);
//        list.add(s1);
//        list.add(s3);
        Knapsack obj = new Knapsack();
        //obj.bestCost(list , 5);
        int [][] arr = {{4,11} , {5,12} , {3,8} , {6,14} , {4,8}};


        String temp = "1234";
        StringBuilder builder = new StringBuilder();


        int [] d = {1,3,2,4,5};
        obj.solution(d , 9);
//        obj.solution(arr , 17);
    }
}
