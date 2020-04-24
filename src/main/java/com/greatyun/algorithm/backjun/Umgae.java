package com.greatyun.algorithm.backjun;

import java.util.HashMap;

public class Umgae {


    public String solution(char [] chars) {
        String ascending = "ascending";
        String descending = "descending";
        String mixed = "mixed";

        HashMap<Character , Integer> map = new HashMap<>();
        map.put('c' , 1);
        map.put('d' , 2);
        map.put('e' , 3);
        map.put('f' , 4);
        map.put('g' , 5);
        map.put('a' , 6);
        map.put('b' , 7);
        map.put('C' , 8);

        int tempInt = 0;
        int prev = 0;
        boolean isAscending = false;
        boolean isMixed = false;
        boolean isDesc = false;

        for (int i = 0; i < chars.length; i++) {
            Integer integer = map.get(chars[i]);

            if(i == 0) {
                prev = integer;
            } else {
                if(integer - prev == 1) {
                    isAscending = true;
                } else if(integer - prev == -1) {
                    isDesc = true;
                } else {
                    isMixed = true;
                }
                prev = integer;
            }

        }
        System.out.println(isAscending + " , " + isDesc + " , " + isMixed);

        if(isMixed) {
            return "mixed";
        } else if(isAscending) {
            return "ascending";
        } else {
            return "descending";
        }
    }

    public int sum(int [] arr , int index) {
        if(index >= arr.length-1) return arr[index];
        return arr[index] + sum(arr , index+1);
    }

    public static void main(String[] args) {
        Umgae obj = new Umgae();
//        char[] chars = {'c' , 'd' , 'e' , 'f' , 'g' , 'a' , 'b' , 'C'};
//        char[] chars = {'C' , 'b' , 'a' , 'g' , 'f' , 'e' , 'd' , 'c'};
        char[] chars = {'C' , 'b' , 'a' , 'g' , 'e' , 'f' , 'd' , 'c'};
        System.out.println(obj.solution(chars));

        int [] arr = {1,2,3,4};
        System.out.println(obj.sum(arr , 0));
    }
}
