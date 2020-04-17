package com.greatyun.algorithm.binaryTree;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class BinaryTreeSearchTest {

    @Autowired
    private BinaryTreeSearch binaryTreeSearch;

    @Test
    public void binarySearchTest() {

        /**
         *              (4)
         *             /  \
         *          (3)  (5)
         *         /
         *      (2)
         *
         */

        Node node4 = binaryTreeSearch.makeNode(2, null, null);
        Node node2 = binaryTreeSearch.makeNode(3, node4, null);
        Node node3 = binaryTreeSearch.makeNode(5, null, null);
        Node node = binaryTreeSearch.makeNode(4, node2, node3);
        binaryTreeSearch.setRoot(node);
        binaryTreeSearch.inorder(binaryTreeSearch.getRoot());

        Node searchNode = binaryTreeSearch.searchNode(5);

        assertThat(searchNode.getData()).isEqualTo(node3.getData());
        assertThat(searchNode.getLeft()).isNull();
        assertThat(searchNode.getRight()).isNull();
    }

}