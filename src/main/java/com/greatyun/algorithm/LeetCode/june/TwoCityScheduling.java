package com.greatyun.algorithm.LeetCode.june;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TwoCityScheduling {

    class City {
        int index;
        int cost;
        public City(int index , int cost) {
            this.index = index;
            this.cost = cost;
        }
    }

    public int twoCitySchedCost(int[][] costs) {
        int ret = 0;
        PriorityQueue<City> queue_1 = new PriorityQueue<>((a,b) -> a.cost > b.cost ? 1 : -1);
        PriorityQueue<City> queue_2 = new PriorityQueue<>((a,b) -> a.cost > b.cost ? 1 : -1);
        for(int i=0; i<costs.length; i++) {
            City city = new City(i , costs[i][0]);
            queue_1.offer(city);
            city = new City(i , costs[i][1]);
            queue_2.offer(city);
        }

        int size = costs.length / 2;
        int count = 0;
        Map<Integer , Integer> map = new HashMap<>();
        while(true) {
            if(count == costs.length) break;
            City poll = queue_1.poll();
            if(count < size) {
                //System.out.println("first : " + poll.cost);
                ret += poll.cost;
                map.put(poll.index , poll.index);
                count++;
            } else {
                City poll1 = queue_2.poll();
                if(!map.containsKey(poll1.index)) {
                    //System.out.println("second : " + poll1.cost);
                    ret += poll1.cost;
                    count++;
                }
            }
        }
        //System.out.println(ret);
        return ret;
    }

    public static void main(String[] args) {
        TwoCityScheduling obj = new TwoCityScheduling();
        int [][] costs = {{10,20} , {30,200} , {400,50} , {30,20}};
        obj.twoCitySchedCost(costs);
    }
}
