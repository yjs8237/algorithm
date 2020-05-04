package com.greatyun.algorithm.LeetCode.string;

public class RansomNote {
    /**
     *
     * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
     *
     * Each letter in the magazine string can only be used once in your ransom note.
     *
     * Note:
     * You may assume that both strings contain only lowercase letters.
     *
     * canConstruct("a", "b") -> false
     * canConstruct("aa", "ab") -> false
     * canConstruct("aa", "aab") -> true
     *
     */
    public boolean canConstruct(String ransomNote, String magazine) {

        char[] ransom_arr = ransomNote.toCharArray();
        if(ransom_arr.length == 0) return true;
        StringBuilder builder = new StringBuilder();
        builder.append(magazine);

        for (int i = 0; i < ransom_arr.length; i++) {
            char c = ransom_arr[i];
            int indexOf = builder.toString().indexOf(String.valueOf(c));
            if(indexOf > -1) {
                builder.deleteCharAt(indexOf);
                System.out.println("builder -> " + builder.toString());
            } else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        RansomNote obj = new RansomNote();
        String a = "abc";
        String b = "qazbzc";

        System.out.println(obj.canConstruct(a , b));
    }
}
