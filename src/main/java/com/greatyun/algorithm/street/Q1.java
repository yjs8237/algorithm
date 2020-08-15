package com.greatyun.algorithm.street;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q1 {






    public int s2(int [] A , int [] B) {
        int n = A.length;
        int m = B.length;
        Arrays.sort(A);
        Arrays.sort(B);
        if(m == 0) return -1;
        int i = 0;
        for (int k = 0; k < n; k++) {
            if (i < m - 1 && B[i] < A[k])
                i += 1;
            if (A[k] == B[i])
                return A[k];
        }
        return -1;
    }

    public int solution(String S) {
        if(S == null || S.isEmpty()) return -1;
        int ret = 0; int lowerCnt = 0;

        // 대문자와 소문자 pair 여부를 체크 하기 위한 set 자료구조
        Set<Character> set = new HashSet<>();
        char[] chars = S.toCharArray();

        // 문자열의 대문자만 set 에 우선 담아놓기 위해 문자열 정렬 후 set 에 담아놓자..
        Arrays.sort(chars);
        for (int i = 0; i < chars.length; i++) {
            if(Character.isUpperCase(chars[i])) {
                set.add(chars[i]);
            } else {
                // 소문자라면.. 그냥 루프 나오고
                break;
            }
        }

        // 결과 문자열을 담기위한 builder
        StringBuilder builder = new StringBuilder();

        chars = S.toCharArray();

        // 체크를 시작하는 시점을 알기 위한 flag
        boolean isCheckStart = false;

        /**
         * 순차적으로 문자열을 탐색하면서
         * 대문자가 나올경우 set 자료구조 참조
         * 결과 문자열은 대문자와 소문자의 pair 가 되어야 하고, 반드시 연속된 하나의 문자열로 구성이 되어야 하기 때문에
         * flag 변수를 사용해서 순차적으로 탐색하는 char 가 연속된 pair 문자열이 되가는지 체크한다.
         */
        for (int i = 0; i < chars.length; i++) {

            // 대문자라면 체크 시작 flag true
            // 대문자면 일단 결과 문자열에 해당 된다..
            if(Character.isUpperCase(chars[i])){
                isCheckStart = true;
                builder.append(String.valueOf(chars[i]));
            } else {

                // 소문자가 나올 경우
                boolean isExistsValue = set.contains(Character.toUpperCase(chars[i]));

                // 연속된 문자열 흐름인지 체크 && 해당 소문자가 대문자와 pair 인지 체크
                if(isCheckStart && isExistsValue) {
                    builder.append(String.valueOf(chars[i]));
                    lowerCnt++;
                } else if(isCheckStart && !isExistsValue) {
                    // 아니라면 루프를 빠져나가자.. 연속된 문자(대소문자 pair) 가 아닌것은 더이상 볼 필요가 없다..
                    break;
                }
            }
        }

        // 결과 문자열의 길이를 받고
        ret = builder.length();

        System.out.println(builder.toString() + " " + lowerCnt);

        if(lowerCnt == 0) {
            // 결과 문자열의 소문자가 하나도 포함되어 있지 않으면
            // 파라미터 문자열은 다 대문자만 구성되어 있는것.. 이건 문제 정답이 아니다
            return -1;
        } else {
            // 파라미터 문자열의 처음 시작이 대문자이고 pair 문자열이 아닌 경우 builder의 길이는 1이다..
            // builder 의 길이가 1인 경우는 위의 케이스 뿐이 없으므로.. 이건 대소문자 pair 문자열이 아니기에 -1 리턴
            return ret < 2 ? -1 : ret;
        }
    }

    public static void main(String[] args) {
        Q1 q1 = new Q1();
//        String str = "AcZCbaBz";
        String str = "AAAAAbAAAAA";
        System.out.println(q1.solution(str));

        int [] a = {};
        int [] b = {2,3,4};
//        System.out.println(q1.s2(a , b));

    }
}
