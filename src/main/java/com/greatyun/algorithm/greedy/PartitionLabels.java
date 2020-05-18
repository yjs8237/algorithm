package com.greatyun.algorithm.greedy;

import java.util.*;

public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {

        char[] chars = S.toCharArray();
        List<Integer> ret = new ArrayList<>();
        Arrays.sort(chars);

        Map<Character , Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < chars.length; i++) {
            set.add(chars[i]);
            System.out.print(" " + chars[i]);
        }



        return ret;
    }
    public static void main(String[] args) {
        PartitionLabels obj = new PartitionLabels();

        String S = "ababcbacadefegdehijhklij";
        obj.partitionLabels(S);
    }
}
