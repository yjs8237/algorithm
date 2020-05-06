package com.greatyun.algorithm.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
            children = new ArrayList<>();
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**
     * 트리 재귀를 호출할때 preorder 등등 탐색 기법은
     * 자식노드를 어떻게 호출하느냐에 따른 방법만 다를뿐
     * 재귀 호출 방식은 동일하다..
     *
     * 이진트리는 left right 로 제한되어 있어서
     * 재귀 호출을
     * method(root.left)
     * method(root.right)
     * 이렇게 호출하지만
     *
     * 만약 자식노드가 많다면.. 이진트리가 아니라면
     * 위 두 메소드 대신 for 문을 돌리면 된다..
     *
     * 아래 처럼..
     */
    List<Integer> re = new ArrayList<>();
    public List<Integer> preorderBest(Node n) {
        if(n==null)
            return re;
        re.add(n.val);
        for(Node nn : n.children)
            preorderBest(nn);
        return re;
    }

    public List<Integer> postorderBest(Node n) {
        if(n==null)
            return re;
        for(Node nn : n.children)
            postorderBest(nn);
        re.add(n.val);
        return re;
    }



    public List<Integer> preorder(Node root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null) return ret;
        postorderV2(root , ret);
        return ret;
    }

    public void preorderV2(Node root , List<Integer> ret) {

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            Node pop = stack.pop();
            ret.add( pop.val);
            if(pop.children != null) {
                for (int i = pop.children.size() - 1; i >= 0; i--) {
                    stack.push(pop.children.get(i));
                }
            }
        }
        for (Integer node : ret) {
            System.out.print(" " + node);
        }
    }

    public void postorderV2(Node root , List<Integer> ret) {

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            Node pop = stack.pop();
            ret.add( 0 , pop.val);
            if(pop.children != null) {
                for (int i = 0; i < pop.children.size(); i++) {
                    stack.push(pop.children.get(i));
                }
            }
        }
        for (Integer node : ret) {
            System.out.print(" " + node);
        }
    }

    public static void main(String[] args) {
        PreorderTraversal obj = new PreorderTraversal();

        List<Node> _children = new ArrayList<>();
        Node node1 = new Node(3);
        Node node2 = new Node(2);
        Node node3 = new Node(4);
        _children.add(node1);
        _children.add(node2);
        _children.add(node3);
        Node root = new Node(1 , _children);
        List<Integer> integers = obj.preorderBest(root);
        for (Integer integer: integers) {
            System.out.println(" " + integer);
        }
    }
}
