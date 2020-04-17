package com.greatyun.algorithm.binaryTree;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Tree {

    private Node root;

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return this.root;
    }

    public void makeNode(int data , Node left , Node right) {
        Node node = new Node();
        node.setData(data);
        node.setLeft(left);
        node.setRight(right);
    }

}
