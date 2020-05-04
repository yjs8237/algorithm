package com.greatyun.algorithm.LeetCode.array;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> prev_list = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {

            List<Integer> list = new ArrayList<>();

            for (int j = 0; j < i; j++) {
                int num = 1;

                if(j == 0 || j == i-1) {
                    list.add(num);
                    System.out.print(" " + num);
                }  else {
                    list.add(prev_list.get(j-1) + prev_list.get(j));
//                    System.out.print(" size [" + prev_list.size() + "] j [" + j + " ]");
//                    System.out.println(prev_list.get(j-1) + " , " + prev_list.get(j));
//                    list.add(prev_list.get(j-1) + prev_list.get(j));
                }

            }
//            System.out.println();
            prev_list = list;
            ret.add(list);
        }

//        checkList(ret);

        return ret;
    }

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> prev_list = new ArrayList<>();

        for (int i = 1; i <= 33+1; i++) {

            List<Integer> list = new ArrayList<>();

            for (int j = 0; j < i; j++) {
                int num = 1;

                if(j == 0 || j == i-1) {
                    list.add(num);
                    System.out.print(" " + num);
                }  else {
                    list.add(prev_list.get(j-1) + prev_list.get(j));
//                    System.out.print(" size [" + prev_list.size() + "] j [" + j + " ]");
//                    System.out.println(prev_list.get(j-1) + " , " + prev_list.get(j));
//                    list.add(prev_list.get(j-1) + prev_list.get(j));
                }
            }
//            System.out.println();
            prev_list = list;
            ret.add(list);
        }
        return ret.get(rowIndex);
    }

    public void checkList(List<List<Integer>> ret ) {
        for (int i = 0; i < ret.size(); i++) {
            List<Integer> integers = ret.get(i);
            for (int j = 0; j < integers.size(); j++) {
                System.out.print(" " +integers.get(j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        PascalsTriangle obj = new PascalsTriangle();
//        System.out.println(obj.generate(5));
        System.out.println(obj.getRow(33));

    }
}
