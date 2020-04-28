package com.greatyun.algorithm.dinamic;

import java.util.ArrayList;
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

    public static void main(String[] args) {
        Stuff s1 = new Stuff("A" , 1 , 1500);
        Stuff s2 = new Stuff("B" , 3 , 1000);
        Stuff s3 = new Stuff("C" , 5 , 2000);
        List<Stuff> list = new ArrayList<>();
        list.add(s2);
        list.add(s1);
        list.add(s3);
        Knapsack obj = new Knapsack();
        obj.bestCost(list , 5);


    }
}
