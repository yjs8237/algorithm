package com.greatyun.algorithm.array;

import java.util.*;

public class SorttheMatrix {
    public int[][] diagonalSort(int[][] mat) {
        int [][] ret = new int[mat.length][mat[0].length];

        Map<String , Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < mat.length; i++) {

            for (int j = 0; j < mat[0].length; j++) {

                list = new ArrayList<>();

                int row_index = i;
                int col_index = j;
                int list_index = 0;

                if(map.containsKey(String.valueOf(row_index) + String.valueOf(col_index))) {
                    continue;
                }
                while(row_index < mat.length && col_index < mat[0].length) {
                    int target = mat[row_index][col_index];
//                    System.out.println("target : " + target);
                    list.add(target);
                    row_index++;
                    col_index++;
                }
                Collections.sort(list);

                row_index = i;
                col_index = j;

                while(row_index < mat.length && col_index < mat[0].length) {
                    ret[row_index][col_index] = list.get(list_index);

                    map.put(String.valueOf(row_index) + String.valueOf(col_index) , 0);

                    list_index++;
                    row_index++;
                    col_index++;
                }
//                System.out.println("next");
            }
        }

        for (int i = 0; i < ret.length; i++) {
            for (int j = 0; j < ret[0].length; j++) {
                System.out.print(ret[i][j] +" ");
            }
            System.out.println();
        }

        return ret;
    }

    public void test(int [] arr) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        if(arr.length == 0) {
            return;
        }
        for(int i=0; i<arr.length; i++) {
            long sum = 0;
            for(int j=0; j<arr.length; j++) {
                if(i != j) {
                    sum += arr[j];
                }
            }
            //System.out.println("sum -> " + sum);
            queue.offer(sum);
        }

        List<Long> list = new ArrayList<>();
        while(!queue.isEmpty()) {
            list.add(queue.poll());
        }
        System.out.println(list.get(0)  + " " + list.get(list.size()-1));
    }

    static void plusMinus(int[] arr) {
        int positive = 0;
        int negative = 0;
        int zero = 0;

        for(int i=0; i<arr.length; i++) {
            if(arr[i] == 0) {
                zero++;
            } else if(arr[i] < 0) {
                negative++;
            } else {
                positive++;
            }
        }

        Double ret = (Double.parseDouble(String.valueOf(positive)) / arr.length);
        System.out.println("" + ret);
        ret = (Double.parseDouble(String.valueOf(negative)) / arr.length);
        System.out.println(""+ret);
        ret = (Double.parseDouble(String.valueOf(zero)) / arr.length);
        System.out.println(""+ret);

    }

    static void staircase(int n) {
        int index = 1;
        for(int i=0; i<n; i++) {

            for(int j=0; j<n-(i+1); j++) {
                System.out.print(" ");
            }
            for(int j=0; j<i+1; j++) {
                System.out.print("#");
            }
            System.out.println();
            index++;
        }

    }

    public static void main(String[] args) {
        SorttheMatrix obj = new SorttheMatrix();
        int [][] mat = { {4,3,2,1} , {5,1,2,4} , {3,6,4,2} , {7,7,7,7}};

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        SorttheMatrix.staircase(6);
//        obj.diagonalSort(mat);
//        obj.test(new int[]{156873294 ,719583602, 581240736, 605827319, 895647130});
    }
}
