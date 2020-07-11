package com.greatyun.algorithm.hackerRank;

import java.util.*;

public class Birthday {
    static int birthdayCakeCandles(int[] ar) {
        int len = ar.length;
        int ret = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int maxValue = Integer.MIN_VALUE;
        for(int i=0; i<ar.length; i++) {
            if(len >= ar[i]) {
                maxValue = Math.max(maxValue , ar[i]);
                if(maxValue == ar[i]) {
                    Integer count = 1;
                    if(map.containsKey(maxValue)) {
                        count = map.get(maxValue);
                        count++;
                    }
                    map.put(maxValue , count);
                }
            }
        }

        Iterator iter = map.keySet().iterator();
        while(iter.hasNext()) {
            Integer key = (Integer)iter.next();
            System.out.println("key -> " + key + " , value -> " + map.get(key));
            ret = Math.max(map.get(key) , ret);
        }
        return ret;
    }
    public static void main(String[] args) {
        int [] ar = {3,2,1,3};
        System.out.println(Birthday.birthdayCakeCandles(ar));

    }
}
