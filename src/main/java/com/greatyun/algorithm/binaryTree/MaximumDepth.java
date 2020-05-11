package com.greatyun.algorithm.binaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumDepth {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        if(root == null) return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int max_depth = Integer.MIN_VALUE;
        int depth = 0;
        while(!queue.isEmpty()) {
            depth++;
            if(max_depth < depth) {
                max_depth = depth;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                if(poll.children != null) {
                    for (int j = 0; j < poll.children.size(); j++) {
                        queue.offer(poll.children.get(j));
                    }
                }
            }
        }

        System.out.println("max_depth : " + max_depth);
        return max_depth;
    }

    public static void main(String[] args) {

    }
}
