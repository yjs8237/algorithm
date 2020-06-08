package com.greatyun.algorithm.dinamic;

import java.util.*;

public class LetterCasePermutation {

    public void dfs(String parent , String target) {


    }

    public List<String> letterCasePermutation(String S) {

        List<String> ret = new ArrayList<>();

        Map<String , Integer> map = new HashMap<>();
        map.put(S ,0);
        ret.add(S);

        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];

            for (int j = 0; j < chars.length; j++) {
                
            }



            if(!Character.isDigit(temp)) {
                String first = S.substring(0 , i);
                String mid = String.valueOf(temp);
                String last = S.substring(i+1);
                String target = first + mid.toLowerCase() + last;
                if(!map.containsKey(target)) {
                    ret.add(target);
                }
                target = first + mid.toUpperCase() + last;
                if(!map.containsKey(target)) {
                    ret.add(target);
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        LetterCasePermutation obj = new LetterCasePermutation();
        List<String> a1b2 = obj.letterCasePermutation("a1b2");
        for (String str :a1b2) {
            System.out.print(str + " ");
        }
    }
}
