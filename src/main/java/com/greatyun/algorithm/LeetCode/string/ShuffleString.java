package com.greatyun.algorithm.LeetCode.string;

public class ShuffleString {
    public String restoreString(String s, int[] indices) {
        char[] ret = new char[s.length()];
        char[] chars = s.toCharArray();
        for (int i = 0; i < indices.length; i++) {
            int index = indices[i];
            ret[index] = chars[i];
        }
        return String.valueOf(ret);
    }


    public static void main(String[] args) {
        ShuffleString obj = new ShuffleString();
        String s = "codeleet";
        int [] arr = {4,5,6,7,0,2,1,3};
        System.out.println(obj.restoreString(s , arr));
    }
}
