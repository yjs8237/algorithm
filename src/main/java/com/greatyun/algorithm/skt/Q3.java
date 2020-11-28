package com.greatyun.algorithm.skt;

import java.util.HashSet;
import java.util.Set;

public class Q3 {
    public int solution(String S) {
        // write your code in Java SE 8
        int result = 0;

        if (S == null || S.length() == 0) return result;

        // 중복 검사를 피하기 위한 HashSet
        Set<String> set = new HashSet<>();

        for (int i = 0; i < S.length(); i++) {
            // loop 를 통해 해당 index 값 을 제외한 앞부분 , 뒷부분 String 을 분리한다.
            String beforeStr = S.substring(0 , i);
            String afterStr = S.substring(i+1);

            // 해당 index 의 값을 0 ~ 9 까지 대입 해보면서 3으로 나눠지는 수인지 체크한다.
            for (int j = 0; j < 10; j++) {
                StringBuilder builder = new StringBuilder();
                builder.append(beforeStr).append(j).append(afterStr);
                // 이미 3으로 나눠지는 수인지 체크 했다면 pass
                if(set.contains(builder.toString())) continue;

                // 3으로 나눠지는 수라면 결과 증가
                if(isDivisible(builder.toString())){
                    result++;
                }
                // 중복 검사를 피하기 위해 Set add
                set.add(builder.toString());
            }
        }

        return result;
    }

    private boolean isDivisible(String str) {
        return Integer.parseInt(str) % 3 == 0 ?  true :  false;
    }

    public static void main(String[] args) {
        Q3 q3 = new Q3();
        String str = "022";
        System.out.println(q3.solution(str));
    }
}
