package com.greatyun.algorithm.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Dfs {

    class Node<T> {
        int data;
        LinkedList<T> adjacent;
        boolean isMarked;
        Node(int data) {
            this.data = data;
            this.adjacent = new LinkedList<T>();
            isMarked = false;
        }
    }

    List<Node> nodeList = new ArrayList<>();

    public Dfs(int length) {
        for (int i = 0; i < length; i++) {
            Node node = new Node(i);
            nodeList.add(node);
        }
    }

    public Node getRoot() {
        return  nodeList.get(0);
    }

    public void addNode(int index1 , int index2) {
        /**
         * 노드 간 연결 상태를 확립한다.
         */
        Node node1 = nodeList.get(index1);
        Node node2 = nodeList.get(index2);
        if(node1 == null || node2 == null) {
            return;
        }
        if(node1 != null && !node1.adjacent.contains(node2)) {
            node1.adjacent.add(node2);
        }
        if(node2 != null && !node2.adjacent.contains(node1)) {
            node2.adjacent.add(node1);
        }
    }

    public void searchDFS(int start) {
        // 최초 탐색을 시작하는 index  -> 이건 0 이 아니여도 상관없다.
        Node root = nodeList.get(start);
        if(root != null) {
            // DFS 구현을 할 Stack 생성
            Stack<Node> stack = new Stack<Node>();
            // Stack 에 넣었는지 구분할 flag ( 이 Flag 로 이미 참조한 노드인지 아닌지 판단한다 )
            root.isMarked = true;
            // 일단 최초 시작이니 시작노드는 stack 에 push
            stack.push(root);

            // stack 이 비어있지 않을떄까지 무한루프
            while(!stack.empty()) {

                Node targetNode = stack.pop();
                System.out.println("target node [" + targetNode.data + "]");

                // Stack 에서 꺼낸 노드의 인접 노드를 돌아보고 참조한 노드인지 아닌지 판단한다.
                // 만일 참조안한 노드라면 stack 에 push
                // 참조한 노드라면 그냥 Pass
                for (int i = 0; i < targetNode.adjacent.size(); i++) {
                    Node tempNode = (Node) targetNode.adjacent.get(i);
                    if(!tempNode.isMarked) {
                        tempNode.isMarked = true;
                        stack.push(tempNode);
                        System.out.println("adjacent node [" + tempNode.data + "] stack push!!");
                    } else {
                        System.out.println("adjacent node [" + tempNode.data + "] is already marked!!");
                    }
                }   // end for

                // 인접 노드 참조여부 탐색이 끝나면 타겟 노드의 데이터를 확인한다.
                //System.out.println("node [" + targetNode.data + "]" );
            }   // end while

        }
    }

    /**
     * DFS 재귀 구현
     * @param root
     */
    void searchDfsR(Node root) {
        if(root == null) return;
        root.isMarked = true;
        System.out.println("target Node data [" + root.data + "]");
        for (int i = 0; i < root.adjacent.size(); i++) {
            Node inNode = (Node) root.adjacent.get(i);
            if(!inNode.isMarked) {
                searchDfsR(inNode);
            }
        }
    }


    public static void main (String []args) {
        Dfs dfs = new Dfs(4);
        dfs.addNode(0 , 1);
        dfs.addNode(0 , 2);
        dfs.addNode(1 , 2);
        dfs.addNode(1 , 3);
        dfs.addNode(2 , 3);
        dfs.addNode(2 , 1);
        dfs.addNode(3 , 1);
        dfs.addNode(3 , 2);
//        dfs.searchDFS(0);


        dfs.searchDfsR(dfs.getRoot());
    }




}
