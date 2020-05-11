package com.greatyun.algorithm.string;

import java.util.HashMap;

public class UniqueMorse {

    HashMap<String , String > morseMap = new HashMap<>();
    public int uniqueMorseRepresentations(String[] words) {

        return 0;
    }

    public void setHash() {
        String [] arr = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        morseMap.put("a" , arr[0]);
        morseMap.put("b" , arr[1]);
        morseMap.put("c" , arr[2]);
        morseMap.put("d" , arr[3]);
        morseMap.put("e" , arr[4]);
        morseMap.put("f" , arr[5]);
        morseMap.put("g" , arr[6]);
        morseMap.put("h" , arr[7]);
        morseMap.put("i" , arr[8]);
        morseMap.put("j" , arr[9]);
        morseMap.put("k" , arr[10]);
        morseMap.put("l" , arr[11]);
        morseMap.put("m" , arr[12]);
        morseMap.put("n" , arr[13]);
        morseMap.put("o" , arr[14]);
        morseMap.put("p" , arr[15]);
        morseMap.put("q" , arr[16]);
        morseMap.put("r" , arr[0]);
        morseMap.put("s" , arr[0]);
        morseMap.put("t" , arr[0]);
        morseMap.put("u" , arr[0]);
        morseMap.put("v" , arr[0]);
        morseMap.put("w" , arr[0]);
        morseMap.put("x" , arr[0]);
        morseMap.put("y" , arr[0]);
        morseMap.put("z" , arr[0]);

    }


    public static void main(String[] args) {



        UniqueMorse obj = new UniqueMorse();
        String [] words = {"gin", "zen", "gig", "msg"};
        obj.uniqueMorseRepresentations(words);
    }
}
