package com.greatyun.algorithm.tries;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class CamelcaseMatching {

    public List<Boolean> camelMatch(String[] queries, String pattern) {

        List<Boolean> ret = new ArrayList<>();
        if(queries.length ==0 || pattern.length() == 0) return ret;

        List<String> pattern_list = divide(pattern);

        for (int i = 0; i < pattern_list.size(); i++) {
            System.out.println(pattern_list.get(i));
        }

        for (int i = 0; i < queries.length; i++) {
            String str = queries[i];
            List<String> innerList = divide(str);

            if(innerList.size() != pattern_list.size()) {
                ret.add(false);
            } else {
                int rightCnt = 0;
                int pattern_index = 0;
                for (int j = 0; j < innerList.size(); j++) {
                    String innerStr = innerList.get(j);
                    String patterStr = pattern_list.get(pattern_index);
                    if(checkContains(innerStr , patterStr)) {
                        rightCnt++;
                        pattern_index++;
                    }
                }
                if(rightCnt == innerList.size()) {
                    ret.add(true);
                } else {
                    ret.add(false);
                }
            }
        }

        return ret;
    }

    private boolean checkContains(String innerStr, String patterStr) {

        char[] innerChars = innerStr.toCharArray();
        char[] patternChars = patterStr.toCharArray();

        if(innerChars[0] != patternChars[0]) return false;
        int index = 0;

        HashSet<Integer> hashSet = new HashSet<>();
        Iterator iter = hashSet.iterator();

        for (int i = 0; i < innerChars.length; i++) {
            if(innerChars[i] == patternChars[index]) {
                index++;
            }
            if(index >= patternChars.length) {
                break;
            }
        }
        if(index >= patternChars.length) return true;
        else return false;
    }

    public List<String> divide (String pattern) {
        List<String> parrternList = new ArrayList<>();
        char[] chars = pattern.toCharArray();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if( c >= 65 && c <= 90 ) {
                // 대문자

                if(builder.length() != 0) {
                    parrternList.add(builder.toString());
                }
                builder = new StringBuilder();
                builder.append(String.valueOf(c));
            } else if(c >= 97 && c <= 122) {
                // 소문자
                if(builder.toString().length() > 0) {
                    builder.append(String.valueOf(c));
                }

            } else {

            }
        }
        if(builder.length() != 0) parrternList.add(builder.toString());
        return parrternList;
    }


    public static void main(String[] args) {
        CamelcaseMatching obj = new CamelcaseMatching();
//["CompetitiveProgramming","CounterPick","ControlPanel"]
//        "CooP"

//        ["aksvbjLiknuTzqon","ksvjLimflkpnTzqn","mmkasvjLiknTxzqn","ksvjLiurknTzzqbn","ksvsjLctikgnTzqn","knzsvzjLiknTszqn"]
//        "ksvjLiknTzqn"

        String [] arr = {"aksvbjLiknuTzqon","ksvjLimflkpnTzqn","mmkasvjLiknTxzqn","ksvjLiurknTzzqbn","ksvsjLctikgnTzqn","knzsvzjLiknTszqn"};
        String pattern = "ksvjLiknTzqn";

        List<Boolean> booleans = obj.camelMatch(arr, pattern);
        for (Boolean result : booleans) {
            System.out.print(" " + result);
        }
    }

}
