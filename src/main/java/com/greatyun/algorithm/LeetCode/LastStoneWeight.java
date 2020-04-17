package com.greatyun.algorithm.LeetCode;

import java.util.Arrays;
import java.util.List;

public class LastStoneWeight {
    /*
    We have a collection of stones, each stone has a positive integer weight.

    Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:

    If x == y, both stones are totally destroyed;
    If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
    At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)

    Example 1:

    Input: [2,7,4,1,8,1]
    Output: 1
    Explanation:
    We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
    we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
    we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
    we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.

    Note:

            1 <= stones.length <= 30
            1 <= stones[i] <= 1000
    */

    public int lastStoneWeight(int[] stones) {
        if(stones.length == 0) return 0;
        if(stones.length == 1) return stones[0];

        Arrays.sort(stones);
        // 제일 큰 수
        int num1 = stones[stones.length-1];
        // 두번째로 큰 수
        int num2 = stones[stones.length-2];

        if(num1 == -1 && num2 == -1) {
            return 0;
        }
        if(num2 == -1) {
            return num1;
        }

        if(num1 != num2) {
            stones[stones.length-2] = -1;
            stones[stones.length-1] = num1 - num2;
        } else {
            stones[stones.length-1] = -1;
            stones[stones.length-2] = -1;
        }
        return lastStoneWeight(stones);
    }

    public static void main(String [] args) {
        LastStoneWeight obj = new LastStoneWeight();
        int [] arr = {1,1,1};
        int result = obj.lastStoneWeight(arr);
        System.out.println("result : " + result);
    }

}
