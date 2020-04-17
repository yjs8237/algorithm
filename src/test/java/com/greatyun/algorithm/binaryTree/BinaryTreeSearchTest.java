package com.greatyun.algorithm.binaryTree;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class BinaryTreeSearchTest {

    @Autowired
    private BinaryTreeSearch binaryTreeSearch;

    @Test
    public void binarySearchTest() {
        Node node4 = binaryTreeSearch.makeNode(4, null, null);
        Node node2 = binaryTreeSearch.makeNode(2, node4, null);
        Node node3 = binaryTreeSearch.makeNode(3, null, null);
        Node node = binaryTreeSearch.makeNode(1, node2, node3);
        binaryTreeSearch.setRoot(node);
        binaryTreeSearch.inorder(binaryTreeSearch.getRoot());
    }

}