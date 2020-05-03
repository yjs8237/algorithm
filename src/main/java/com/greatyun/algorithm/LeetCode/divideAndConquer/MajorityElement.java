package com.greatyun.algorithm.LeetCode.divideAndConquer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        int ret = 0;

        int start  = 0;
        int end = nums.length-1;
        int mid = (start + end) / 2;

        HashMap<Integer , Integer> map = new HashMap<>();
        while(start <= end) {

        }

        int max_count = 0;
        Set keySet = map.keySet();
        Iterator iterator = keySet.iterator();
        while(iterator.hasNext()) {
            Integer key = (Integer) iterator.next();
            Integer count = map.get(key);
            if(max_count < count) {
                max_count = count;
                ret = key;
            }
        }

        return ret;
    }



    public static void main(String[] args) {
        MajorityElement obj = new MajorityElement();
        int [] arr = {3,2,3};
        int result = obj.majorityElement(arr);
        System.out.println(result);
    }
}
