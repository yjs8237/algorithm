package com.greatyun.algorithm.array;

import java.util.ArrayList;
import java.util.List;

public class KidsWiththeGreatestNumberCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        List<Boolean> ret = new ArrayList<>();

        if(candies.length == 0) return ret;
        if(candies.length == 1) {
            ret.add(true);
            return ret;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < candies.length; i++) {
            if(max < candies[i]) {
                max = candies[i];
            }
        }
        for (int i = 0; i < candies.length; i++) {
            if(max <= candies[i] + extraCandies) {
                ret.add(true);
            } else {
                ret.add(false);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        KidsWiththeGreatestNumberCandies obj = new KidsWiththeGreatestNumberCandies();
        int [] arr = {4,2,1,1,2};
        int candy = 2;
        List<Boolean> booleans = obj.kidsWithCandies(arr, candy);
        for (int i = 0; i < booleans.size(); i++) {
            Boolean aBoolean = booleans.get(i);
            System.out.print(" " + aBoolean);
        }

        String ipaddr= "10.10.10.10";
        String[] split = ipaddr.split(".");

        System.out.println(ipaddr.replaceAll("\\." , "[.]"));
    }
}
