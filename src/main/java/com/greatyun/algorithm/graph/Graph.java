package com.greatyun.algorithm.graph;

import java.util.LinkedList;
import java.util.Stack;

public class Graph {

    Node [] nodes;
    Graph (int size) {
        nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    void addEdge(int i1 , int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        if(!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }
        if(!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }

    void dfs() {
        dfs(0);
    }

    void dfs(int index) {
        Node node = nodes[index];
        Stack<Node> stack = new Stack<Node>();
        stack.push(node);
        node.marked = true;
        while(!stack.empty()) {
            Node node1 = stack.pop();
            for (Node inNode : node1.adjacent) {
                if(!inNode.marked) {
                    inNode.marked = true;
                    stack.push(inNode);
                }
            }
            visit(node1);
        }
    }

    void bfs(int index) {
        Node root = nodes[index];
        Queue<Node> queue = new Queue<Node>();
        queue.enqueue(root);
        root.marked = true;
        while(!queue.isEmpty()) {
            Node dequeue = queue.dequeue();
            for (Node inNode : dequeue.adjacent) {
                if(!inNode.marked) {
                    inNode.marked = true;
                    queue.enqueue(inNode);
                }
            }
            visit(root);
        }
    }




    void dfsR(Node root) {
        if(root == null) return;
        root.marked = true;
        visit(root);
        for (Node inNode : root.adjacent) {
            if(!inNode.marked) {
                dfsR(inNode);
            }
        }
    }

    void bfs() {
        bfs(0);
    }



    void visit(Node node) {
        System.out.println("node data : " + node.data);
    }

    class Node {
        int data;
        LinkedList<Node> adjacent;
        boolean marked;
        Node (int data) {
            this.data = data;
            this.marked = false;
            this.adjacent = new LinkedList<Node>();
        }

    }

}
