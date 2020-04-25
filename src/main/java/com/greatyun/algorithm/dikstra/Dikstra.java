package com.greatyun.algorithm.dikstra;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class Dikstra {

    // 경로를 나타낼 해쉬 맵 (특정노드의 인접경로는 HashMap 으로 구현한다)
    // 출발 노드가 어디가 될지 모르기 때문에 특정 출발 노드부터 파생되는 가격데이터를 저장하기 위해
    // HashMap 안에 HashMap 을 삽입한다.
    // 출발 노드가 정해지면 HashMap 안에 존재하는 HashMap 이 costMap 으로 치환된다.
    HashMap<String , HashMap<String , Integer>> pathMap;

    // 가격을 나타낼 해쉬 맵
    HashMap<String , Integer> costMap;

    // 경로의 부모를 표현할 해쉬 맵
    HashMap<String , String> parentMap;

    // 이미 참조한 노드인지 나타낼 해쉬 맵
    HashMap<String , String> proceedMap;

    public Dikstra() {
        pathMap = new HashMap<>();
        costMap = new HashMap<>();
        parentMap = new HashMap<>();
        proceedMap = new HashMap<>();
    }

    // 노드의 인접 경로를 만들어준다 from -> to path
    public void addPath(String nodeName , String abjacentNode , int cost) {
        HashMap<String, Integer> abjacentMap;
        if(pathMap.containsKey(nodeName)) {
            abjacentMap = pathMap.get(nodeName);
        } else {
            abjacentMap = new HashMap<>();
        }

        if(nodeName.equalsIgnoreCase("END")) {
            pathMap.put(nodeName , abjacentMap);
            parentMap.put(nodeName , null);
        } else {
            abjacentMap.put(abjacentNode , cost);
            pathMap.put(nodeName , abjacentMap);
            // 부모 해쉬 셋팅
            parentMap.put(abjacentNode , nodeName);
        }

    }



    // 노드 경로 확인 메소드
    public void checkPath() {
        Set keySet = pathMap.keySet();
        Iterator iterator = keySet.iterator();
        while(iterator.hasNext()) {
            String nodeName = (String) iterator.next();
            HashMap<String, Integer> costMap = pathMap.get(nodeName);
            Set inKeySet = costMap.keySet();
            Iterator inIter = inKeySet.iterator();
            while(inIter.hasNext()) {
                String inKey = (String) inIter.next();
                System.out.println("[" + nodeName + "] -> "+ inKey + " // " + costMap.get(inKey));
            }
        }
    }

    // 비용 경로 확인 메소드
    public void checkCost() {
        Set keySet = costMap.keySet();
        Iterator iterator = keySet.iterator();
        while(iterator.hasNext()) {
            String key = (String) iterator.next();
            System.out.println(key + " // " + costMap.get(key));
        }
    }

    // 최적경로 찾기 메소드
    public void findBestPath(String startNodeName) {
        /**
         * 1. 가격 해쉬 맵을 세팅 (출발 경로 기준에서 가격정보(HashMap) 를 가져와야 하기 때문에)
         *    왜냐면.. 출발 경로는 항상 변할 수 있으니까..
         */
        // 1. 가격 해쉬 맵
        costMap = pathMap.get(startNodeName);
        // loop 돌면서 경로간 가격비교를 위해서 Integer MAX Value 로 초기 세팅 (loop 안 소스 참고)
        costMap.put("END" , Integer.MAX_VALUE);

        checkCost();

        /* 1. 출발 노드 기준에서 움직일 수 있는 경로들 중 가장 싼 경로를 가져온다. */
        String node = findLowestCostNode(costMap);

        while( node != null ) {
            checkAllMap();
            // 가장 저렴한 노드의 비용을 가져온다
            Integer cost = costMap.containsKey(node) ?  costMap.get(node) : Integer.MAX_VALUE;

            System.out.println("target Node : " + node);
            // 해당 노드의 인접 경로를 가져온다.
            HashMap<String, Integer> neighbor = pathMap.get(node);
            Set keySet = neighbor.keySet();
            Iterator iterator = keySet.iterator();
            while(iterator.hasNext()) {
                String inNode = (String) iterator.next();
                int new_cost = cost + neighbor.get(inNode);
                System.out.println("inNode : " + inNode);
                int path_cost = costMap.containsKey(inNode) ? costMap.get(inNode) : Integer.MAX_VALUE;

                // 타겟 노드에서 인접노드로 가는 비용이
                // 나를 거쳐서온 비용보다 많다면..

                // 즉 출발지에서 나의 인접노드로 직접가는 비용과
                // 출발지에서 나를 거치고 인접노드로 가는 비용을 비교해서
                // 나를 거치고 인접노드로 가는 비용이 더 저렴하다면 인접노드로 가는 비용 Hash 를 업데이트 한다.
                if(path_cost > new_cost) {
                    costMap.put(inNode , new_cost);
                    parentMap.put(inNode , node);
                }
            }
            // 이미 살펴봤다고 표시
            proceedMap.put(node , node);
            node = findLowestCostNode(costMap);
        }

    }

    /**
     * 가장 저렴한 경로의 노드를 리턴
     * @param costMap
     */
    private String findLowestCostNode(HashMap<String, Integer> costMap) {
        Set keySet = costMap.keySet();
        Iterator iter = keySet.iterator();
        int before_cost = Integer.MAX_VALUE;
        String lowest_node = null;
        while(iter.hasNext()) {
            String node_name = (String) iter.next();
            // 아직 참조하지 않은 노드일때만 비용 비교
            if(!proceedMap.containsKey(node_name)) {
                Integer cost = costMap.get(node_name);
                if(before_cost > cost) {
                    before_cost = cost;
                    lowest_node = node_name;
                }
            }
        }
        return lowest_node;
    }

    public void checkAllMap() {
        System.out.println("----- Path Map -----");
        checkMap(pathMap);
        System.out.println("----- Cost Map -----");
        checkMap(costMap);
        System.out.println("----- Parent Map -----");
        checkMap(parentMap);
    }
    public void checkMap(HashMap map) {
        Set keySet = map.keySet();
        Iterator iterator = keySet.iterator();
        while(iterator.hasNext()) {
            String key = (String) iterator.next();
            System.out.println("[" + key + "] [" + map.get(key) + "]");
        }
    }

    public static void main(String[] args) {
        Dikstra obj = new Dikstra();

        obj.addPath("START" , "A" , 5);
        obj.addPath("START" , "B" , 1);
        obj.addPath("A" , "END" , 3);
        obj.addPath("B" , "A" , 2);
        obj.addPath("B" , "END" , 6);
        obj.addPath("END" , null , 0);

        /*
        obj.addPath("START" , "A" , 1);
        obj.addPath("START" , "C" , 8);
        obj.addPath("A" , "B" , 2);
        obj.addPath("B" , "C" , 3);
        obj.addPath("C" , "END" , 10);
        obj.addPath("END" , null , 0);
         */
//        obj.checkPath();

//        obj.checkMap(obj.parentMap);
//        obj.checkMap(obj.);
        obj.findBestPath("START");

        System.out.println("---- result ---- ");
        obj.checkMap(obj.parentMap);


    }
}
