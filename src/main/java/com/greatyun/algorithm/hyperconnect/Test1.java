package com.greatyun.algorithm.hyperconnect;

import java.util.*;

public class Test1 {

    public boolean solution(String brackets) {

        if(brackets.length() % 2 != 0) {
            return false;
        }
        if(brackets.length() == 0) {
            return false;
        }

        HashMap<Character , Integer> map = new HashMap<>();
        char[] chars = brackets.toCharArray();

        for(int i=0; i<chars.length; i++) {

            if(chars[i] == '(') {
                if(map.containsKey(')')) {
                    Integer integer = map.get(')');
                    integer++;
                    map.put(')' , integer);
                } else {
                    map.put(')' , 1);
                }

            } else if(chars[i] == '{') {
                if(map.containsKey('}')) {
                    Integer integer = map.get('}');
                    integer++;
                    map.put('}' , integer);
                } else {
                    map.put('}' , 1);
                }

            } else if(chars[i] == '[') {
                if(map.containsKey(']')) {
                    Integer integer = map.get(']');
                    integer++;
                    map.put(']' , integer);
                } else {
                    map.put(']' , 1);
                }

            } else {
                if(map.containsKey(chars[i])) {
                    Integer integer = map.remove(chars[i]);
                    integer--;
                    if(integer > 0) {
                        map.put(chars[i] , integer);
                    }
                } else {
                    return false;
                }

//                throw new UnsupportedOperationException("Unsupported Operation");
            }
//            end--;
        }

        //System.out.println(map.size());
        return map.size() == 0 ? true : false;

    }

    public boolean solution1(String brackets) {
        if(brackets.length() % 2 != 0) {
            return false;
        }
        if(brackets.length() == 0) {
            return false;
        }
        int first = 0;
        int end = brackets.length()-1;

        char[] chars = brackets.toCharArray();

        for(int i=0; i<chars.length/2; i++) {

            if(chars[i] == '(') {

                if(chars[end-i] != ')') {
                    return false;
                }

            } else if(chars[i] == '{') {

                if(chars[end-i] != '}') {
                    return false;
                }

            } else if(chars[i] == '[') {

                if(chars[end-i] != ']') {
                    return false;
                }

            } else {
                throw new UnsupportedOperationException("Unsupported Operation");
            }
//            end--;
        }
        return true;


    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        Hashtable<Integer , LinkedList<Integer>> tabla = new Hashtable<Integer , LinkedList<Integer>>();
        tabla.put(1 , new LinkedList<>());

        System.out.println(test1.solution(""));
    }
}
