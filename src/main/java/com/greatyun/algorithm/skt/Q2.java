package com.greatyun.algorithm.skt;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Q2 {
    public int solution(int[] A) {
        // write your code in Java SE 8

        /**
         * 1. Map 에 Array element 들의 개수를 파악하고
         * 2. Map 의 원소를 서치하면서 해당 원소로 element 를 통일 시키려면 발생하는 비용을 계산
         * 3. 그 비용의 min 값을 구해 리턴
         */

        // 최소값 결과 변수. 최초 Integer Max Value Initial Set
        int result = Integer.MAX_VALUE;

        // Map 기준으로 Array 데이터들의 개수를 파악해보자.
        Map<Integer , Integer> map = new HashMap<Integer , Integer>();
        for (int i = 0; i < A.length; i++) {
            Integer count = 1;
            if(map.containsKey(A[i])) {
                count = map.get(A[i]);
                count++;
            }
            map.put(A[i] , count);
        }

        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Integer key = (Integer) iterator.next();

            // 최소값을 찾기 위한 임시 변수
            int tempResult = 0;
            Iterator subIterator = map.keySet().iterator();
            while(subIterator.hasNext()) {
                Integer subKey = (Integer) subIterator.next();
                // Sub Iterator 에서 부모 key 값과 동일하면 Pass
                if(key == subKey) continue;
                Integer targetCount = map.get(subKey);
                // 각 element 의 개수와 element 원소 값 기준으로 계산된 increse 또는 decrese 되는 카운트를 구하자.
                tempResult += Math.abs(key - subKey) * targetCount;
            }
            // 최소값을 계속 구한다.
            result = Math.min(result , tempResult);
        }

        return result;
    }
    public static void main(String[] args) {

        Q2 q2 = new Q2();
//        int [] A = {3,2,1,1,2,3,1};
        int [] A = {4,1,4,1};

        int test = Math.abs(1 - 2) * 2;
        //System.out.println(test);
        System.out.println(q2.solution(A));

    }
}
