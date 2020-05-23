package com.greatyun.algorithm.greedy;

import java.util.*;

public class Inflearn_1 {


    /**
     * 한 개의 회의실이 있는데 이를 사용하고자 하는 n개의 회의들에 대하여 회의실 사용표를 만들 려고 한다.
     * 각 회의에 대해 시작시간과 끝나는 시간이 주어져 있고,
     * 각 회의가 겹치지 않게 하 면서 회의실을 사용할 수 있는 최대수의 회의를 찾아라. 단, 회의는 한번 시작하면 중간에 중 단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
     * ▣ 입력설명 첫째 줄에 회의의 수 n(1<=n<=100,000)이 주어진다. 둘째 줄부터 n+1 줄까지 각 회의의 정 보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다.
     * ▣ 출력설명 첫째 줄에 최대 사용할 수 있는 회의 수를 출력하여라.
     * ▣ 입력예제 1
     * 5 1
     * 4 2
     * 3 3
     * 5 4
     * 6 5 7
     * ▣ 출력예제 1 3
     */


    static class Time {
        int start;
        int end;
        public Time(int start , int end) {
            this.start = start;
            this.end = end;
        }
    }
    public void solution (List<Time> list) {
        list.sort((a , b) -> a.start > b.start ? -1 : 1);
    }
    public void test(int [] arr , int heigth , int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a , b) -> a > b ? 1 : -1);
        Arrays.sort(arr);
        int max = arr[arr.length-1];
        int min = arr[0];

        for (int i = 0; i < k; i++) {
            arr[0] += 1;
            arr[arr.length-1] -= 1;
            Arrays.sort(arr);
        }
        System.out.println(arr[arr.length-1] - arr[0]);
    }





    public void test2(int N , int M , int [] arr) {
        Arrays.sort(arr);
        int cnt = 0;
        int index= arr.length-1;
        while(index >= 0) {
            if(index >= 1 && arr[index] + arr[index-1] <= M) {
                cnt++;
                index = index -2;
            } else if(arr[index] <= M) {
                cnt++;
                index = index - 1;
            }
        }
        System.out.println(cnt);
    }

    public void test3(int [] arr) {

        int start = 0;
        int end = arr.length-1;

        int target = 0;
        int index = 0;
        StringBuilder builder = new StringBuilder();
        while(start <= end) {

            // int [] arr = {2,4,5,1,3};
            int num1 = arr[start];
            int num2 = arr[end];
            int min = Math.min(num1 , num2);
            if(target < num1 && target < num2) {
                // 둘다크면 둘중에 작은 값을 넣자
                if(num1 < num2) {
                    builder.append("L");
                    start++;
                    target = num1;
                } else {
                    builder.append("R");
                    end--;
                    target = num2;
                }
            } else if(target < num1) {
                builder.append("L");
                start++;
                target = num1;
            } else if(target < num2) {
                builder.append("R");
                end--;
                target = num2;
            } else {
                break;
            }

        }
        System.out.println(builder.toString());
    }

    class Element {
        int index;
        int val;
        public Element(int index , int va) {
            this.index = index;
            this.val = va;
        }
    }

    public void reverse_suyul(int [] arr) {

        int [] ret = new int[arr.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = -1;
        }

        int len = arr.length;

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int index = 0;
            int count = 0;
            while(true) {
                if(ret[index] == -1 && count == num) {
                    ret[index] = i+1;
                    break;
                } else if(ret[index] == -1){
                    count++;
                }
                index++;
            }
        }
        for (int i = 0; i < ret.length; i++) {
            System.out.print(ret[i] + " ");
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Time> queue = new PriorityQueue<>((a , b) -> a.end > b.end ? 1 : -1);
        Time time1 = new Time(172, 67);
        Time time2 = new Time(183, 65);
        Time time3 = new Time(180, 70);
        Time time4 = new Time(170, 70);
        Time time5 = new Time(181, 60);
        List<Time> list = new ArrayList<>();
        list.add(time1); list.add(time2); list.add(time3); list.add(time4); list.add(time5);
        Inflearn_1 obj = new Inflearn_1();
        obj.solution(list);

        int [] arr = {2,3,1,1,0,0};
        int N = 5;
        int M = 140;
//        obj.test3(N , M , arr);
        obj.reverse_suyul(arr);
    }

}
