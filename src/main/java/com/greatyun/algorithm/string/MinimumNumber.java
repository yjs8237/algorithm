package com.greatyun.algorithm.string;

import java.util.HashMap;
import java.util.Iterator;

public class MinimumNumber {

    public int minSteps(String s , String t) {

        char[] s_chars = s.toCharArray();
        char[] t_chars = t.toCharArray();

        HashMap<Character , Integer> s_map = new HashMap<>();
        HashMap<Character , Integer> t_map = new HashMap<>();

        int index = 0;
        while(s_chars.length > index || t_chars.length > index) {

            if(s_chars.length > index) {
                char s_char = s_chars[index];
                if(s_map.containsKey(s_char)) {
                    Integer count = s_map.get(s_char);
                    count++;
                    s_map.put(s_char , count);
                } else {
                    s_map.put(s_char , 1);
                }
            }

            if(t_chars.length > index) {
                char t_char = t_chars[index];
                if(t_map.containsKey(t_char)) {
                    Integer count = t_map.get(t_char);
                    count++;
                    t_map.put(t_char , count);
                } else {
                    t_map.put(t_char , 1);
                }
            }
            index++;
        }

        int ret = 0;
        Iterator iterator = s_map.keySet().iterator();
        while(iterator.hasNext()) {
            Object next = iterator.next();
            Integer s_count = s_map.get(next);
            if(t_map.containsKey(next)) {
                Integer t_count = t_map.get(next);
                if(s_count > t_count) {
                    ret++;
                }
            } else {
                ret++;
            }
        }

//        System.out.println(s_map.size());
//        System.out.println(t_map.size());
        return ret;
    }

    public static void main(String[] args) {
        MinimumNumber obj = new MinimumNumber();
//        "gctcxyuluxjuxnsvmomavutrrfb"
//        "qijrjrhqqjxjtprybrzpyfyqtzf"
        String s = "gctcxyuluxjuxnsvmomavutrrfb";
        String t = "qijrjrhqqjxjtprybrzpyfyqtzf";
        System.out.println(obj.minSteps(s , t));

    }
}
