package com.greatyun.algorithm.LeetCode;

import java.util.*;

/**
 * 448. Find All Numbers Disappeared in an Array
 * Easy
 *
 * 2848
 *
 * 245
 *
 * Add to List
 *
 * Share
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 *
 * Example:
 *
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [5,6]
 */
public class FindAllNumbers {

    public static List<Integer> sol (int [] nums) {

        List<Integer> ret = new ArrayList<>();
//        Arrays.sort(nums);
        HashMap<Integer , Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i+1 , 1);
        }
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.remove(nums[i]);
            }
        }

        Iterator iterator = map.keySet().iterator();
        while(iterator.hasNext()) {
            Integer key = (Integer) iterator.next();
            ret.add(key);
        }
        return ret;
    }

    public static void main(String[] args) {
//        int [] nums = {4,3,2,7,8,2,3,1};
        int [] nums = {1,1};
        List<Integer> sol = FindAllNumbers.sol(nums);
        sol.stream().forEach(x -> System.out.println(x));
    }
}
