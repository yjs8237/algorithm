package com.greatyun.algorithm.autoever;

import java.util.HashSet;

/**
 * 주어진 메일 주소 중, 규격에 맞는 주소는 몇 개인지 구하려 합니다. 메일 규격은 다음과 같습니다.
 *
 * 규격에 맞는 메일은 이름@도메인이름.탑레벨도메인 형식입니다.
 * 이름은 영문 소문자와 .로만 구성되며 길이가 1 이상이어야 합니다.
 * 도메인이름은 영문 소문자로만 구성되며 길이가 1 이상이어야 합니다.
 * 탑레벨도메인은 com, net, org 중 하나입니다.
 * 메일 주소를 담은 배열 emails가 매개변수로 주어질 때 이 중 규격에 맞는 주소는 몇 개인지 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * emails의 길이는 1 이상 100,000 이하입니다.
 * emails의 원소는 길이가 1 이상 100 이하인 문자열입니다.
 * emails의 원소는 영문 소문자, ., @로 이루어진 문자열입니다.
 * 입출력 예
 * emails	result
 * ["d@co@m.com", "a@abc.com", "b@def.com", "c@ghi.net"]	3
 * ["abc.def@x.com", "abc", "abc@defx", "abc@defx.xyz"]	1
 * 입출력 예 설명
 * 입출력 예 #1
 *
 * d@co@m.com만 규격에 맞지 않고 나머지는 규격에 맞습니다.
 *
 * 입출력 예 #2
 *
 * abc.def@x.com만 규격에 맞습니다.
 */

public class Q4 {

    public int sol(String[] emails) {
        int answer = 0;

        for (String str : emails) {
            if(isRight(str)) {
                System.out.println("email true " + str);
                answer++;
            } else {
                System.out.println("email false " + str);
            }
        }
        return answer;
    }

    public boolean isRight(String email) {
        boolean ret = true;
        HashSet<String> set = new HashSet<>();

        if(email.startsWith("@") || email.startsWith(".")) return false;
        if(email.endsWith("@") || email.endsWith(".")) return false;

        for (int i = 0; i < email.length(); i++) {
            String innerStr = email.substring(i , i+1);
            if(innerStr.equals("@") && set.contains(innerStr)) {
                System.out.println("11 " + email);
                return false;
            } else if(innerStr.equals(".") && set.contains(innerStr)) {
//                System.out.println("2 " + email);
//                return false;
            } else {
                set.add(innerStr);
            }
        }

        String[] split = email.split("@");
        char[] chars = split[0].toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(Character.isUpperCase(chars[i]) || Character.isDigit(chars[i])) {
                System.out.println("3 " + email);
                return false;
            }
        }
        if(split.length < 2 ) {
            System.out.println("4 " + email);
            return false;
        }

//        System.out.println(split[1]);
        String[] domain = split[1].split("\\.");

        if(domain.length != 2) {
            System.out.println("5 " + email);
            return  false;
        }

        char[] domainArr = domain[0].toCharArray();
        for (int i = 0; i < domainArr.length; i++) {
            if(Character.isUpperCase(domainArr[i])) {
                System.out.println("6 " + email);
                return false;
            }
        }


        if(!domain[1].equals("com") && !domain[1].equals("net") && !domain[1].equals("org")) {
            System.out.println("7 " + email);
            return false;
        }

        return ret;
    }

    public static void main(String[] args) {

        Q4 obj = new Q4();
//        String[] arr = {"abc.def@x.com", "abc", "abc@defx", "abc@defx.xyz"};
        String[] arr = {"d@co@m.com", "a@abc.com", "b@def.com", "c@ghi.net"};
        int sol = obj.sol(arr);
        System.out.println("result -> " + sol);

//        String str = "a@@@";
//        int i = str.indexOf("@");
//        System.out.println("i - " + i);
//        i = str.indexOf("@" , i+1);
//        System.out.println("i1 - " + i);

    }
}
