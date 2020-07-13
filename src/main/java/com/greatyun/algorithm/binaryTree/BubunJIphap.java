package com.greatyun.algorithm.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class BubunJIphap {

    /**
     * Array 가 주어지면 해당 배열에 값에 대하여 부분 부분집합의 모든 경우의수를 리턴하시오
     *
     * 예) [1,2,3]
     * 리턴 [[1,2,3] , [1,2] , [1,3] , [1] , [2,3] , [2] , [3]]
     */

    public static void solution (int [] arr) {
        // 상태트리를 이용하여 부분집합 포함여부를 기록할 임시 array 변수
        int [] tempArr = new int[arr.length+1];
        List<List<Integer>> ret = new ArrayList<>();
        dfs(arr , tempArr , 0 , ret);
        for (int i = 0; i < ret.size(); i++) {
            List<Integer> list = ret.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void dfs(int [] arr , int [] tempArr , int index ,  List<List<Integer>> ret) {

        if(index == arr.length) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < tempArr.length; i++) {
                // 부분집합의 포함시키는 의미를 가진 1인 경우만 해당 인덱스로 타겟 array 의 값을 가져온다.
                if(tempArr[i] == 1) {
                    list.add(arr[i]);
//                    System.out.print(arr[i] + " ");
                }
            }
            ret.add(list);
            return;
        }

        // 부분집합에 포함시킨다는 의미로 1 삽입
        tempArr[index] = 1;
        dfs(arr , tempArr , index + 1 , ret);

        // 부분집합에 미포함시킨다는 의미로 0 삽입
        tempArr[index] = 0;
        dfs(arr , tempArr , index + 1 , ret);
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3};
        BubunJIphap.solution(arr);
    }
}
