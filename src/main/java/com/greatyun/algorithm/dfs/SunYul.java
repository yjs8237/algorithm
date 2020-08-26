package com.greatyun.algorithm.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 순열 구하기
 *
 * 상태트리 로 구해보자
 * 1부터 N까지 번호가 적힌 구슬이 있다 . 이중 M개를 뽑아 일렬로 나열하는 방법을 출력한다.
 *
 * [1,2,3] 의 array 중 2개의 수로 나타 낼 수 있는 경우의 수를 모두 구하시오 .
 *
 */
public class SunYul {

    public static void solution(int [] arr , int number) {

        List<List<Integer>> ret = new ArrayList<>();
        int [] checkArr = new int[number];
        Set<Integer> set = new HashSet<>();
        dfs(arr , ret , checkArr,  0 , number );

        for (int i = 0; i < ret.size(); i++) {
            List<Integer> integers = ret.get(i);
            for (Integer num : integers) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }

    public static void dfs(int [] arr , List<List<Integer>> ret , int [] checkArr,  int level , int number) {

        // 구하려고 하는 숫자의 개수가 다가왔으면  재귀를 탈출
        if(level == number) {
            List<Integer> list = new ArrayList<>();

            // check 하기 위해 경우의 수 값을 담아놨던 배열의 값을 result 객체에 담는다.
            for (int i = 0; i < checkArr.length; i++) {
                if(checkArr[i] != 0) {
                    list.add(checkArr[i]);
                }
            }
            ret.add(list);
            // 재귀가 빠져나가기 때문에 마지막 경우의 수 array index 데이터를 0으로 초기화 한다.
            checkArr[checkArr.length-1] = 0;
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            checkArr[level] = arr[i];
            dfs(arr , ret , checkArr , level + 1 , number  );
        }
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3};
        int number = 3;
        SunYul.solution(arr , number);

    }
}
