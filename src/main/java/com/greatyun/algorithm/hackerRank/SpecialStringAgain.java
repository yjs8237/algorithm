package com.greatyun.algorithm.hackerRank;

public class SpecialStringAgain {

    static long substrCount(int n, String s) {

        char[] chars = s.toCharArray();

        int result = 0;
        boolean isSame = true;
        char temp = ' ';
        for (int i = 0; i < chars.length; i++) {
            if(i == 0) {
                temp = chars[i];
            } else {
                if(temp != chars[i]) {
                    isSame = false;
                }
            }
             result += checkCount(s , i);
        }
        if(isSame) {
            result++;
        }
        return result;
    }

    private static int checkCount(String str, int number) {
        int result = 0;

        for (int i = 0; i < str.length(); i++) {


            if(i + number <= str.length()) {
                String tempStr = str.substring(i , i+number);
                //System.out.println("origin : " + str + " target : " + tempStr + " i : " + i + "  number : " + number);

                if(tempStr.length() == 1) {
                    System.out.println("1");
                    result ++;
                } else if(tempStr.length() > 1 && tempStr.length() % 2 == 0) {
                    // 짝수개로 substring 된 경우
                    char[] chars = tempStr.toCharArray();
                    char tempChar = chars[0];
                    boolean isSame = true;
                    for (int j = 1; j < chars.length; j++) {
                        if(tempChar != chars[j]) {
                            isSame = false;
                            break;
                        }
                    }
                    if(isSame) {
                        System.out.println("2 -> " + tempStr);
                        result++;
                    }
                } else if(tempStr.length() > 1 && tempStr.length() <=3 && tempStr.length() % 2 != 0) {
                    // 홀수개로 substring 된 경우
                    char[] chars = tempStr.toCharArray();
                    if(chars[0] == chars[chars.length - 1]) {
                        System.out.println("3 -> " + tempStr);
                        result++;
                    }
                }
//                System.out.println("i : " + i + " , number : " + number + " result -> " + tempStr);
            } else {
                break;
            }
        }
        return result;
    }

    public static void main (String [] args) {
        String str = "asasd";
        int len = str.length();
        System.out.println(SpecialStringAgain.substrCount(len , str));
    }

}
