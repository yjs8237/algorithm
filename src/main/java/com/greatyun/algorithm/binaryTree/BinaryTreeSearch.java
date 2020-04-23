package com.greatyun.algorithm.binaryTree;


import com.greatyun.algorithm.LeetCode.ConstructBinarySearchTreefromPreorderTraversal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BinaryTreeSearch {

    private Node root;

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return this.root;
    }

    public Node makeNode(int data , Node left , Node right) {
        Node node = new Node(data);
        node.setData(data);
        node.setLeft(left);
        node.setRight(right);
        return node;
    }

    /**
     * 주어진 정렬이 되어 있는 배열로 이진트리 구성하는 메소드
     * @param a
     * @param start
     * @param end
     * @return
     */
    public Node makeTree(int [] a , int start , int end) {
        if(start > end) return  null;
        int mid = (start + end) / 2;
        Node node = new Node(a[mid]);
        node.setLeft(makeTree(a , start , mid - 1));
        node.setRight(makeTree(a , mid +1  , end));
        return node;
    }


    public void inorder(Node node) {
        if(node != null) {
            log.info("node data[" + node.getData() + "]");
            inorder(node.getLeft());
            inorder(node.getRight());
        }
    }

    public Node searchNode(int data) {
        return search(root , data);
    }

    /**
     * Binary Tree 검색
     * 이진트리가 루트 기준으로 왼쪽은 작은 값 , 오른쪽은 큰 값 으로 트리가 구성되어 있다는 가정하에
     * 아래 메소드는 정상동작한다.
     * @param root
     * @param data
     * @return
     */
    private Node search(Node root, int data) {
        if(root == null ) return null;
        while(true) {
            if(root.getData() == data) {
                // 검색 노드 찾음
                return root;
            }
            if(root.getData() > data) {
                // 자신의 데이터가 더 크다면 찾고자 하는 노드는 내 기준으로 왼쪽에 있다.
                root = root.getLeft();
            } else {
                // 자신의 데이터가 더 작다면 찾고자 하는 노드는 내 기준으로 오른쪽에 있다.
                root = root.getRight();
            }
        }
    }

}
