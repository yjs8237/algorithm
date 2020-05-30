package com.greatyun.algorithm.hackerRank;

public class VeryBigSum {

    static int alternate(String s) {
        int ret = 0;

        for(int i=0; i<s.length(); i++) {

            String temp = s.replaceAll(s.substring(i , i+1) , "");
            System.out.println("temp : " + temp);
            String prev = "";
            boolean isRight = false;
            for(int j=0; j<temp.length(); j++) {
                String substr = temp.substring(j , j+1);
                if(prev.equals(substr)) {
                    isRight = false;
                    break;
                } else {
                    isRight = true;
                    prev = substr;
                }
            }
            if(isRight) {
                System.out.println("isRight : " + temp);
                ret = Math.max(ret , temp.length());
            }

        }

        return ret;
    }
    public static void main(String[] args) {
        VeryBigSum obj = new VeryBigSum();
        VeryBigSum.alternate("asdcbsdcagfsdbgdfanfghbsfdab");
    }
}
