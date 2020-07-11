package com.greatyun.algorithm.hackerRank;

import java.util.ArrayList;
import java.util.List;

public class CompareTriplets {

    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> ret = new ArrayList<>();
        int a_final = 0;
        int b_final = 0;
        for (int i = 0; i < a.size(); i++) {
            int a_score = a.get(i);
            int b_score = b.get(i);

            if(a_score > b_score) {
                a_final++;
            } else if (a_score < b_score) {
                b_final++;
            }

        }
        ret.add(a_final);
        ret.add(b_final);
        return ret;
    }

    public static void main(String[] args) {

    }

}
