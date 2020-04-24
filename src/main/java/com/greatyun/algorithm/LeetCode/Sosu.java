package com.greatyun.algorithm.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Sosu {

    HashMap<Integer , Integer> map = new HashMap<>();
    List<Node> nodeList = new ArrayList<>();

    class Node {
        LinkedList<Node> abjacent;
        char data;
        boolean isMarked;
        public Node(char data) {
            this.data = data;
            abjacent = new LinkedList<>();
            isMarked = false;
        }
    }

    public int solution(String numbers) {
        int answer = 0;
        char[] charArr = numbers.toCharArray();
        
        initNode(charArr);

        System.out.println();
        for (Node node : nodeList) {
            String targetData = String.valueOf(node.data);
            for (Node inNode : node.abjacent) {
                targetData += String.valueOf(inNode.data);
            }
            System.out.println("targetData -> " + targetData);
        }


        return answer;
    }

    private void initNode(char[] charArr) {
        for (int i = 0; i < charArr.length; i++) {
            Node node = new Node(charArr[i]);
            int targetIndex = i + 1;
            int abjacentCount = 0;
            while(true) {
                if(abjacentCount == charArr.length - 1) {
                    break;
                }
                if(targetIndex >= charArr.length) {
                    targetIndex = 0;
                }
                Node abjacentNode = new Node(charArr[targetIndex]);
                node.abjacent.add(abjacentNode);
                System.out.println(charArr[i] + " abjacent -> " + charArr[targetIndex]);
                targetIndex ++;
                abjacentCount ++;
            }
            nodeList.add(node);
        }
    }

    public boolean isSosu(int number) {
        System.out.println("sosu check : " + number);
        if(number == 0 || number == 1) return false;
        if(!map.containsKey(number)) {
            map.put(number , number);
            for (int i = 2; i < number; i++)  {
                if(number % i == 0) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }


    public static void main(String [] args) {
        Sosu sosu = new Sosu();
        String numbers = "0101";
        System.out.println("result : " + sosu.solution(numbers));
    }
}
