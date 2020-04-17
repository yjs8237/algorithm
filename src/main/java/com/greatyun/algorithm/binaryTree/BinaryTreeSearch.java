package com.greatyun.algorithm.binaryTree;


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
        Node node = new Node();
        node.setData(data);
        node.setLeft(left);
        node.setRight(right);
        return node;
    }


    public void inorder(Node node) {
        if(node != null) {
            log.info("node data[" + node.getData() + "]");
            inorder(node.getLeft());
            inorder(node.getRight());
        }
    }

}
