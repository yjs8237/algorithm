package com.greatyun.algorithm.dinamic;

import java.util.HashMap;

/**
 * 네트워크 선 자르기(Top-Down : 재귀, 메모이제이션)
 * 현수는 네트워크 선을 1m, 2m의 길이를 갖는 선으로 자르려고 합니다. 예를 들어 4m의 네트워크 선이 주어진다면
 * 1) 1m+1m+1m+1m 2) 2m+1m+1m 3) 1m+2m+1m 4) 1m+1m+2m 5) 2m+2m
 * 의 5가지 방법을 생각할 수 있습니다. (2)와 (3)과 (4)의 경우 왼쪽을 기준으로 자르는 위치가 다르면 다른 경우로 생각한다. 그렇다면 네트워크 선의 길이가 Nm라면 몇 가지의 자르는 방법을 생각할  수 있나요?
 * ▣ 입력설명 첫째 줄은 네트워크 선의 총 길이인 자연수 N(3≤N≤45)이 주어집니다.
 * ▣ 출력설명 첫 번째 줄에 부분증가수열의 최대 길이를 출력한다.
 * ▣ 입력예제 1                                   7
 * ▣ 출력예제 1 21
 *
 * Dynamic programming Top down TopDown top-down
 */
public class NetworkCableTopDown {

    public int solution (int k) {
        int [] memo = new int[k+1];
        return dfs(memo , k);
    }

    public int dfs(int [] memo , int k) {
        if(memo[k] != 0 ) {
            // 메모이제이션 되어 있다면 더이상 재귀로 가지를 뻗지 않고 기억해둔 데이터를 리턴한다.
            return memo[k];
        } else if(k == 1 || k == 2) {
            // 자르려는 길이가 1이거나 2일 경우 그 값을 그대로 리턴한다.
            return k;
        } else {
            // 인자값을 받은 길이를 자르는 방법은 dfs 6 자르는방법의 개수와 dfs 5 자르는 방법의 개수를 합한것이다.
            memo[k] = dfs(memo , k-1) + dfs(memo , k-2);
            return memo[k];
        }
    }

    public static void main(String[] args) {
        NetworkCableTopDown obj = new NetworkCableTopDown();
        System.out.println(obj.solution(7));


    }
}
